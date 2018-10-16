package de.jooarye.valueapi;

/*
 * Class: Value.java
 * Author: Jooarye
 * Description: Representational Class of a Value
 * Date: 16.10.2018
 * License: GNU GPLv3
 */

public class Value<T> {

	private String name;
	private Object parent;
	private T curValue;
	private final T minValue;
	private final T maxValue;

	/*
	 * Constructor for Boolean or String No min or max needed, because it's not a
	 * number
	 */
	public Value(String name, Object parent, T value) {
		this.name = name;
		this.parent = parent;
		this.curValue = value;
		this.minValue = null;
		this.maxValue = null;
		ValueAPI.getValueManager().registerValue(this);
	}

	/*
	 * Constructor for any kind of Number Min and max needed to delimit the number
	 * range
	 */
	public Value(String name, Object parent, T value, T min, T max) {
		this.name = name;
		this.parent = parent;
		this.curValue = value;
		this.minValue = min;
		this.maxValue = max;
		ValueAPI.getValueManager().registerValue(this);
	}

	/*
	 * Get the value name
	 */
	public String getName() {
		return name;
	}

	/*
	 * Get the value parent
	 */
	public Object getParent() {
		return parent;
	}

	/*
	 * Get the current value
	 */
	public T getValue() {
		return curValue;
	}

	/*
	 * Get the maximum value | ONLY FOR NUMBERS
	 */
	public T getMaxValue() {
		return maxValue;
	}

	/*
	 * Get the minimum value | ONLY FOR NUMBERS
	 */
	public T getMinValue() {
		return minValue;
	}

	/*
	 * Set the value
	 */
	public void setValue(T value) {
		this.curValue = value;
	}

	/*
	 * Is the Value a bool
	 */
	public boolean isBool() {
		return this.curValue.getClass().equals(Boolean.class);
	}

	/*
	 * Is the Value a float
	 */
	public boolean isFloat() {
		return this.curValue.getClass().equals(Float.class);
	}

	/*
	 * Is the Value a double
	 */
	public boolean isDouble() {
		return this.curValue.getClass().equals(Double.class);
	}

	/*
	 * Is the Value a int
	 */
	public boolean isInteger() {
		return this.curValue.getClass().equals(Integer.class);
	}

}
