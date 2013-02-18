package com.fritzmahnke.color;

public interface Attribute<K, V> {
    /**
     * Get the name
     */
    public K getName();
    public V getValue();
}
