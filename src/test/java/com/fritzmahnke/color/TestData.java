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

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

/**
 * Data shared between test classes
 *
 * @author fmahnke
 */

public class TestData {
    public static final List<String> fields1 =
	Collections.unmodifiableList(Arrays.asList("sampleid", "sample_name",
						   "cmyk_c", "cmyk_m", "cmyk_y",
						   "cmyk_k", "lab_l", "lab_a",
						   "lab_b"));
    
    public static final ColorSample sample1 =
	new ColorSample("722", "A1", 100.00, 10.00, 100.00, 0.00, 47.83, -62.03, 22.35);
    public static final ColorSample sample2 =
	new ColorSample("1410", "A2", 0.00, 100.00, 100.00, 70.00, 23.40, 30.65, 18.62);
    public static final ColorSample sample3 =
	new ColorSample("873", "A3", 100.00, 100.00, 40.00, 20.00, 21.03, 6.53, -23.64);
    public static final ColorSample sample4 =
	new ColorSample("427", "A4", 20.00, 30.00, 55.00, 0.00, 71.25, 6.45, 26.90);
    public static final ColorSample sample5 =
	new ColorSample("579", "A5", 10.00, 20.00, 85.00, 0.00, 77.21, 3.42, 63.80);

    public static final ColorSample sample6 =
	new ColorSample("1453", "A6", 40.00, 0.00, 3.00, 3.00, 77.37, -13.46, -19.61);
    public static final ColorSample sample7 =
	new ColorSample("938", "A7", 70.00, 70.00, 100.00, 20.00, 32.71, 2.51, 16.25);
    public static final ColorSample sample8 =
	new ColorSample("672", "A8", 20.00, 55.00, 100.00, 0.00, 58.47, 23.80, 53.57);
    public static final ColorSample sample9 =
	new ColorSample("1251", "A9", 40.00, 100.00, 100.00, 80.00, 15.94, 14.31, 8.52);
    public static final ColorSample sample10 =
	new ColorSample("366", "A10", 40.00, 55.00, 40.00, 0.00, 54.12, 16.31, 1.11);
}
