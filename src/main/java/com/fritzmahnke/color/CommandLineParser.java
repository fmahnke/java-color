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

	List<CxfDocument> samples1 = new ArrayList<CxfDocument>();
	List<CxfDocument> samples2 = new ArrayList<CxfDocument>();

	samples1 = refs.get(0).getSamples();
	samples2 = refs.get(1).getSamples();

	List<CxfDocument> results = new ArrayList<CxfDocument>();

	// Use samples1 as the master
	// @todo Need to handle dissimilar sample sizes

	for (int sample = 0; sample < samples1.size(); ++sample) {

	    //LabCoord lab1 = samples1.get(sample).getLabCoord();
	    //LabCoord lab2 = samples2.get(sample).getLabCoord();
	    //LabCoord dLab = dE1976.dLab(lab1, lab2);
	    
	    /*
	    double dE = CxfDocument.dE1976(samples1.get(sample),
					   samples2.get(sample));
					   */
	    CxfDocument result = new CxfDocument();
	    //IElement colorValues = ColorValues.colorCieLab(lab1.getL(), lab1.getA(), lab1.getB());
	    //IElement colorDiff = ColorDifferenceValues.colorDifferenceValues(dLab, dE);
	    //result.addElement(colorValues);
	    //result.addElement(colorDiff);

	    results.add(result);
	}

	//System.out.println(CxfDocument.toTable(results));
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

