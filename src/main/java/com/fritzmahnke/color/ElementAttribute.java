package com.fritzmahnke.color;

public class ElementAttribute<N, V> implements Attribute<N, V> {
    private N name;
    private V value;

    public ElementAttribute(N key, V value) {
	name = key;
	value = value;
    }
}

