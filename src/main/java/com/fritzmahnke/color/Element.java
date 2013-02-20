package com.fritzmahnke.color;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Element<K, V> implements IElement<K, V> {
    /// Element name
    private String name;
    private Map<K, V> attributes = new LinkedHashMap<K, V>();
    private List<IElement> children = new ArrayList<IElement>();
    /// Element text
    private String text = "";

    public void addChild(IElement child) {
	children.add(child);
    }

    public Element(String name) {
	this.name = name;
    }

    public Element(Map<K, V> map) {
	for (K key : map.keySet()) {
	    //attributes.add(new Attribute<K, V>(key, map.get(key)));
	}
    }

    public void setAttribute(K name, V value) {
	attributes.put(name, value);
    }

    public void setText(String text) {
	this.text = text;
    }

    public String toJSON(int indentLevel) {
	StringBuilder str = new StringBuilder();

	String indent = "";

	for (int i = 0; i < indentLevel; i++) {
	    indent += "\t";
	}

	str.append(indent + "\"" + name + "\": " + text);

	if (attributes.size() > 0) {
	    str.append(" {");
	}
	str.append("\n");

	for (K key : attributes.keySet()) {
	    str.append(indent + "\t\"" + key + "\": \"" + attributes.get(key) + "\",\n");
	}

	if (children.size() > 0) {
	    str.append(indent + "\t{\n");
	}

	for (IElement child : children) {
	    str.append(child.toJSON(indentLevel + 1));
	}
	
	if (children.size() > 0) {
	    str.append(indent + "\t}");
	}


	if (attributes.size() > 0) {
	    str.append(indent + "\n");
	    str.append("}");
	}

	return str.toString();
    }

    @Override
    public String toString() {
	/// @todo Do it.
	return "Not yet implemented.";
    }
}

