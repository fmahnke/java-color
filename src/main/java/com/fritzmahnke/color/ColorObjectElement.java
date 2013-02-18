package com.fritzmahnke.color;

import java.util.List;

/**
 * Represents a property of a color object
 *
 * @author Fritz Mahnke
 */
public interface ColorObjectElement<K, V> {
    /**
     * Get a list of attribute names
     */
    public List<Attribute> getAttributes();
    public Attribute findAttribute(K name);

    @Override
    public String toString();
}

