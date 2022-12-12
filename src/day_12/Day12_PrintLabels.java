package day_12;

import day_5.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Pomóż Mikołajowi przygotować etykiety do druku na prezenty!
 * Dla każdego dziecka z listy wypisz w konsoli imię, nazwisko i adres w formacie jak na list.
 * Rozdziel przygotowane etykiety liniami.
 */

public class Day12_PrintLabels {

    private static final String SEPARATOR = " ";
    private static final String ADDRESS_SEPARATOR = "/";

    public static void main(String[] args) {

        List<ChildWithAddress> children = prepareChildren();
        List<LabelAddress> labelAddresses = buildLabelAddresses(children);
        int longestPartOfLabel = getLongestPartOfLabel(labelAddresses);
        labelAddresses.forEach(label -> printLabel(label, longestPartOfLabel));
        printLineBetweenAddresses(longestPartOfLabel);
    }

    private static List<LabelAddress> buildLabelAddresses(List<ChildWithAddress> children) {
        List<LabelAddress> labelAddresses = new ArrayList<>();
        children.forEach(child ->
                labelAddresses.add(new LabelAddress(
                        child.name() + SEPARATOR + child.surname(),
                        child.address().street() + SEPARATOR + child.address().number() + ADDRESS_SEPARATOR + child.address().flatNumber(),
                        child.address().city() + SEPARATOR + child.address().zipCode()))
        );
        return labelAddresses;
    }

    private static int getLongestPartOfLabel(List<LabelAddress> labelAddresses) {
        int longestPartOfLabel = 0;
        for (LabelAddress label : labelAddresses) {
            if (label.nameAndSurname().length() > longestPartOfLabel) {
                longestPartOfLabel = label.nameAndSurname().length();
            } else if (label.streetAndNumber().length() > longestPartOfLabel) {
                longestPartOfLabel = label.streetAndNumber().length();
            } else if (label.zipCodeAndCity().length() > longestPartOfLabel) {
                longestPartOfLabel = label.zipCodeAndCity().length();
            }
        }
        return longestPartOfLabel + 2;
    }

    private static void printLabel(LabelAddress label, int longestPartOfLabel) {
        printLineBetweenAddresses(longestPartOfLabel);
        printPartOfLabel(label.nameAndSurname(), longestPartOfLabel);
        printPartOfLabel(label.streetAndNumber(), longestPartOfLabel);
        printPartOfLabel(label.zipCodeAndCity(), longestPartOfLabel);
    }

    private static void printLineBetweenAddresses(int longestPartOfLabel) {
        for (int i = 0; i < longestPartOfLabel; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private static void printPartOfLabel(String labelPart, int longestPartOfLabel) {
        int spaceBeforePartOfLabel = (longestPartOfLabel - labelPart.length()) / 2;
        for (int i = 0; i < spaceBeforePartOfLabel; i++) {
            System.out.print(SEPARATOR);
        }
        System.out.println(labelPart);
    }

    private static List<ChildWithAddress> prepareChildren() {
        return List.of(
                new ChildWithAddress(
                        "Jasiu",
                        "Kowalski",
                        new Address("Serniczkowa",
                                "4B",
                                2,
                                "Krakow",
                                "02-326"
                        )),
                new ChildWithAddress(
                        "Kasia",
                        "Nowak",
                        new Address("Pierniczkowa",
                                "289",
                                55,
                                "Gdansk",
                                "02-326"
                        )),
                new ChildWithAddress(
                        "Asia",
                        "Wisniewska",
                        new Address("Barszczykowa",
                                "234",
                                5,
                                "Rzeszow",
                                "37-326"
                        )),
                new ChildWithAddress(
                        "Tomek",
                        "Wojcik",
                        new Address("Uszkowa",
                                "43H",
                                5,
                                "Wroclaw",
                                "02-326"
                        ))
        );
    }
}
