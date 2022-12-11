package day_11;

import java.util.List;

/**
 * Mikołaj pakuje prezenty w koperty. Zakupił trzy rozmiary: 10x15, 20x30, 30x30.
 * Dopasuj najmniejszą możliwą kopertę do każdego prezentu z listy.
 * Wypisz na ekranie, która koperta najlepiej pasuje do każdego prezentu.
 */

public class Day11_ChooseEnvelope {

    private static final String SEPARATOR = " - ";

    public static void main(String[] args) {
        List<Gift> gifts = prepareGifts();

        Envelope small = new Envelope(10, 15);
        Envelope medium = new Envelope(20, 30);
        Envelope big = new Envelope(30, 30);


        gifts.forEach(gift -> {
            String size;
            if ((gift.height() <= small.height() && gift.width() <= small.width())
                    || (gift.height() <= small.width() && gift.width() <= small.height())) {
                size = "small";
            } else if ((gift.height() <= medium.height() && gift.width() <= medium.width())
                    || (gift.height() <= medium.width() && gift.width() <= medium.height())) {
                size = "medium";
            } else if ((gift.height() <= big.height() && gift.width() <= big.width())
                    || (gift.height() <= big.width() && gift.width() <= big.height())) {
                size = "big";
            } else {
                size = "nie zmieści się do żadnej koperty :(";
            }
            System.out.println(gift.name() + SEPARATOR + size);
        });
    }

    private static List<Gift> prepareGifts() {
        return List.of(
                new Gift("Parfum", 12, 30),
                new Gift("Socks", 10, 10),
                new Gift("Book", 30, 25),
                new Gift("Clock", 15, 15),
                new Gift("Wallet", 5, 10)
        );
    }
}
