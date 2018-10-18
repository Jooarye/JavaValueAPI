package de.jooarye.valueapi;

/*
 * Class: ValueAPI.java
 * Author: Jooarye
 * Description: Main Api class
 * Date: 16.10.2018
 * License: GNU GPLv3
 */

public class ValueAPI {

	public ValueManager valueManager;

	/*
	 * The instance for general use
	 */
	private static ValueAPI inst = new ValueAPI();

	/*
	 * Private constructor due to having a instance in this class
	 */
	private ValueAPI() {
		this.valueManager = new ValueManager();
	}

	/*
	 * Get the general ValueManager
	 */
	public static ValueManager getValueManager() {
		return inst.valueManager;
	}

}
