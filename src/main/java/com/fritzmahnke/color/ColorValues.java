package com.fritzmahnke.color;

import java.util.Map;
import java.util.LinkedHashMap;

public class ColorValues extends CxfElement<String, Double> {

    public void addColorCIELab(ColorCIELab colorCIELab) {
	addChild(colorCIELab);
    }

    public ColorValues() {
	super(Constants.COLOR_VALUES);
    }
}

