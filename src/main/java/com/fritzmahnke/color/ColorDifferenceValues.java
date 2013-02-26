package com.fritzmahnke.color;

import java.util.Map;
import java.util.LinkedHashMap;

public class ColorDifferenceValues extends CxfElement<String, Double> {

    public ColorDifferenceValues() {
	super("ColorDifferenceValues");
    }
    
    public static IElement<String, Double> colorDifferenceValues(LabCoord dLab, double dE1976) {
	double l = dLab.getL();
	double a = dLab.getA();
	double b = dLab.getB();

	Map<String, Double> map = new LinkedHashMap<String, Double>();
	map.put("dL", l);
	map.put("dA", a);
	map.put("dB", b);
	map.put("dE1976", dE1976);
	IElement<String, Double> element = new CxfElement<String, Double>(map);

	return element;
    }
}

