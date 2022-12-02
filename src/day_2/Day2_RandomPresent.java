package day_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Mikołaj postanowił w tym roku skorzystać z pomocy nowoczesnych technologii.
 * Zamiast zastanawiać się, komu jaki prezent dostarczyć postanowił skorzystać z programu.
 * Pomoż Mikołajowi!
 * Przygotuj kod, który z listy dostępnych prezentów wylosuje 3 prezenty i wypisze na ekranie.
 * Odpal program kilka razy - sprawdź, czy na pewno losuje za kazdym razem inne prezenty!
 * Wylosowane prezenty wypisz na ekranie. Zadbaj o to, żeby wylosowane prezenty były unikalne.
 */

public class Day2_RandomPresent {

    private static final int NUMBER_OF_GIFTS = 3;

    public static void main(String[] args) {

        List<String> ideas = List.of(
                "Perfume", "Socks", "Sweater", "Cup",
                "Hat", "Tea", "Coffee", "Clock", "Bag",
                "Book", "Wallet", "Cream", "Earrings");

        Random random = new Random();

        Set<Integer> giftNumberSet = new HashSet<>();
        while (giftNumberSet.size() < NUMBER_OF_GIFTS) {
            giftNumberSet.add(random.nextInt(ideas.size()));
        }

        List<Integer> giftNumberList = new ArrayList<>(giftNumberSet);
        for (int i = 0; i < NUMBER_OF_GIFTS; i++) {
            System.out.println(ideas.get(giftNumberList.get(i)));
        }
    }
}
