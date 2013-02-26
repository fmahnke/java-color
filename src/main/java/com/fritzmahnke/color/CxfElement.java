package com.fritzmahnke.color;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.w3c.dom.*;

public class CxfElement<K, V> implements IElement<K, V> {
    /// Element name
    private String name;
    private Map<K, V> attributes = new LinkedHashMap<K, V>();
    private List<IElement<?, ?>> children = new ArrayList<IElement<?, ?>>();
    /// Element text
    private String text = null;

    public void addChild(IElement<?, ?> child) {
	children.add(child);
    }

    public String getName() {
	return name;
    }
    
    public IElement<?, ?> findChild(String name) {
	IElement<?, ?> child = null;
	    
	for (IElement<?, ?> element : children) {
	    if (element.getName().compareToIgnoreCase(name) == 0) {
		child = element;
	    }
	}
	return child;
    }
    
    public CxfElement(String name) {
	this.name = name;
    }

    public V getAttribute(K name, V value) {
	return attributes.get(name);
    }
    
    public void setAttribute(K name, V value) {
	attributes.put(name, value);
    }
    
    public String getText() {
	return text;
    }
    
    public void setText(String text) {
	this.text = text;
    }

    public Element toXML(Document document) {
	Element element = document.createElement(name);
	    
	for (K key : attributes.keySet()) {
	    element.setAttribute(key.toString(), attributes.get(key).toString());
	}
	
	if (text != null) {
	    element.setTextContent(text);
	}
	
	for (IElement<?, ?> child : children) {
	   element.appendChild(child.toXML(document)); 
	}
	
	return element;
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

	for (IElement<?, ?> child : children) {
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

