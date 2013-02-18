package com.fritzmahnke.color;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.JCommander;
 
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import java.util.List;
import java.util.ArrayList;

public class CommandLineParser {
      //@Parameter
//	    private List<String> parameters = new ArrayList<String>();
      /* 
        @Parameter(names = { "-log", "-verbose" }, description = "Level of verbosity")
	      private Integer verbose = 1;
	 
	  @Parameter(names = "-groups", description = "Comma-separated list of group names to be run")
	        private String groups;
	   
	    @Parameter(names = "-debug", description = "Debug mode")
		  private boolean debug = false;
		  */
    @Parameter(description = "Command")
	private List<String> command = new ArrayList<String>();

    @Parameter(names = "--files", variableArity = true)
	public List<String> files = new ArrayList<String>();

    public static void main(String[] args) {
	CommandLineParser clp = new CommandLineParser();
	new JCommander(clp, args);

	// Process first command
	String command = clp.command.get(0);

	if (command.compareToIgnoreCase("difference") == 0) {
	    callDifference(clp.files);
	} else if (command.compareToIgnoreCase("average") == 0) {
	    callAverage(clp.files);
	}
    }

    public static List<InputStream> openFiles(List<String> files) {
	System.out.println("Verifying existence of files:");
	List<InputStream> iStreams = new ArrayList<InputStream>();

	for (String filename : files) {
	    System.out.println(filename);
	    File file = new File(filename);
	    System.out.println("Exists:" + file.exists());
	    try {
		iStreams.add(new FileInputStream(file));
	    } catch (FileNotFoundException e) {
		e.printStackTrace();
	    }
	}

	return iStreams;
    }

    public static void callDifference(List<String> files) {
	// @todo Handle more than two files
	List<InputStream> iStreams = openFiles(files);

	List<Reference> refs = new ArrayList<Reference>();

	// @todo Move the copy and paste code
	for (InputStream is : iStreams) {
	    try {
		Reference ref = new CgatsReference(is);
		refs.add(ref);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	List<ColorSample> samples1 = new ArrayList<ColorSample>();
	List<ColorSample> samples2 = new ArrayList<ColorSample>();

	samples1 = refs.get(0).getSamples();
	samples2 = refs.get(1).getSamples();

	List<Double> dEList = new ArrayList<Double>();

	// Use samples1 as the master
	// @todo Need to handle disimmilar sample sizes

	for (int sample = 0; sample < samples1.size(); ++sample) {
	    double dE = ColorSample.dE1976(samples1.get(sample),
					   samples2.get(sample));
	    dEList.add(dE);
	}

	System.out.println(dEList.toString());
    }

    public static void callAverage(List<String> files) {
	List<InputStream> iStreams = openFiles(files);
	
	List<Reference> refs = new ArrayList<Reference>();

	for (InputStream is : iStreams) {
	    try {
		Reference ref = new CgatsReference(is);
		refs.add(ref);
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}

	Reference average = CgatsReference.averageReference(refs);

	System.out.println(average.toString());
    }
}

