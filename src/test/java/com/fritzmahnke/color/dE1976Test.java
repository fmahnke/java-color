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

/**
 * Unit test for color utilities.
 */
public class dE1976Test 
    extends TestCase
{
    private LabCoord lab1 = new LabCoord(26.19, 0.7, 1.16);
    private LabCoord lab2 = new LabCoord(46.29, 12.47, 12.92);

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public dE1976Test(String testName)
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(dE1976Test.class);
    }

    public void testDe1976() {
	double result = dE1976.dE1976(lab1, lab2);
	assertEquals(26.09, result, 0.01);
    }
}
