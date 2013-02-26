package com.fritzmahnke.color;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Represents a property of a color object
 *
 * @author Fritz Mahnke
 */
public interface IElement<K, V> {
    /**
     * Get a list of attribute names
     */
    //public void setAttribute(K name, V value);
    /// @todo maybe move it to own class
    public void addChild(IElement<?, ?> child);
    /// Get the name of the element
    public String getName();
    /// Get the text of the element
    public String getText();
    /// Set the text of the element
    public void setText(String text);
    /// Return the element as XML
    public Element toXML(Document document);
    /// Return the element as a JSON string
    public String toJSON(int indentLevel);

    @Override
    public String toString();
}

