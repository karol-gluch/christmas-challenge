package day_5;

import java.util.Objects;

public record Address(String street, String number, int flatNumber, String city, String zipCode) {

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Address address = (Address) o;
        return flatNumber == address.flatNumber && Objects.equals(street, address.street) && Objects.equals(number, address.number)
                && Objects.equals(city, address.city) && Objects.equals(zipCode, address.zipCode);
    }
}