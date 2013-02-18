package com.fritzmahnke.color;

/*
 * Copyright (c) 2013 Fritz Mahnke
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

import java.lang.Math;

/**
 * Performs dE1976 color difference calculations
 *
 * @author Fritz Mahnke
 */
public class dE1976 {
    public static double dL(double l1, double l2) {
	return l2 - l1;
    }

    public static double dA(double a1, double a2) {
	return a2 - a1;
    }

    public static double dB(double b1, double b2) {
	return b2 - b1;
    }

    /**
     * Calculate delta Lab between two CIELab coordinates
     */
    public static LabCoord dLab(LabCoord lab1, LabCoord lab2) {
	double l1 = lab1.getL();
	double a1 = lab1.getA();
	double b1 = lab1.getB();
	double l2 = lab2.getL();
	double a2 = lab2.getA();
	double b2 = lab2.getB();

	return new LabCoord(l2 - l1, a2 - a1, b2 - b1);
    }

    /**
     * Calculates dE1976 between two CIELab coordinates
     */
    public static double dE1976(LabCoord lab1, LabCoord lab2) {
	double l1 = lab1.getL();
	double a1 = lab1.getA();
	double b1 = lab1.getB();
	double l2 = lab2.getL();
	double a2 = lab2.getA();
	double b2 = lab2.getB();
	double dE1976 = Math.sqrt(Math.pow(dL(l1, l2), 2) +
		Math.pow(dA(a1, a2), 2) + Math.pow(dB(b1, b2), 2));

	return dE1976;
    }
}
