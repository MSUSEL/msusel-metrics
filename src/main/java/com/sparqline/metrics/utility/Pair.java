package com.sparqline.metrics.utility;

public class Pair<K, V> {

	private K key;
	private V value;
	
	public Pair(K x, V y) {
		this.key = x;
		this.value = y;
	}
	
	public K key() {
	    return key;
	}
	
	public V value() {
	    return value;
	}
}
