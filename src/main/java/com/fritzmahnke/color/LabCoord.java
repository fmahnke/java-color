package com.fritzmahnke.color;

/**
 * Stores a coordinate in CIELab color space
 * @author fmahnke
 *
 */
public class LabCoord {
	
	/** L* component */
	private double L;
	
	/** a* component */
	private double a;
	
	/** b* component */
	private double b;
	
	public double getL() {
		return L;
	}
	
	public double getA() {
		return a;
	}
	
	public double getB() {
		return b;
	}
	
	public LabCoord(double l, double a, double b) {
		this.L = l;
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return getL() + "\t" + getA() + "\t" + getB();
	}
}
