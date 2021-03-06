/*
 * Copyright (c) 2012 Fritz Mahnke
 *
 * This software is provided 'as-is', without any express or implied
 * warranty. In no event will the authors be held liable for any damages
 * arising from the use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 *
 *    1. The origin of this software must not be misrepresented; you must not
 *    claim that you wrote the original software. If you use this software
 *    in a product, an acknowledgment in the product documentation would be
 *    appreciated but is not required.
 *
 *    2. Altered source versions must be plainly marked as such, and must not be
 *    misrepresented as being the original software.
 *
 *    3. This notice may not be removed or altered from any source
 *    distribution.
 */

package com.fritzmahnke.color;

import java.lang.Math;

/**
 * Calculates the difference between two colors using the dE2000 formula.
 *
 * The formula is implemented as in "The CIEDE2000 Color-Difference Formula:
 * Implementation Notes, Supplementary Test Data, and Mathematical
 * Observations"
 *
 * http://www.ece.rochester.edu/~gsharma/ciede2000/
 */
public class Calc
{
    /**
     * Constants
     */
    final static double GCONST = Math.pow(25, 7);
    final static int k_L = 1;
    final static int k_C = 1;
    final static int k_H = 1;

    public static double gFactor(double meanC)
    {
	return 0.5 * (1 - Math.sqrt(Math.pow(meanC, 7) /
	       (Math.pow(meanC, 7) + GCONST)));
    }

    public static double aPrime(double a, double g)
    {
	return (1 + g) * a;
    }

    private static double cPrime(double aPrime, double b)
    {
	return Math.sqrt(Math.pow(aPrime, 2) + Math.pow(b, 2));
    }

    private static double hPrime(double aPrime, double b)
    {
	double hPrime = 0;

	if (aPrime != 0 || b != 0)
	{
	    hPrime = Math.toDegrees(Math.atan2(b, aPrime));

	    if (b < 0)
	    {
		hPrime += 360;
	    }
	}

	return hPrime;
    }

    private static double dhCond(double hPrime2, double hPrime1)
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

    private static double dhPrime(double dhCond, double hPrime2, double hPrime1)
    {
	double dhPrime = 0;

	if (dhCond == 0)
	{
	    dhPrime = hPrime2 - hPrime1;
	}
	else if (dhCond == 1)
	{
	    dhPrime = hPrime2 - hPrime1 - 360;
	}
	else
	{
	    assert dhCond == 2;
	    dhPrime = hPrime2 - hPrime1 + 360;
	}

	return dhPrime;
    }

    private static double dHPrime(double CPrime1, double CPrime2, double dhPrime)
    {
	return 2 * Math.sqrt(CPrime1 * CPrime2) *
	       Math.sin(Math.toRadians(dhPrime / 2));
    }

    private static double hMean(double CPrime1, double CPrime2, double hPrime2,
				double hPrime1)
    {
	double hMean = 0;

	if ((CPrime1 * CPrime2) == 0)
	{
	    hMean = 3;
	}
	else if (Math.abs(hPrime2 - hPrime1) <= 180)
	{
	    hMean = 0;
	}
	else if ((hPrime2 + hPrime1) < 360)
	{
	    hMean = 1;
	}
	else
	{
	    hMean = 2;
	}

	return hMean;
    }

    private static double hPrimeMean(double hMean, double hPrime1, double hPrime2)
    {
	double hPrimeMean = 0;

	if (hMean == 3)
	{
	    hPrimeMean = hPrime1 + hPrime2;
	}
	else if (hMean == 0)
	{
	    hPrimeMean = (hPrime1 + hPrime2) / 2;
	}
	else if (hMean == 1)
	{
	    hPrimeMean = (hPrime1 + hPrime2) / 2 + 180;
	}
	else
	{
	    assert hMean == 2;
	    hPrimeMean = (hPrime1 + hPrime2) / 2 - 180;
	}

	return hPrimeMean;
    }

