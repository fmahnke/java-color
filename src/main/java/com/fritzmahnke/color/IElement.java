package com.fritzmahnke.color;

import java.util.List;

/**
 * Represents a property of a color object
 *
 * @author Fritz Mahnke
 */
public interface IElement<K, V> {
    /**
     * Get a list of attribute names
     */
    public void setAttribute(K name, V value);
    /// @todo maybe move it to own class
    public void setText(String text);
    public String toJSON(int indentLevel);

    @Override
    public String toString();
}

