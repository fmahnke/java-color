package com.fritzmahnke.color;

/**
 * A ColorSpecification element.
 */
public class ColorSpecification extends Element {
    public ColorSpecification(String id, MeasurementSpec spec) {
	super("ColorSpecification");
	setAttribute("id", id);
    }
}

