package com.fritzmahnke.color;

/**
 * A ColorCIELab element.
 */
public class ColorCIELab extends CxfElement<String, String> {
    public ColorCIELab(String id, ColorSpecification spec, double L, double a,
		       double b) {
	super("ColorCIELab");
	setAttribute("id", id);
	IElement<String, String> elementL = new CxfElement<String, String>("L");
	elementL.setText(Double.toString(L));
	addChild(elementL);
	IElement<String, String> elementA = new CxfElement<String, String>("A");
	elementA.setText(Double.toString(a));
	addChild(elementA);
	IElement<String, String> elementB = new CxfElement<String, String>("B");
	elementB.setText(Double.toString(b));
	addChild(elementB);
    }
}

