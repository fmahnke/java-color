package com.fritzmahnke.color;

import java.math.BigDecimal;

/** 
 * General math functions
 */
public class Math {
    public static double round(double unrounded, int precision)
    {
	BigDecimal bd = new BigDecimal(unrounded);
	BigDecimal rounded = bd.setScale(precision, BigDecimal.ROUND_HALF_UP);
	return rounded.doubleValue();
    }
}
