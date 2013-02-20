package com.fritzmahnke.color;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

public class ColorValues extends Element {

    public void addColorCIELab(ColorCIELab colorCIELab) {
	addChild(colorCIELab);
    }

    public ColorValues() {
	super("ColorValues");
    }

    public static IElement colorCieLab(double l, double a, double b) {
	Map<String, Double> map = new LinkedHashMap<String, Double>();
	map.put("L", l);
	map.put("a", a);
	map.put("b", b);
	IElement element = new Element(map);

	return element;
    }
}

