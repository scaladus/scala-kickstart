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
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class Customer extends Person {

    private final String customerId;

    public Customer(String firstName, String lastName, LocalDate birthday, String customerId) {
        super(firstName, lastName, birthday);
        this.customerId = requireNonNull(customerId, "customerId must not be null");
    }

    public String getCustomerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customerId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                "} " + super.toString();
    }
}
