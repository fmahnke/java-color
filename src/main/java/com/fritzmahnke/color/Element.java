package com.fritzmahnke.color;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Element<K, V> implements ColorObjectElement<K, V> {
    private List<Attribute> attributes = new ArrayList<Attribute>();

    public Element(Map<K, V> map) {
	for (K key : map.keySet()) {
	    attributes.add(new ElementAttribute<K, V>(key, map.get(key)));
	}
    }

    public Attribute findAttribute(K name) {
	for (Attribute attribute : attributes) {
	    if (attribute.getName() == name) {
		return attribute;
	    }
	}

	return null;
    }

    public List<Attribute> getAttributes() {
	return attributes;
    }
}

