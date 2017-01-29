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

import java.time.{LocalDate, Period}

object Collections {

  /**
    * Compute the average age of the given list of Persons.
    */
  def averageAge(persons: List[Person]): Double = persons.map(_.age).sum / persons.length

  /**
    * How old is the oldest person in the given list.
    */
  def maxAge(persons: List[Person]): Int = persons.map(_.age).max

  def minAge(persons: List[Person]): Int = persons.map(_.age).min

  def countAges(persons: List[Person]): Int = persons.map(_.age).toSet.size

  /**
    * Compute Age-Statistics (max, min, average, ...) for the given list of Persons.
    */
  def ageStatistics(persons: List[Person]): Statistics = Statistics(
    max = maxAge(persons),
    min = minAge(persons),
    avg = averageAge(persons),
    count = countAges(persons),
    sum = persons.map(_.age).sum
  )

  /**
    * Extract a list of names (firstname and lastname separated by space) from a given list of Person objects.
    *
    * Example-Result: ["Maggie Smith", "Marge Simpson", "Mary Lee"]
    */
  def extractNames(persons: List[Person]): List[String] =
    persons
      .map(person => s"${person.firstName} ${person.lastName}")

  /**
    * Extract a sorted (ascending by lastname) list of names (firstname and lastname separated by space) from a given list of Person objects.
    */
  def extractNamesSortedByLastName(persons: List[Person]): List[String] =
    extractNames(persons.sortBy(_.lastName))

  /**
    * From a given list of Person objects, extract a list of female firstnames
    */
  def extractFemaleFirstNames(persons: List[Person]): List[String] = persons
    .filter(_.gender == Female)
    .map(person => person.firstName)

  /**
    * Extract all females older than 18 years from a given list of Person objects.
    */
  def findAdultWomen(persons: List[Person]): List[Person] =
    persons
      .filter(person => (person.age > 18) && (person.gender == Female))

  /**
    * From a given list of Person objects, extract a set of firstnames of the people whose lastname starts with the given string.
    */
  def extractFirstnamesWhereLastnameStartsWith(persons: List[Person], startsWith: String): List[String] =
    persons
      .filter(_.lastName.startsWith(startsWith))
      .map(_.firstName)

  /**
    * Build a comma-separated list of the firstnames of a list of Persons.
    *
    * Example-Result: "Maggie, Marge, Mary"
    */
  def commaSeparatedFirstNames(persons: List[Person]): String =
    persons
      .map(_.firstName)
      .mkString(", ")

  /**
    * Identify the cheapest product (by pricePerUnit) in all invoices.
    */
  def cheapestProduct(invoices: List[Invoice]): String =
    invoices
      .flatMap(_.items)
      .sortBy(_.pricePerUnit)
      .head
      .productName

  /**
    * From a given list of invoices, extract a set of all product names.
    */
  def extractProductNames(invoices: List[Invoice]): List[String] =
    invoices
      .flatMap(_.items)
      .map(_.productName)


  /**
    * Identify the invoice with the highest total amount.
    */
  def mostExpensiveInvoice(invoices: List[Invoice]): Invoice =
    invoices
      .sortBy(_.total)
      .last

  /**
    * Just what the method name says.
    */
  def groupInvoicesByRecipient(invoices: List[Invoice]): Map[String, List[Invoice]] =
    invoices.groupBy(_.recipient)

  /**
    * Compute the total amount, that each receiver spent.
    */
  def expensesByRecipient(invoices: List[Invoice]): Map[String, BigDecimal] =
    groupInvoicesByRecipient(invoices)
      .map({
        case (key, theInvoices) =>
          (key, theInvoices
            .flatMap(_.items)
            .map(i => i.pricePerUnit * i.quantity).sum)
      })


  /**
    * How many items of each product have been purchased?
    */
  def purchaseCountByProduct(invoices: List[Invoice]): Map[String, Int] =
    invoices
      .flatMap(_.items)
      .groupBy(_.productName)
      .map({ case (productName, items) => (productName, items.map(_.quantity).sum) })

  /**
    * For every product, compute the cheapest dealer. Return as a Map where the key is the product name and the value
    * is the dealer (=sender of the invoice).
    */
  def cheapestDealersByProduct(invoices: List[Invoice]): Map[String, String] = ???


  /**
    * From a given list of invoices, compute for every dealer the available products together with its price.
    */
  def computeDealerInventory(invoices: List[Invoice]): Map[String, List[(String, BigDecimal)]] =
    invoices
      .groupBy(_.sender)
      .map { case (sender, invoices2) => (sender, invoices2
        .flatMap(_.items)
        .map(item => (item.productName, item.pricePerUnit)))
      }

  case class Person(firstName: String, lastName: String, birthday: LocalDate, gender: Gender) {
    val age: Int = Period.between(birthday, LocalDate.now()).getYears
  }

  sealed trait Gender

  object Female extends Gender

  object Male extends Gender

  case class Statistics(min: Int, max: Int, avg: Double, count: Int, sum: Int)

  case class Invoice(sender: String, recipient: String, items: List[InvoiceItem]) {
    val total: Int = items.map { i => i.pricePerUnit * i.quantity }.sum.intValue()
  }

  case class InvoiceItem(productName: String, quantity: Int, pricePerUnit: BigDecimal)

}
