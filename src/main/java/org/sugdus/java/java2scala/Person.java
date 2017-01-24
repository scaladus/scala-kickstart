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

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Person {

    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;

    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = requireNonNull(firstName, "firstName must not be null");
        this.lastName = requireNonNull(lastName, "lastName must not be null");
        this.birthday = requireNonNull(birthday, "birthday must not be null");
        if (birthday.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Birthday can not be in the future");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int calculateAge() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(birthday, person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
