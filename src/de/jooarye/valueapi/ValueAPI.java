package de.jooarye.valueapi;

/*
 * Class: ValueAPI.java
 * Author: Jooarye
 * Description: Main API class
 * Date: 16.10.2018
 * License: GNU GPLv3
 */

public class ValueAPI {

	public ValueManager valueManager;

	private static ValueAPI inst = new ValueAPI();

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
