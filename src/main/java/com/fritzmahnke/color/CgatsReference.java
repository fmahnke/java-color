package com.fritzmahnke.color;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class CgatsReference implements Reference {
    private int numberOfFields;
    private int rowLength;
    private int numberOfSamples;
    private List<ColorSample> samples = new ArrayList<ColorSample>();
    private List<String> dataFields;

    private enum Flag {
	NONE, IN_DATA_FORMAT, IN_DATA_SECTION
    }

    private Flag parserSection = Flag.NONE;
	
    private void parseLine(String[] line) {
	assert line.length > 0;

	String field = line[0];

	if (field.compareToIgnoreCase("NUMBER_OF_FIELDS") == 0 ) {
	    parseNumberOfFields(line);
	} else if (field.compareToIgnoreCase("LGOROWLENGTH") == 0) {
	    parseRowLength(line);
	} else if (field.compareToIgnoreCase("NUMBER_OF_SETS") == 0) {
	    numberOfSamples = Integer.parseInt(line[line.length - 1]);
	} else if (field.compareToIgnoreCase("BEGIN_DATA_FORMAT") == 0) {
	    parserSection = Flag.IN_DATA_FORMAT;
	} else if (field.compareToIgnoreCase("END_DATA_FORMAT") == 0) {
	    parserSection = Flag.NONE;
	} else if (field.compareToIgnoreCase("BEGIN_DATA") == 0) {
	    parserSection = Flag.IN_DATA_SECTION;
	} else if (field.compareToIgnoreCase("END_DATA") == 0) {
	    parserSection = Flag.NONE;
	} else if (parserSection == Flag.IN_DATA_FORMAT) {
	    parseDataFormatLine(line);
	} else if (parserSection == Flag.IN_DATA_SECTION) {
	    parseSampleLine(line);
	}
    }

    private void parseNumberOfFields(String[] line) {
	numberOfFields = Integer.parseInt(line[line.length - 1]);
    }

    private void parseRowLength(String[] line) {
	rowLength = Integer.parseInt(line[line.length - 1]);
    }

    private void parseDataFormatLine(String[] line) {
	List<String> fields = new ArrayList();

	for (String field : line) {
	    if (! field.matches("\\s")) {
		fields.add(field);
	    }
	}

	assert fields.size() == numberOfFields;

	dataFields = fields;
    }

    private void parseSampleLine(String[] line) {
	int fieldIndex = 0;

	String sampleId = null;
	String sampleName = null;
	double c = 0;
	double m = 0;
	double y = 0;
	double k = 0;
	double l = 0;
	double a = 0;
	double b = 0;

	for (String field : line) {
	    if (! field.matches("\\s")) {
		String fieldName = dataFields.get(fieldIndex);

		if (fieldName.compareToIgnoreCase("SampleID") == 0) {
		    sampleId = field;
		} else if (fieldName.compareToIgnoreCase("SAMPLE_NAME") == 0) {
		    sampleName = field;
		} else if (fieldName.compareToIgnoreCase("CMYK_C") == 0) {
		    c = Double.parseDouble(field);
		} else if (fieldName.compareToIgnoreCase("CMYK_M") == 0) {
		    m = Double.parseDouble(field);
		} else if (fieldName.compareToIgnoreCase("CMYK_Y") == 0) {
		    y = Double.parseDouble(field);
		} else if (fieldName.compareToIgnoreCase("CMYK_K") == 0) {
		    k = Double.parseDouble(field);
		} else if (fieldName.compareToIgnoreCase("XYZ_X") == 0) {
		    //k = Double.parseDouble(field);
		} else if (fieldName.compareToIgnoreCase("XYZ_Y") == 0) {
		    //k = Double.parseDouble(field);
		} else if (fieldName.compareToIgnoreCase("XYZ_Z") == 0) {
		    //k = Double.parseDouble(field);
		} else if (fieldName.compareToIgnoreCase("LAB_L") == 0) {
		    l = Double.parseDouble(field);
		} else if (fieldName.compareToIgnoreCase("LAB_A") == 0) {
		    a = Double.parseDouble(field);
		} else if (fieldName.compareToIgnoreCase("LAB_B") == 0) {
		    b = Double.parseDouble(field);
		}
	    }
	    ++fieldIndex;
	}
	
	ColorSample sample = new ColorSample(sampleId, sampleName, c, m, y, k,
					     l, a, b);
	samples.add(sample);
    }

    public List<ColorSample> getSamples() {
	return samples;
    }

    public CgatsReference(List<ColorSample> samples) {
	numberOfSamples = samples.size();
	this.samples = samples;
    }

    public CgatsReference(InputStream in) throws IOException
    {
	Reader reader = new InputStreamReader(in);
	BufferedReader bufReader = new BufferedReader(reader);

	String line = null;
	while ((line = bufReader.readLine()) != null) {
	    line = line.trim();
	    String[] splitLine = line.split("\\s");
	    parseLine(splitLine);
	}
	bufReader.close();
    }

    @Override
    public String toString() {
	StringBuilder ref = new StringBuilder();
	ref.append("numberOfFields: " + numberOfFields + "\n");
	ref.append("rowLength: " + rowLength + "\n");

	if (dataFields != null) {
	    for (String field : dataFields) {
		ref.append(field + "\t");
	    }
	    ref.append("\n");
	}

	for (ColorSample sample : samples) {
	    ref.append(sample.toString());
	}

	return ref.toString();
    }
}
