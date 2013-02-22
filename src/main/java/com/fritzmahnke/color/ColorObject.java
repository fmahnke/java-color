package com.fritzmahnke.color;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 * An object in a CxF document.
 */
public class ColorObject extends CxfElement {
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
	setAttribute("Id", id);
	setAttribute("Name", name);
	setAttribute("ObjectType", objectType);
	/*
	Map<String, String> map = new LinkedHashMap<String, String>();
	map.put("Id", id);
	map.put("Name", name);
	map.put("ObjectType", objectType);
	IElement element = new Element(map);

	return element;
	*/
    }
}

