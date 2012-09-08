package com.fritzmahnke.color;

import java.lang.Math;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static double chroma(double a, double b)
    {
	return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public static double chroma(Lab lab)
    {
	return chroma(lab.a, lab.b);
    }

    public static double gFactor(double meanC)
    {
	final double gConst = Math.pow(25, 7);

	double gFactor =
	    0.5 * (1 - Math.sqrt(Math.pow(meanC, 7) /
				(Math.pow(meanC, 7) + gConst)));
	return gFactor;
    }

    public static double aPrime(double a, double g)
    {
	return (1 + g) * a;
    }

    public static double cPrime(double aPrime, double b)
    {
	return Math.sqrt(Math.pow(aPrime, 2) + Math.pow(b, 2));
    }

    public static double hPrime(double aPrime, double b)
    {
	double hPrime = 0;

	if (aPrime != 0 && b != 0)
	{
	    hPrime = Math.toDegrees(Math.atan2(aPrime, b));

	    if (b < 0)
	    {
		hPrime += 360;
	    }
	}

	return hPrime;
    }

    public static double dhCond(double hPrime2, double hPrime1)
    {
	double dhCond = 0;

	if ((hPrime2 - hPrime1) > 180)
	{
	    dhCond = 1;
	}
	else if ((hPrime2 - hPrime1) < -180)
	{
	    dhCond = 2;
	}

	return dhCond;
    }

    public static double dhPrime(double dhCond, double hPrime2, double hPrime1)
    {
	double dhPrime = 0;

	if (dhCond == 0)
	{
	    dhPrime = hPrime2 - hPrime1;
	}
	else
	{
	    if (dhCond == 1)
	    {
		dhPrime = hPrime2 - hPrime1 - 360;
	    }
	    else
	    {
		dhPrime = hPrime2 - hPrime1 + 360;
	    }
	}

	return dhPrime;
    }

    public static double dHPrime(double CPrime1, double CPrime2, double dhPrime)
    {
	double dHPrime = 2 * Math.sqrt((CPrime1 * CPrime2) * Math.sin(Math.toRadians(dhPrime / 2)));

	return dHPrime;
    }

    public static double hMean(double CPrime1, double CPrime2, double hPrime2, double hPrime1)
    {
	double hMean = 0;

	if ((CPrime1 * CPrime2) == 0)
	{
	    hMean = 3;
	}
	else
	{
	    if (Math.abs(hPrime2 - hPrime1) <= 180)
	    {
		hMean = 0;
	    }
	    else
	    {
		if ((hPrime2 + hPrime1) < 360)
		{
		    hMean = 1;
		}
		else
		{
		    hMean = 2;
		}
	    }
	}

	return hMean;
    }

    public static double hPrimeMean(double hMean, double hPrime1, double hPrime2)
    {
	double hPrimeMean = 0;

	if (hMean == 3)
	{
	    hPrimeMean = hPrime1 + hPrime2;
	}
	else
	{
	    if (hMean == 0)
	    {
		hPrimeMean = (hPrime1 + hPrime2) / 2;
	    }
	    else if (hMean == 1)
	    {
		hPrimeMean = (hPrime1 + hPrime2) / 2 + 180;
	    }
	    else
	    {
		hPrimeMean = (hPrime1 + hPrime2) / 2 - 180;
	    }
	}

	return hPrimeMean;
    }

    public static double sSubL(double l1, double l2)
    {
	double LMean = (l1 + l2) / 2;
	double LMeanmin50squ = Math.pow((LMean - 50), 2);

	return 1 + (0.015 * LMeanmin50squ / Math.sqrt(20 + LMeanmin50squ));
    }

    public static double sSubC(double CPrime)
    {
	return 1 + 0.045 * CPrime;
    }

    public static double T(double hPrimeMean)
    {
	double T =
	    1 - 0.17 * Math.cos(Math.toRadians(hPrimeMean - 30)) +
	    0.24 * Math.cos(Math.toRadians(2 * hPrimeMean)) +
	    0.32 * Math.cos(Math.toRadians(3 * hPrimeMean + 6)) -
	    0.2 * Math.cos(Math.toRadians(4 * hPrimeMean - 63));
	
	return T;
    }

    public static double sSubH(double CPrimeMean, double T)
    {
	return 1 + 0.015 * CPrimeMean * T;
    }

    public static double dTheta(double hPrimeMean)
    {
	return 30 * Math.exp(-1 * Math.pow((hPrimeMean - 275) / 25, 2));
    }
}

