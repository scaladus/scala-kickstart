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
import java.util.Objects;

public class Employee extends Person {

    private final BigDecimal salary;

    public Employee(String firstName, String lastName, LocalDate birthday, BigDecimal salary) {
        super(firstName, lastName, birthday);
        this.salary = Objects.requireNonNull(salary, "salary must not be null");
        if (salary.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("salary can not be less than 0");
        }
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary='" + salary + '\'' +
                "} " + super.toString();
    }
}
