package com.fritzmahnke.color;

/**
 * A ColorCIELab element.
 */
public class ColorCIELab extends Element {
    public ColorCIELab(String id, ColorSpecification spec, double L, double a,
		       double b) {
	super("ColorCIELab");
	setAttribute("id", id);
	Element elementL = new Element("L");
	elementL.setText(Double.toString(L));
	addChild(elementL);
	Element elementA = new Element("A");
	elementA.setText(Double.toString(a));
	addChild(elementA);
	Element elementB = new Element("B");
	elementB.setText(Double.toString(b));
	addChild(elementB);
    }
}

