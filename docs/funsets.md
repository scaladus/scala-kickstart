# FunSets

This assignment is par of the great [Functional Programming Principles in Scala](https://www.coursera.org/learn/progfun1) by Martin Odersky on coursera.
The idea is to define Sets as a function from Int to Boolean.
Users can hand an Int to a Set and ask the set whether the Int is contained in the given set.

## Assignment

Implement the missing Set function in `src/main/scala/org.scaladus.funsets.FunSets`.
There is an empty test in `src/test/scala/org.scaladus.funsets.FunSetsSpec` which you can use to test whether your set implementation is correct.

## Scala Syntax Cheat Sheet

- Functions are declared using the `=>` operator, for example `Int => Boolean` is the type of a fucntion which takes an Int and returns a Boolean.
- Functions can be assigned to `vals` or returned from methods or other functions.
- For calling a function simply pass arguments to it:

```scala
val addOne: Int => Int = (e: Int) => e + 1

val two = addOne(1)
```

## Hints

- For this assignment, forget what you have learned about sets.
- Don't think about a set as being a container holding elements.
- Just think about how you can decide whether a number is contained or not.
- Some sets may be combination of other sets.
