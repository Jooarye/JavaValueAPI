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

	/*
	 * Registry Map to keep track of all Values
	 */
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

	/*
	 * Load a previously created Configuration File
	 * Changes all Values to their previous value
	 */
	public void loadConfiguration(String path) throws IOException {
		final Properties props = new Properties();
		props.load(new FileInputStream(path));
		this.REGISTRY_MAP.stream().forEach(value -> {
			String key = value.getParent().getClass().getSimpleName() + "-" + value.getValue();
			if(props.keySet().containsKey(key)) {
				String val = props.getProperty(key);
				this.setValue(value, val);
			}
		});
	}

	/*
	 * Save the current Values as Configuration
	 */
	public void saveConfiguration(String path) throws IOException {
		final Properties props = new Properties();
		this.REGISTRY_MAP.stream().forEach(value -> {
			String key = value.getParent().getClass().getSimpleName() + "-" + value.getValue();
			props.setValue(key, String.valueOf(value.getValue()));
		});
		props.save(new FileOutputStream(path), "ValueApi Configuration File");
	}

	/*
	 * Parse and set the value of a Value
	 */
	public void setValue(Value val, String value) {
		if(val.getValue().getClass() == Integer.class) {
			val.setValue(Integer.parseInt(value));
		} else if(val.getValue().getClass() == Boolean.class) {
			val.setValue(Boolean.parseBoolean(value));
		} else if(val.getValue().getClass() == Float.class) {
			val.setValue(Float.parseFloat(value));
		} else if(val.getValue().getClass() == Double.class) {
			val.setValue(Double.parseDouble(value));
		} else if(val.getValue().getClass() == Long.class) {
			val.setValue(Long.parseLong(value));
		} else {
			val.setValue(value);
		}
	}

}
