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

import java.time.LocalDate
import java.time.Month.{FEBRUARY, JUNE}

object ScalaMain {

  def main(args: Array[String]): Unit = {
    val bob = Employee("Bob", "Smith", LocalDate.of(1973, FEBRUARY, 12), 42500)
    val jim = Customer("Jim", "Miller", LocalDate.of(1956, JUNE, 19))

    printPerson(bob)
    printPerson(jim)
  }

  private def printPerson(person: Person) {
    println(s"${person.firstName} is ${person.age} years old")
  }
}
