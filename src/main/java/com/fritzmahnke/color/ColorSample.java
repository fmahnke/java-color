package com.fritzmahnke.color;

import java.util.List;

public class ColorSample {
    private String sampleId;
    private String sampleName;
    private CMYKCoord cmykCoord;
    private LabCoord labCoord;
    private List<ColorObjectElement> colorObjectElements;

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

    /**
     * Calculate dE1976 between two samples
     */
    public static double dE1976(ColorSample sample1, ColorSample sample2) {
	LabCoord lab1 = sample1.getLabCoord();
	LabCoord lab2 = sample2.getLabCoord();

	return dE1976.dE1976(lab1, lab2);
    }

    public static ColorSample average(List<ColorSample> samples) {
	double sumL = 0;
	double sumA = 0;
	double sumB = 0;

	// Take common data from first sample for now
	CMYKCoord masterCMYK = samples.get(0).getCmykCoord();
	String masterSampleId = samples.get(0).getSampleId();
	String masterName = samples.get(0).getSampleName();
	
	// Average all samples in our list
	for (ColorSample sample : samples) {
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

	return new ColorSample(masterSampleId, masterName, masterCMYK.getC(),
			       masterCMYK.getM(), masterCMYK.getM(),
			       masterCMYK.getM(), avgL, avgA, avgB);
    }

    public ColorSample(String id, String name, double c, double m, double y,
		       double k, double l, double a, double b) {
	this.sampleId = id;
	this.sampleName = name;
	this.cmykCoord = new CMYKCoord(c, m, y, k);
	this.labCoord = new LabCoord(l, a, b);
    }

    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append(sampleId + "\t" + sampleName + "\t" +
	           cmykCoord.toString() + "\t" + labCoord.toString() + "\n");

	return str.toString();
    }
}

