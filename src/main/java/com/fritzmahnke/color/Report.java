package com.fritzmahnke.color;

import java.util.List;
import java.util.ArrayList;

public class Report {
    public static void averageReference(List<Reference> refs) {
	List<List<ColorSample>> sampleSets = new ArrayList<List<ColorSample>>();

	for (Reference ref : refs) {
	    sampleSets.add(ref.getSamples());
	}

	int numberOfSets = refs.size();
	int numberOfSamples = sampleSets.get(0).size();

	List<ColorSample> averagedSamples = new ArrayList<ColorSample>(numberOfSamples);

	for (int sample = 0; sample < numberOfSamples; ++sample) {
	    List<ColorSample> toAverage = new ArrayList<ColorSample>();

	    for (int set = 0; set < numberOfSets; ++set) {
	        toAverage.add(sampleSets.get(set).get(sample));
	    }
	    ColorSample avgSample = ColorSample.average(toAverage);
	    averagedSamples.add(avgSample);
	}
    }
}

