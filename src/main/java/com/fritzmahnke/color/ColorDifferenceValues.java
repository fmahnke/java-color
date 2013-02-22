package com.fritzmahnke.color;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

public class ColorDifferenceValues<K> {

    public static IElement colorDifferenceValues(LabCoord dLab, double dE1976) {
	double l = dLab.getL();
	double a = dLab.getA();
	double b = dLab.getB();

	Map<String, Double> map = new LinkedHashMap<String, Double>();
	map.put("dL", l);
	map.put("dA", a);
	map.put("dB", b);
	map.put("dE1976", dE1976);
	IElement element = new CxfElement(map);

	return element;
    }
}

