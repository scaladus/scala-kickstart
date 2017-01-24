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
  def averageAge(persons: List[Person]): Double = ???

  /**
    * How old is the oldest person in the given list.
    */
  def maxAge(persons: List[Person]): Int = ???

  /**
    * Compute Age-Statistics (max, min, average, ...) for the given list of Persons.
    */
  def ageStatistics(persons: List[Person]): Statistics = ???

  /**
    * Extract a list of names (firstname and lastname separated by space) from a given list of Person objects.
    *
    * Example-Result: ["Maggie Smith", "Marge Simpson", "Mary Lee"]
    */
  def extractNames(persons: List[Person]): List[String] = ???

  /**
    * Extract a sorted (ascending by lastname) list of names (firstname and lastname separated by space) from a given list of Person objects.
    */
  def extractNamesSortedByLastName(persons: List[Person]): List[String] = ???

  /**
    * From a given list of Person objects, extract a list of female firstnames
    */
  def extractFemaleFirstNames(persons: List[Person]): List[String] = ???

  /**
    * Extract all females older than 18 years from a given list of Person objects.
    */
  def findAdultWomen(persons: List[Person]): List[Person] = ???

  /**
    * From a given list of Person objects, extract a set of firstnames of the people whose lastname starts with the given string.
    */
  def extractFirstnamesWhereLastnameStartsWith(persons: List[Person], startsWith: String): List[String] = ???

  /**
    * Build a comma-separated list of the firstnames of a list of Persons.
    *
    * Example-Result: "Maggie, Marge, Mary"
    */
  def commaSeparatedFirstNames(persons: List[Person]): String = ???

  /**
    * Identify the cheapest product (by pricePerUnit) in all invoices.
    */
  def cheapestProduct(invoices: List[Invoice]): String = ???

  /**
    * From a given list of invoices, extract a set of all product names.
    */
  def extractProductNames(invoices: List[Invoice]): List[String] = ???

  /**
    * Identify the invoice with the highest total amount.
    */
  def mostExpensiveInvoice(invoices: List[Invoice]): Invoice = ???

  /**
    * Just what the method name says.
    */
  def groupInvoicesByRecipient(invoices: List[Invoice]): Map[String, List[Invoice]] = ???

  /**
    * Compute the total amount, that each receiver spent.
    */
  def expensesByRecipient(invoices: List[Invoice]): Map[String, BigDecimal] = ???

  /**
    * How many items of each product have been purchased?
    */
  def purchaseCountByProduct(invoices: List[Invoice]): Map[String, Int] = ???

  /**
    * For every product, compute the cheapest dealer. Return as a Map where the key is the product name and the value
    * is the dealer (=sender of the invoice).
    */
  def cheapestDealersByProduct(invoices: List[Invoice]): Map[String, String] = ???

  /**
    * From a given list of invoices, compute for every dealer the available products together with its price.
    */
  def computeDealerInventory(invoices: List[Invoice]): Map[String, List[(String, BigDecimal)]] = ???

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
