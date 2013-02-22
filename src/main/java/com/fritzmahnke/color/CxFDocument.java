package com.fritzmahnke.color;

import java.util.List;
import java.util.ArrayList;

public class CxfDocument {
    private String sampleId;
    private String sampleName;
    private CMYKCoord cmykCoord;
    private LabCoord labCoord;
    private List<ColorObject> objectCollection =
	new ArrayList<ColorObject>();

    public String getSampleId() {
	return sampleId;
    }

    public String getSampleName() {
	return sampleName;
    }

    public CMYKCoord getCmykCoord() {
	return cmykCoord;
    }

    public LabCoord getLabCoord() {
	return labCoord;
    }

    public void addObject(ColorObject colorObject) {
	objectCollection.add(colorObject);
    }

    /**
     * Create a tabulated representation of the sample
     */
    /*
    public static String toTable(List<CxFDocument> samples) {
	List<String> elementNames = new ArrayList<String>();
	
	StringBuilder table = new StringBuilder();

	// Build list of headers
	for (CxFDocument sample : samples) {
	    for (IElement element : sample.getElements()) {
		List<Attribute> attributes = element.getAttributes();
		
		for (Attribute attribute : attributes) {
		    String name = (String) attribute.getName();
		    
		    if (! elementNames.contains(name)) {
			elementNames.add(name);
			table.append(name + "\t");
		    }
		}
	    }
	}
	table.append("\n");

	for (CxFDocument sample : samples) {
	    for (IElement element : sample.getElements()) {
		List<Attribute> attributes = element.getAttributes();
		
		for (String name : elementNames) {
		    Attribute attribute = element.findAttribute(name);
		    if (attribute != null) {
			Double value = (Double) attribute.getValue();
			table.append(value + "\t");
		    }
		}
	    }
	    table.append("\n");
	}

	return table.toString();
    }
    */

    public static CxfDocument average(List<CxfDocument> samples) {
	double sumL = 0;
	double sumA = 0;
	double sumB = 0;

	// Take common data from first sample for now
	CMYKCoord masterCMYK = samples.get(0).getCmykCoord();
	String masterSampleId = samples.get(0).getSampleId();
	String masterName = samples.get(0).getSampleName();
	
	// Average all samples in our list
	for (CxfDocument sample : samples) {
	    LabCoord labCoord = sample.getLabCoord();
	    sumL += labCoord.getL();
	    sumA += labCoord.getA();
	    sumB += labCoord.getB();
	}
	double avgL = sumL / samples.size();
	double avgA = sumA / samples.size();
	double avgB = sumB / samples.size();
	avgL = Math.round(avgL, 4);
	avgA = Math.round(avgA, 4);
	avgB = Math.round(avgB, 4);

	return new CxfDocument(masterSampleId, masterName, masterCMYK.getC(),
			       masterCMYK.getM(), masterCMYK.getM(),
			       masterCMYK.getM(), avgL, avgA, avgB);
    }

    public CxfDocument() {
    }

    public CxfDocument(String id, String name, double c, double m, double y,
		       double k, double l, double a, double b) {
	this.sampleId = id;
	this.sampleName = name;
	this.cmykCoord = new CMYKCoord(c, m, y, k);
	this.labCoord = new LabCoord(l, a, b);
    }

    @Override
    public String toString() {
	return "Not yet implemented.";
    }
}

