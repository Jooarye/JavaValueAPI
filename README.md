# JavaValueAPI


This is a Java Value Api that you can use, to make tracking of variables/values easier!

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development.

### Prerequisites

What things you need to install the software and how to install them

* IntellIJ or Eclipse or the editor that you want to use
* Java 8

### Installing

**For Eclipse**:

just add the jar file from the lib folder to your BuildPath

**For IntellIJ**:

just add the jar file from the lib folder to your Dependecies under ProjectStructure

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

	}

}

```

```java
public class TestClass {

	public Value<Boolean> testValue = new Value<Boolean>("TestValue", this, true);

}
```

The constructor for a Value storing a boolean or a string is

```java
Value<Boolean> valBool = new Value<Boolean>(<VALUE NAME TYPE STRING>, <VALUE PARENT>, <VALUE TYPE BOOLEAN>);
Value<String> valString = new Value<String>(<VALUE NAME TYPE STRING>, <VALUE PARENT>, <VALUE TYPE STRING>);
```

## Authors

* **Jooarye** - *Initial work* - https://github.com/Jooarye/

## License

This project is licensed under the GNU GPLv3 License - see the [LICENSE.md](LICENSE.md) file for details
