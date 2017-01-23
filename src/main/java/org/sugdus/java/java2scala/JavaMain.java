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
package org.sugdus.java.java2scala;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static java.lang.String.format;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JUNE;

public class JavaMain {

    public static void main(String[] args) {
        Employee bob = new Employee("Bob", "Smith", LocalDate.of(1973, FEBRUARY, 12), new BigDecimal("42.500"));
        Customer jim = new Customer("Jim", "Miller", LocalDate.of(1956, JUNE, 19), UUID.randomUUID().toString());

        printPerson(bob);
        printPerson(jim);
    }

    private static void printPerson(Person person) {
        System.out.println(format("%s is %d years old", person.getFirstName(), person.calculateAge()));
    }
}
