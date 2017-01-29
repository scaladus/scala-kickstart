/*
 * Copyright 2017 Scala User Group Düsseldorf
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.scaladus.collections

import java.time.LocalDate
import java.time.Month._

import org.scalatest.{FlatSpec, Matchers}
import org.scaladus.collections.Collections._

class CollectionsSpec extends FlatSpec with Matchers {

  val persons = List(
    Person("Jane", "Jungle", LocalDate.of(1978, DECEMBER, 15), Female),
    Person("Mary", "Smith", LocalDate.of(1980, OCTOBER, 19), Female),
    Person("John", "Dole", LocalDate.of(1973, MAY, 31), Male),
    Person("Michael", "Abrahams", LocalDate.of(1967, FEBRUARY, 1), Male),
    Person("Chris", "Cross", LocalDate.of(1985, AUGUST, 22), Male),
    Person("Pete", "Power", LocalDate.of(1981, MARCH, 18), Male),
    Person("Maggie", "Simpson", LocalDate.of(2012, OCTOBER, 18), Female)
  )

  val invoices = List(
    Invoice("Crusty Burger", "Homer", List(
      InvoiceItem("Burger", 5, 5),
      InvoiceItem("Coke", 1, 5))),
    Invoice("Crusty Burger", "Bart", List(
      InvoiceItem("Coke", 1, 5))),
    Invoice("Moe", "Homer", List(
      InvoiceItem("Beer", 13, 1.5),
      InvoiceItem("Burger", 3, 4.5))),
    Invoice("Kwik-E-Mart", "Homer", List(
      InvoiceItem("Beer", 9, 0.9),
      InvoiceItem("Chips", 2, 0.5))),
    Invoice("Moe", "Marge", List(
      InvoiceItem("Beer", 1, 1.5))),
    Invoice("Kwik-E-Mart", "Bart", List(
      InvoiceItem("Coke", 2, 2.5),
      InvoiceItem("Chips", 2, 0.5))),
    Invoice("Kwik-E-Mart", "Marge", List(
      InvoiceItem("Cake", 2, 3.4),
      InvoiceItem("Corn Flakes", 5, 2.3))),
    Invoice("Moe", "Homer", List(
      InvoiceItem("Beer", 5, 1.5))),
    Invoice("Flander's Left-Handed Store", "Marge", List(
      InvoiceItem("Left-Handed Scissors", 1, 10.0)))
  )

  val recipients = List("Homer", "Bart", "Marge")

  it should "calculate the average age" in {
    Collections.averageAge(persons) shouldBe 33
  }

  it should "find the maximum age" in {
    Collections.maxAge(persons) shouldBe 49
  }

  it should "calculate statistics" in {
    Collections.ageStatistics(persons) shouldBe Statistics(4, 49, 33, 7, 236)
  }

  it should "extract first names" in {
    Collections.extractNames(persons) should contain allOf ("Jane Jungle", "Mary Smith", "John Dole", "Michael Abrahams", "Chris Cross", "Pete Power")
  }

  it should "extract names sorted by last name" in {
    Collections.extractNamesSortedByLastName(persons) shouldBe List("Michael Abrahams", "Chris Cross", "John Dole", "Jane Jungle", "Pete Power", "Maggie Simpson", "Mary Smith")
  }

  it should "collect first names of females" in {
    Collections.extractFemaleFirstNames(persons) should contain allOf ("Jane", "Mary", "Maggie")
  }

  it should "find adult woman" in {
    Collections.findAdultWomen(persons) shouldBe persons.take(2)
  }

  it should "extract first names with prefix" in {
    Collections.extractFirstnamesWhereLastnameStartsWith(persons, "S") should contain allOf ("Maggie", "Mary")
  }

  it should "build a comma separated list of first names" in {
    Collections.commaSeparatedFirstNames(persons) shouldBe "Jane, Mary, John, Michael, Chris, Pete, Maggie"
  }

  it should "find the cheapest product" in {
    Collections.cheapestProduct(invoices) shouldBe "Chips"
  }

  it should "find the most expensive product" in {
    Collections.mostExpensiveInvoice(invoices) shouldBe invoices(2)
  }

  it should "extract all products" in {
    Collections.extractProductNames(invoices) should contain allOf ("Beer", "Burger", "Corn Flakes", "Chips", "Coke", "Cake", "Left-Handed Scissors")
  }

  it should "group invoices by recipient" in {
    Collections.groupInvoicesByRecipient(invoices) shouldBe Map(
      "Homer" -> List(invoices.head, invoices(2), invoices(3), invoices(7)),
      "Bart" -> List(invoices(1), invoices(5)),
      "Marge" -> List(invoices(4), invoices(6), invoices(8))
    )
  }

  it should "find expenses by recipient" in {
    Collections.expensesByRecipient(invoices) shouldBe Map(
      "Homer" -> BigDecimal("79.6"),
      "Bart" -> BigDecimal("11"),
      "Marge" -> BigDecimal("29.8")
    )
  }

  it should "count by product" in {
    Collections.purchaseCountByProduct(invoices) shouldBe Map(
      "Burger" -> 8,
      "Coke" -> 4,
      "Beer" -> 28,
      "Chips" -> 4,
      "Cake" -> 2,
      "Corn Flakes" -> 5,
      "Left-Handed Scissors" -> 1
    )
  }

  it should "find the cheapest dealers by product" in {
    Collections.cheapestDealersByProduct(invoices) shouldBe Map(
      "Burger" -> "Moe",
      "Coke" -> "Kwik-E-Mart",
      "Beer" -> "Kwik-E-Mart",
      "Chips" -> "Kwik-E-Mart",
      "Cake" -> "Kwik-E-Mart",
      "Corn Flakes" -> "Kwik-E-Mart",
      "Left-Handed Scissors" -> "Flander's Left-Handed Store"
    )
  }

  it should "compute a dealers inventory" in {
    Collections.computeDealerInventory(invoices) shouldBe Map(
      "Crusty Burger" -> List(("Burger", 5), ("Coke", 5)),
      "Moe" -> List(("Beer", 1.5), ("Burger", 4.5)),
      "Kwik-E-Mart" -> List(("Beer", 0.9), ("Chips", 0.5), ("Coke", 2.5), ("Cake", 3.4), ("Corn Flakse", 2.3)),
      "Flander's Left-Handed Store" -> List(("Left-Handed Scissors", 10.0))
    )
  }

}
