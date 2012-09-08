package com.fritzmahnke.color;

import java.lang.Math;

public class Chroma
{
    public static double chroma(double a, double b)
    {
	return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public static double chroma(Lab lab)
    {
	return chroma(lab.a, lab.b);
    }
}
