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

package com.fritzmahnke.color;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * Unit test for color utilities.
 */
public class ColorSampleTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ColorSampleTest(String testName)
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(ColorSampleTest.class);
    }

    public void testAverage() {
	List<ColorSample> samples = new ArrayList<ColorSample>();
	samples.add(TestData.sample1);
	samples.add(TestData.sample2);
	samples.add(TestData.sample3);
	samples.add(TestData.sample4);
	samples.add(TestData.sample5);

	ColorSample average = ColorSample.average(samples);
	LabCoord labCoord = average.getLabCoord();
	double L = labCoord.getL();
	double A = labCoord.getA();
	double B = labCoord.getB();

	assertEquals(48.14, L, 0.01);
	assertEquals(-3.00, A, 0.01);
	assertEquals(21.61, B, 0.01);
    }
}