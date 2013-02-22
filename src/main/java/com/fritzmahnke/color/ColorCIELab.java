package com.fritzmahnke.color;

/**
 * A ColorCIELab element.
 */
public class ColorCIELab extends CxfElement {
    public ColorCIELab(String id, ColorSpecification spec, double L, double a,
		       double b) {
	super("ColorCIELab");
	setAttribute("id", id);
	CxfElement elementL = new CxfElement("L");
	elementL.setText(Double.toString(L));
	addChild(elementL);
	CxfElement elementA = new CxfElement("A");
	elementA.setText(Double.toString(a));
	addChild(elementA);
	CxfElement elementB = new CxfElement("B");
	elementB.setText(Double.toString(b));
	addChild(elementB);
    }
}

