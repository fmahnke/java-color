package com.fritzmahnke.color;

import java.util.Map;
import java.util.LinkedHashMap;

public class ColorValues extends CxfElement<String, Double> {

    public void addColorCIELab(ColorCIELab colorCIELab) {
	addChild(colorCIELab);
    }

    public ColorValues() {
	super("ColorValues");
    }

    public static IElement<String, Double> colorCieLab(double l, double a, double b) {
	Map<String, Double> map = new LinkedHashMap<String, Double>();
	map.put("L", l);
	map.put("a", a);
	map.put("b", b);
	IElement<String, Double> element = new CxfElement<String, Double>(map);

	return element;
    }
}

