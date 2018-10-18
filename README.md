# JavaValueAPI


This is a Java Value Api that you can use, to make tracking of variables/values easier!

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development.

### Prerequisites

What things you need to install the software and how to install them

* IntellIJ or Eclipse
* Java 8

### Installing

**For Eclipse**:

just add the jar file from the lib folder to your BuildPath

**For IntellIJ**:

just add the jar file from the lib folder to your Dependecies under ProjectStructure

**I don't add any support for any other IDE or Editor!**

but it might still work

## Example

With this Api you can access Values from distance without getter or setter

```java
public class Main {

	public static void main(String[] args) {
		TestClass tc = new TestClass();

		// CHECK ONE

		System.out.println("Value direct access : " + tc.testValue.getValue()); // Should return true
		System.out.println("Value distant access: " + ValueAPI.getValueManager().getValue("TestValue", tc).getValue()); // Should also return true

		// VALUE CHANGE DIRECT
		tc.testValue.setValue(false);

		// CHECK TWO

		System.out.println("Value direct access : " + tc.testValue.getValue()); // Should return false
		System.out.println("Value distant access: " + ValueAPI.getValueManager().getValue("TestValue", tc).getValue()); // Should also return false

		// VALUE CHANGE DISTANT

		ValueAPI.getValueManager().getValue("TestValue", tc).setValue(true);

		// CHECK THREE

		System.out.println("Value direct access : " + tc.testValue.getValue()); // Should again return true
		System.out.println("Value distant access: " + ValueAPI.getValueManager().getValue("TestValue", tc).getValue()); // Should also return true

		// ALSO YOU CAN SAVE AND LOAD CONFIG FILES

		ValueAPI.getValueManager().loadConfiguration("test.conf");
		ValueAPI.getValueManager().saveConfiguration("test2.conf");

	}

}

```

```java
public class TestClass {

	public Value<Boolean> testValue = new Value<Boolean>("TestValue", this, true);

}
```

Here's how you create a new Value

```java
Value<Boolean> valBool = new Value<Boolean>(<VALUE NAME TYPE STRING>, <VALUE PARENT>, <VALUE TYPE BOOLEAN>);
Value<String> valString = new Value<String>(<VALUE NAME TYPE STRING>, <VALUE PARENT>, <VALUE TYPE STRING>);
Value<Integer> valInt = new Value<Integer>(<VALUE NAME TYPE STRING>, <VALUE PARENT>, <VALUE TYPE INTEGER>, <MINVAL TYPE INTEGER>, <MAXVAL TYPE INTEGER>);
Value<Double> valDouble = new Value<Double>(<VALUE NAME TYPE STRING>, <VALUE PARENT>, <VALUE TYPE DOUBLE>, <MINVAL TYPE DOUBLE>, <MAXVAL TYPE DOUBLE>);
Value<Float> valFloat = new Value<Float>(<VALUE NAME TYPE STRING>, <VALUE PARENT>, <VALUE TYPE FLOAT>, <MINVAL TYPE FLOAT>, <MAXVAL TYPE FLOAT>);
Value<Long> valLong = new Value<Long>(<VALUE NAME TYPE STRING>, <VALUE PARENT>, <VALUE TYPE LONG>, <MINVAL TYPE LONG>, <MAXVAL TYPE LONG>);
```

## Authors

* **Jooarye** - *Initial work* - https://github.com/Jooarye/
* **Mika Westphal** - *Some small bugfixes* - https://github.com/Mika-Westphal

## License

This project is licensed under the GNU GPLv3 License - see the [LICENSE.md](LICENSE.md) file for details
