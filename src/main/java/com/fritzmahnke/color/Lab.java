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

/**
 * Stores a coordinate in CIELAB color space.
 */
public class Lab
{
    /** L* component */
    double l = 0;
    /** a* component */
    double a = 0;
    /** b* component */
    double b = 0;

    public Lab(double initL, double initA, double initB)
    {
	l = initL;
	a = initA;
	b = initB;
    }
}

