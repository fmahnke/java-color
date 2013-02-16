package com.fritzmahnke.color;

import java.util.List;

public class ColorSample {
    private String sampleId;
    private String sampleName;
    private CMYKCoord cmykCoord;
    private LabCoord labCoord;

    public LabCoord getLabCoord() {
	return labCoord;
    }

    public static ColorSample average(List<ColorSample> samples) {
	double sumL = 0;
	double sumA = 0;
	double sumB = 0;

	for (ColorSample sample : samples) {
	    LabCoord labCoord = sample.getLabCoord();
	    sumL += labCoord.getL();
	    sumA += labCoord.getA();
	    sumB += labCoord.getB();
	}
	double avgL = sumL / samples.size();
	double avgA = sumA / samples.size();
	double avgB = sumB / samples.size();

	return new ColorSample("", "", 0, 0, 0, 0, avgL, avgA, avgB);
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

