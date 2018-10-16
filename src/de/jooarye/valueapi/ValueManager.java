package de.jooarye.valueapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Class: ValueManager.java
 * Author: Jooarye
 * Description: Manager for all Values
 * Date: 16.10.2018
 * License: GNU GPLv3
 */

public class ValueManager {

	private Map<Object, List<Value>> REGISTRY_MAP = new HashMap<Object, List<Value>>();

	/*
	 * Function to register a Value for distant access!
	 */
	public void registerValue(Value value) {
		if (this.REGISTRY_MAP.containsKey(value.getParent())) {
			this.REGISTRY_MAP.get(value.getParent()).add(value);
		} else {
			this.REGISTRY_MAP.put(value.getParent(), new ArrayList<>());
			this.REGISTRY_MAP.get(value.getParent()).add(value);
		}
	}

	/*
	 * Get all values by parent 
	 */
	public List<Value> getValues(Object parent) {
		return this.REGISTRY_MAP.get(parent);
	}

	/*
	 * Get all values by name 
	 */
	public List<Value> getValues(String name) {
		List<Value> temp = new ArrayList<Value>();
		this.REGISTRY_MAP.keySet().stream().forEach(key -> {
			this.REGISTRY_MAP.get(key).stream().filter(val -> val.getName().equalsIgnoreCase(name)).forEach(temp::add);
		});
		return temp;
	}

	/*
	 * Get a specific value by name and parent 
	 */
	public Value getValue(String name, Object parent) {
		return this.REGISTRY_MAP.get(parent).stream().filter(val -> val.getParent().equals(parent)).findFirst()
				.orElse(null);
	}

}
