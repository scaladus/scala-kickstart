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
package org.scaladus.java2scala

import java.time.{LocalDate, Period}
import java.util.UUID

sealed trait Person {
  def firstName: String

  def lastName: String

  def birthday: LocalDate

  def age: Int = Period.between(birthday, LocalDate.now()).getYears

  require(birthday.isBefore(LocalDate.now()), "Birthday can not be in the future")
}

final case class Customer(firstName: String,
                          lastName: String,
                          birthday: LocalDate,
                          customerId: String = UUID.randomUUID().toString)
  extends Person

final case class Employee(firstName: String,
                          lastName: String,
                          birthday: LocalDate,
                          salary: BigDecimal)
  extends Person {
  require(salary >= 0, "salary can not be less than 0")
}
