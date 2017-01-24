# java2scala

This assignment is about learning some very Scala basics by translating some Java code to Scala.

## Java Domain Model

There is a very simple domain model in `src/main/java/org.scaladus.java.java2scala`.
It consists of classes:

- Person
- Employee
- Customer

A person has a first name, a last name and a birthday.
A person's birthday can not be in the past.
Furthermore it has a method calculating the person's age.
Employees and customers are persons with additional properties.
An employee is a person which has a salary.
An employee's salary can not be less then zero.
A customer is a person with a customer ID.

You can use the class `org.scaladus.java.java2scala.JavaMain` to play around with the Java model.

## Translating the model to scala

The task is translate the Java model to Scala.
Use the `org.scaladus.java2scala.ScalaMain` class to play around with the code you have written.
Be prepared to be amazed by how few lines of code you have to write to translate the Java code.

## Scala Syntax Cheat Sheet

- You don't need semi colons at the end of a line
- You don't need `return` at the end of a method - the result of evaluating the last statement is returned by default
- Curly braces for methods are optional if the method body fits into one line
- Type declarations go behind variable/parameter names
- Scala has three important key words:
    - use `val` to define immutable fields
    - use `var` to define mutable fields
    - use `def` to define methods
- Use [case classes](http://docs.scala-lang.org/tutorials/tour/case-classes.html) to define domain objects.
- Use `println()` to write to the console.

## Scala code example

Here is an example Scala class:

```scala
class ScalaClass(var mutableInt: Int, val immutableString: String = "defaultValue") {

    def addOne(num: Int) = num + 1
}
```

This class has two constructor parameters: `mutableInt` and `immutableString`.
`immutableString` has a default value ("defaultValue"), so we don't need to pass a value for immutableString.
Creating an instance of `ScalaClass` looks much like in Java:

```scala
val myObject = new ScalaClass(15)
```

We don't need to add a type declaration to `myObject`.
The compiler knows that `myObject` is of type `ScalaClass`.
Furthermore we don't need to pass a value for `immutableString`.
It will simply be set to the default value.

Calling a method in Scala also looks familiar to the experienced Java programmer:

```scala
val three = myObject.addOne(2)
```
