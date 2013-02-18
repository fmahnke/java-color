package com.fritzmahnke.color;

public class ColorDifferenceValues implements ColorObjectElement {
    private ElementAttribute dL;
    private ElementAttribute da;
    private ElementAttribute db;
    private ElementAttribute dE1976;

    public ColorDifferenceValues(LabCoord dLab, double dE1976) {
	double l = dLab.getL();
	double a = dLab.getA();
	double b = dLab.getB();
	this.dL = new ElementAttribute<String, Double>("dL", l);
	this.da = new ElementAttribute<String, Double>("dA", a);
	this.db = new ElementAttribute<String, Double>("dB", b);
	this.dE1976 = new ElementAttribute<String, Double>("dE1976", dE1976);
    }
}

