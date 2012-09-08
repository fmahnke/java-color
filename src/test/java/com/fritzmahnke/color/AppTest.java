package com.fritzmahnke.color;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testChroma()
    {
	assertEquals("stuff", 79.8200, App.chroma(2.6772, -79.7751), TOLERANCE);
    }

    final double TOLERANCE = 0.003;
    final int INPUTLENGTH = 34;

    Lab[] inLab1 = {
	new Lab(50.0000, 2.6772, -79.7751),
	new Lab(50.0000, 3.1571, -77.2803),
	new Lab(50.0000, 2.8361, -74.0200),
	new Lab(50.0000, -1.3802, -84.2814),
	new Lab(50.0000, -1.1848, -84.8006),
	new Lab(50.0000, -0.9009, -85.5211),
	new Lab(50.0000, 0.0000, 0.0000),
	new Lab(50.0000, -1.0000, 2.0000),
	new Lab(50.0000, 2.4900, -0.0010),
	new Lab(50.0000, 2.4900, -0.0010),
	new Lab(50.0000, 2.4900, -0.0010),
	new Lab(50.0000, 2.4900, -0.0010),
	new Lab(50.0000, -0.0010, 2.4900),
	new Lab(50.0000, -0.0010, 2.4900),
	new Lab(50.0000, -0.0010, 2.4900),
	new Lab(50.0000, 2.5000, 0.0000),
	new Lab(50.0000, 2.5000, 0.0000),
	new Lab(50.0000, 2.5000, 0.0000),
	new Lab(50.0000, 2.5000, 0.0000),
	new Lab(50.0000, 2.5000, 0.0000),
	new Lab(50.0000, 2.5000, 0.0000),
	new Lab(50.0000, 2.5000, 0.0000),
	new Lab(50.0000, 2.5000, 0.0000),
	new Lab(50.0000, 2.5000, 0.0000),
	new Lab(60.2574, -34.0099, 36.2677),
	new Lab(63.0109, -31.0961, -5.8663),
	new Lab(61.2901, 3.7196, -5.3901),
	new Lab(35.0831, -44.1164, 3.7933),
	new Lab(22.7233, 20.0904, -46.6940),
	new Lab(36.4612, 47.8580, 18.3852),
	new Lab(90.8027, -2.0831, 1.4410),
	new Lab(90.9257, -0.5406, -0.9208),
	new Lab(6.7747, -0.2908, -2.4247),
	new Lab(2.0776, 0.0795, -1.1350)
    };

    Lab[] inLab2 = {
	new Lab(50.0000, 0.0000, -82.7485),
	new Lab(50.0000, 0.0000, -82.7485),
	new Lab(50.0000, 0.0000, -82.7485),
	new Lab(50.0000, 0.0000, -82.7485),
	new Lab(50.0000, 0.0000, -82.7485),
	new Lab(50.0000, 0.0000, -82.7485),
	new Lab(50.0000, -1.0000, 2.0000),
	new Lab(50.0000, 0.0000, 0.0000),
	new Lab(50.0000, -2.4900, 0.0009),
	new Lab(50.0000, -2.4900, 0.0010),
	new Lab(50.0000, -2.4900, 0.0011),
	new Lab(50.0000, -2.4900, 0.0012),
	new Lab(50.0000, 0.0009, -2.4900),
	new Lab(50.0000, 0.0010, -2.4900),
	new Lab(50.0000, 0.0011, -2.4900),
	new Lab(50.0000, 0.0000, -2.5000),
	new Lab(73.0000, 25.0000, -18.0000),
	new Lab(61.0000, -5.0000, 29.0000),
	new Lab(56.0000, -27.0000, -3.0000),
	new Lab(58.0000, 24.0000, 15.0000),
	new Lab(50.0000, 3.1736, 0.5854),
	new Lab(50.0000, 3.2972, 0.0000),
	new Lab(50.0000, 1.8634, 0.5757),
	new Lab(50.0000, 3.2592, 0.3350),
	new Lab(60.4626, -34.1751, 39.4387),
	new Lab(62.8187, -29.7946, -4.0864),
	new Lab(61.4292, 2.2480, -4.9620),
	new Lab(35.0232, -40.0716, 1.5901),
	new Lab(23.0331, 14.9730, -42.5619),
	new Lab(36.2715, 50.5065, 21.2231),
	new Lab(91.1528, -1.6435, 0.0447),
	new Lab(88.6381, -0.8985, -0.7239),
	new Lab(5.8714, -0.0985, -2.2286),
	new Lab(0.9033, -0.0636, -0.5514)
    };

    double[] outChroma1 = {
	79.8200,
	77.3448,
	74.0743,
	84.2927,
	84.8089,
	85.5258,
	0.0000,
	2.2361,
	2.4900,
	2.4900,
	2.4900,
	2.4900,
	2.4900,
	2.4900,
	2.4900,
	2.5000,
	2.5000,
	2.5000,
	2.5000,
	2.5000,
	2.5000,
	2.5000,
	2.5000,
	2.5000,
	49.7194,
	31.6446,
	6.5489,
	44.2792,
	50.8326,
	51.2680,
	2.5329,
	1.0678,
	2.4421,
	1.1378
    };

    double[] outChroma2 = {
	82.7485,
	82.7485,
	82.7485,
	82.7485,
	82.7485,
	82.7485,
	2.2361,
	0.0000,
	2.4900,
	2.4900,
	2.4900,
	2.4900,
	2.4900,
	2.4900,
	2.4900,
	2.5000,
	30.8058,
	29.4279,
	27.1662,
	28.3019,
	3.2271,
	3.2972,
	1.9503,
	3.2763,
	52.1857,
	30.0735,
	5.4475,
	40.1031,
	45.1188,
	54.7844,
	1.6441,
	1.1538,
	2.2308,
	0.5551
    };

    double[] gFactors = {
	0.0001,
	0.0001,
	0.0001,
	0.0001,
	0.0001,
	0.0001,
	0.5000,
	0.5000,
	0.4998,
	0.4998,
	0.4998,
	0.4998,
	0.4998,
	0.4998,
	0.4998,
	0.4998,
	0.3827,
	0.3981,
	0.4206,
	0.4098,
	0.4997,
	0.4997,
	0.4999,
	0.4997,
	0.0017,
	0.0490,
	0.4966,
	0.0063,
	0.0026,
	0.0013,
	0.4999,
	0.5000,
	0.4999,
	0.5000
    };

    double[] testAPrimes1 = {
	2.6774,
	3.1573,
	2.8363,
	-1.3803,
	-1.1849,
	-0.9009,
	0.0000,
	-1.5000,
	3.7346,
	3.7346,
	3.7346,
	3.7346,
	-0.0015,
	-0.0015,
	-0.0015,
	3.7496,
	3.4569,
	3.4954,
	3.5514,
	3.5244,
	3.7494,
	3.7493,
	3.7497,
	3.7493,
	-34.0678,
	-32.6194,
	5.5668,
	-44.3939,
	20.1424,
	47.9197,
	-3.1245,
	-0.8109,
	-0.4362,
	0.1192
    };

    double[] testAPrimes2 = {
	0.0000,
	0.0000,
	0.0000,
	0.0000,
	0.0000,
	0.0000,
	-1.5000,
	0.0000,
	-3.7346,
	-3.7346,
	-3.7346,
	-3.7346,
	0.0013,
	0.0015,
	0.0016,
	0.0000,
	34.5687,
	-6.9907,
	-38.3556,
	33.8342,
	4.7596,
	4.9450,
	2.7949,
	4.8879,
	-34.2333,
	-31.2542,
	3.3644,
	-40.3237,
	15.0118,
	50.5716,
	-2.4651,
	-1.3477,
	-0.1477,
	-0.0954
    };

    public void testChromaLab()
    {
	Lab lab = new Lab(50.0000, 2.6772, -79.7751);
	assertEquals("stuff", 79.8200, App.chroma(lab), TOLERANCE);

	int inputLength = inLab1.length;

	for (int i = 0; i < inputLength; i++)
	{
	    assertEquals("stuff", outChroma1[i], App.chroma(inLab1[i]), TOLERANCE);
	    assertEquals("stuff", outChroma2[i], App.chroma(inLab2[i]), TOLERANCE);
	}
    }

    public void testGFactor()
    {
	int inputLength = outChroma1.length;

	for (int i = 0; i < inputLength; i++)
	{
	    double c1 = outChroma1[i];
	    double c2 = outChroma2[i];
	    double meanC = (c1 + c2) / 2;

	    assertEquals("stuff", gFactors[i], App.gFactor(meanC), TOLERANCE);
	}
    }

    public void testAPrime()
    {
	for (int i = 0; i < INPUTLENGTH; i++)
	{
	    assertEquals("stuff", testAPrimes1[i], App.aPrime(inLab1[i].a,
			 gFactors[i]), TOLERANCE);
	    assertEquals("stuff", testAPrimes2[i], App.aPrime(inLab2[i].a,
			 gFactors[i]), TOLERANCE);
	}
	
    }
}
