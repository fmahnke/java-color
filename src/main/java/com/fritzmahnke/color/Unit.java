package com.fritzmahnke.color;

import java.lang.Math;

/**
 * Unit conversions for colors.
 */
public class Unit
{
    /**
     * Calculate the chroma of the given a*, b* values.
     */
    public static double C_ab(double a, double b)
    {
	return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    /**
     * Calculate the chroma from the a*, b* values in the given Lab
     * structure.
     */
    public static double C_ab(Lab lab)
    {
	return C_ab(lab.a, lab.b);
    }
}
