package com.fritzmahnke.color;

public class ElementAttribute<K, V> implements Attribute<K, V> {
    private K name;
    private V value;

    public K getName() {
	return name;
    }

    public V getValue() {
	return value;
    }

    public ElementAttribute(K key, V value) {
	this.name = key;
	this.value = value;
    }

    @Override
    public String toString() {
	return "[name: " + name.toString() + ", value: " + value.toString() + "]";
    }
}

