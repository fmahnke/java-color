package com.fritzmahnke.color;

/**
 * Stores a coordinate in CMYK color space
 * 
 * @author fmahnke
 *
 */
public class CMYKCoord {

	/** C value */
	private double c;
	
	/** M value */
	private double m;
	
	/** Y value */
	private double y;
	
	/** K value */
	private double k;
	
	/** C-tor */
	public CMYKCoord(double c, double m, double y, double k) {
		this.c = c;
		this.m = m;
		this.y = y;
		this.k = k;
	}

	public double getC() {
		return c;
	}

	public double getM() {
		return m;
	}

	public double getY() {
		return y;
	}

	public double getK() {
		return k;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(c + "\t" + m + "\t" + y + "\t" + k);

		return str.toString();
	}
}
