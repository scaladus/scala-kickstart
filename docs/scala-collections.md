# Scala Collections

This assignment is about getting to know the Scala collections API.

## Assignment

The assignment is to use the Scala collection API to provide the missing implementations in `org.sugdus.collections.Collections`.
There are tests for all methods in the `CollectionsSpec`.
You can run all tests using `sbt test` or by executing the spec from within your IDE.

Hint: try to solve this assignment only be using the various operations defined in the collections API.
It is possible to solve all assignments without creating intermediate results.

## Scala collection API cheat sheet

- Generics declarations go in square brackets
- When creating collections, you get the immutable variants by default
- For this reason operations on collections always return a new reference

## Example collections code

```scala
var ints = List(5, 6, 9)

ints = ints :+ 13

val intsAsString = ints.map(_.toString)
```

The code above first creates a new list containing three Ints (5, 6 and 9).
Than the variable `ints` gets reassigned the result of appending 13 to the list.
Note that the initial list is not modified.
Instead a new reference is returned.
This is an important difference compared to e.g. `java.util.List`, where the `add(E)` method returns a `boolean` indicating whether the list hast been changed as a result of calling the method.
The same is true for the last line:
instead of mutating the int list, a new list is returned containing the result of calling the `toString()` method on all elements of the list.

## Credits

Credits for this assignment go to [@mlex](https://github.com/mlex) for giving the inspirations with the Java 8 Streaming API assignment in [codecentric/java8-examples](https://github.com/codecentric/java8-examples).
