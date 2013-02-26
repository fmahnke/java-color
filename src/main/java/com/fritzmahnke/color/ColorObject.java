package com.fritzmahnke.color;

/**
 * An object in a CxF document.
 */
public class ColorObject extends CxfElement<String, String> {
    // Name: Formal name identifying the ColorObject
    // id: xs:NCName string. @todo must validate this input
    // ObjectType: Describes what type of object this is, in a general context.
    // May be blank.

    public void addColorValues(ColorValues colorValues) {
	addChild(colorValues);
    }

    public ColorObject(String id, String name,
		       String objectType) {
	super("Object");
	setAttribute(id, name);
	setAttribute("Id", id);
	setAttribute("Name", name);
    }
}

