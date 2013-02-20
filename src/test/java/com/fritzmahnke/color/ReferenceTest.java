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
public class ReferenceTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ReferenceTest(String testName)
    {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite(ReferenceTest.class);
    }

    public void testCgatsAverage() {
	List<CxFDocument> samples1 = new ArrayList<CxFDocument>();
	samples1.add(TestData.sample1);
	samples1.add(TestData.sample2);
	samples1.add(TestData.sample3);
	samples1.add(TestData.sample4);
	samples1.add(TestData.sample5);

	List<CxFDocument> samples2 = new ArrayList<CxFDocument>();
	samples2.add(TestData.sample6);
	samples2.add(TestData.sample7);
	samples2.add(TestData.sample8);
	samples2.add(TestData.sample9);
	samples2.add(TestData.sample10);

	Reference ref1 = new CgatsReference(TestData.fields1, samples1);
	Reference ref2 = new CgatsReference(TestData.fields1, samples2);

	List<Reference> toAverage = new ArrayList<Reference>();
	toAverage.add(ref1);
	toAverage.add(ref2);

	Reference averageRef = CgatsReference.averageReference(toAverage);
	List<CxFDocument> average = averageRef.getSamples();

	LabCoord coord = average.get(0).getLabCoord();
	assertEquals(62.6, coord.getL(), 0.01);
	assertEquals(-37.75, coord.getA(), 0.01);
	assertEquals(1.37, coord.getB(), 0.01);
	coord = average.get(1).getLabCoord();
	assertEquals(28.06, coord.getL(), 0.01);
	assertEquals(16.58, coord.getA(), 0.01);
	assertEquals(17.44, coord.getB(), 0.01);
	coord = average.get(2).getLabCoord();
	assertEquals(39.75, coord.getL(), 0.01);
	assertEquals(15.17, coord.getA(), 0.01);
	assertEquals(14.97, coord.getB(), 0.01);
	coord = average.get(3).getLabCoord();
	assertEquals(43.60, coord.getL(), 0.01);
	assertEquals(10.38, coord.getA(), 0.01);
	assertEquals(17.71, coord.getB(), 0.01);
	coord = average.get(4).getLabCoord();
	assertEquals(65.67, coord.getL(), 0.01);
	assertEquals(9.87, coord.getA(), 0.01);
	assertEquals(32.46, coord.getB(), 0.01);
    }

    /**
     * Average reference data with different number of samples
     */
    public void testCgatsAssymetricalAverage() {
	/*
	List<CxFDocument> samples1 = new ArrayList<CxFDocument>();
	samples1.add(TestData.sample1);
	samples1.add(TestData.sample2);
	samples1.add(TestData.sample3);
	samples1.add(TestData.sample4);
	samples1.add(TestData.sample5);

	List<CxFDocument> samples2 = new ArrayList<CxFDocument>();
	samples2.add(TestData.sample6);
	samples2.add(TestData.sample7);
	samples2.add(TestData.sample8);
	samples2.add(TestData.sample9);

	Reference ref1 = new CgatsReference(TestData.fields1, samples1);
	Reference ref2 = new CgatsReference(TestData.fields1, samples2);

	List<Reference> toAverage = new ArrayList<Reference>();
	toAverage.add(ref1);
	toAverage.add(ref2);

	List<CxFDocument> average = CgatsReference.averageReference(toAverage);
	*/
    }

    /**
     ** Integration tests
     **
     **/

    public void testCgatsReferenceFromFile() throws IOException
    {
	InputStream in = getClass().getClassLoader().
	    getResourceAsStream("GRACoL2006_Coated1.txt");
	CgatsReference ref = new CgatsReference(in);
    }
}
