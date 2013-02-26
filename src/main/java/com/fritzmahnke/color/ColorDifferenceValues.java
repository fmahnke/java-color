package com.fritzmahnke.color;

/**
 * ColorDifferenceValues element.
 * 
 * @author Fritz Mahnke
 *
 */
public class ColorDifferenceValues extends CxfElement<String, Double> {

    public ColorDifferenceValues() {
	super("ColorDifferenceValues");
    }
    
    public ColorDifferenceValues(ColorCIELab lab1, ColorCIELab lab2) {
	super("ColorDifferenceValues");
	
	double l1 = Double.parseDouble(lab1.findChild("L").getText());
	double a1 = Double.parseDouble(lab1.findChild("A").getText());
	double b1 = Double.parseDouble(lab1.findChild("B").getText());
	double l2 = Double.parseDouble(lab2.findChild("L").getText());
	double a2 = Double.parseDouble(lab2.findChild("A").getText());
	double b2 = Double.parseDouble(lab2.findChild("B").getText());
	
	LabCoord dLab = dE1976.dLab(new LabCoord(l1, a1, b1), new LabCoord(l2, a2, b2));
	ColorDifferenceValues diffVal = new ColorDifferenceValues();
	IElement<?, ?> deltaCIELab = new CxfElement<String, String>("DeltaCIELab");
	IElement<String, String> dL = new CxfElement<String, String>("dL");
	IElement<String, String> da = new CxfElement<String, String>("da");
	IElement<String, String> db = new CxfElement<String, String>("db");
	
	deltaCIELab.addChild(dL);
	deltaCIELab.addChild(da);
	deltaCIELab.addChild(db);
	diffVal.addChild(deltaCIELab);
	
	dL.setText(Double.toString(dLab.getL()));
	da.setText(Double.toString(dLab.getA()));
	db.setText(Double.toString(dLab.getB()));
    }
}

