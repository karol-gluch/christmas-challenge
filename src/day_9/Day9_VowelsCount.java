package day_9;

import day_5.Address;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Mikołaj wykupił pakiet wysyłkowy do prezentów, ale przyoszczędził na wersji premium.
 * Przez to będzie musiał dopłacić 2 zł za każdą samogłoskę w adresie.
 * Pomóż Mikołajowi i policz ile będzie musiał dopłacić, a policzoną wartość wypisz na ekranie.
 * Adresy znajdziesz w przygotowanej liście, nie ma w nich polskich znaków.
 */

public class Day9_VowelsCount {

    private static final Integer PRICE_FOR_VOWEL = 2;

    public static void main(String[] args) {
        List<Address> addresses = prepareAddresses();
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');
        int numberOfVowels = 0;

        for (Address address : addresses) {
            String fullAddress = (address.getCity() + address.getStreet() + address.getNumber()).toLowerCase();
            for (Character characterFromAddress : fullAddress.toCharArray()) {
                if (vowels.contains(characterFromAddress)) {
                    numberOfVowels++;
                }
            }
        }

        int result = numberOfVowels * PRICE_FOR_VOWEL;
        System.out.println(result);
    }

    private static List<Address> prepareAddresses() {
        List<Address> addresses = new ArrayList<>();

        addresses.add(new Address("Serniczkowa",
                "4B",
                2,
                "Krakow",
                "02-326"
        ));
        addresses.add(new Address("Pierniczkowa",
                "289A",
                55,
                "Gdansk",
                "02-326"
        ));
        addresses.add(new Address("Barszczykowa",
                "234",
                5,
                "Rzeszow",
                "37-326"
        ));
        addresses.add(new Address("Uszkowa",
                "43H",
                5,
                "Wroclaw",
                "02-326"
        ));
        addresses.add(new Address("Cukierkowa",
                "23I",
                5,
                "Poznan",
                "02-326"
        ));

        return addresses;
    }
}