    private static double S_L(double l1, double l2)
    {
	double LMean = (l1 + l2) / 2;
	double LMeanmin50squ = Math.pow((LMean - 50), 2);

	return 1 + (0.015 * LMeanmin50squ / Math.sqrt(20 + LMeanmin50squ));
    }

    private static double S_C(double CPrimeMean)
    {
	return 1 + 0.045 * CPrimeMean;
    }

    private static double T(double hPrimeMean)
    {
	return 1 - 0.17 * Math.cos(Math.toRadians(hPrimeMean - 30)) +
	       0.24 * Math.cos(Math.toRadians(2 * hPrimeMean)) +
	       0.32 * Math.cos(Math.toRadians(3 * hPrimeMean + 6)) -
	       0.2 * Math.cos(Math.toRadians(4 * hPrimeMean - 63));
    }

    private static double S_H(double CPrimeMean, double T)
    {
	return 1 + 0.015 * CPrimeMean * T;
    }

    private static double dTheta(double hPrimeMean)
    {
	return 30 * Math.exp(-1 * Math.pow((hPrimeMean - 275) / 25, 2));
    }

    private static double R_C(double CPrimeMean)
    {
	double CPrimMeanTo7 = Math.pow(CPrimeMean, 7);

	return 2 * Math.sqrt(CPrimMeanTo7 / (CPrimMeanTo7 + GCONST));
    }

    private static double R_T(double dTheta, double R_C)
    {
	return -Math.sin(Math.toRadians(2 * dTheta)) * R_C;
    }

    /**
     * Calculate dE2000 between two colors in CIELAB space.
     */
    public static double dE2000(Lab lab1, Lab lab2)
    {
	// Calculate chroma
	double chroma1 = Unit.C_ab(lab1);
	double chroma2 = Unit.C_ab(lab2);

	// Average
	double meanChroma = (chroma1 + chroma2) / 2;

	// Find G
	double G = gFactor(meanChroma);
	
	// Find a'
	double aPrime1 = aPrime(lab1.a, G);
	double aPrime2 = aPrime(lab2.a, G);

	// Find C'
	double cPrime1 = cPrime(aPrime1, lab1.b);
	double cPrime2 = cPrime(aPrime2, lab2.b);

	// Find h'
	double hPrime1 = hPrime(aPrime1, lab1.b);
	double hPrime2 = hPrime(aPrime2, lab2.b);

	// Find dh'
	double dhCond = dhCond(hPrime2, hPrime1);
	double dhPrime = dhPrime(dhCond, hPrime2, hPrime1);

	// Find dL'
	double dLPrime = lab2.l - lab1.l;

	// Find dC'
	double dCPrime = cPrime2 - cPrime1;

	// Find dH'
	double dHPrime = dHPrime(cPrime1, cPrime2, dhPrime);

	// Find L' mean
	double LPrimMean = (lab1.l + lab2.l) / 2;

	// Find C' mean
	double CPrimMean = (cPrime1 + cPrime2) / 2;

	// Find h' mean
	double hMean = hMean(cPrime1, cPrime2, hPrime2, hPrime1);
	double hPrimeMean = hPrimeMean(hMean, hPrime1, hPrime2);

	// Calculate dE2000
	
	double S_L = S_L(lab1.l, lab2.l);
	double S_C = S_C(CPrimMean);
	double T = T(hPrimeMean);
	double S_H = S_H(CPrimMean, T);
	double dTheta = dTheta(hPrimeMean);
	double R_C = R_C(CPrimMean);
	double R_T = R_T(dTheta, R_C);

	double term1 = dLPrime / S_L / k_L;
	double term2 = dCPrime / S_C / k_C;
	double term3 = dHPrime / S_H / k_H;

	double dE2000 = Math.sqrt(Math.pow(term1, 2) + Math.pow(term2, 2) +
			Math.pow(term3, 2) + R_T * term2 * term3);
	
	return dE2000;
    }	
}

