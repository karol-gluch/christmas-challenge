package day_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Wyzwanie Świąteczne @wswieciekodu
 * Dzień 1
 * Mikołaj musi odwiedzić 3 miasta o współrzędnych (1,1), (4,5), (11,5) w podanej kolejności.
 * Mikołaj startuje z punktu(1,1) spod stacji paliw ;)
 * Na 10 jednostek odległości jego sanie zużywają 20 litrów magicznego paliwa.
 * Ile paliwa potrzebuje na całą trasę? Do policzenia przygotuj odpowiedni kod.
 * Obliczony wynik wypisz na ekranie.
 *
 * Oblicz w kodzie dystans miedzy miastami, a nastepnie policz niezbedną ilosc paliwa.
 * Do obliczenia dystansu przygotuj odpowiednią funkcję.
 * Do obliczeń matematycznych użyj funkcji z biblioteki Twojego jezyka.
 */

public class Day1_Cities {

    private static final int FUEL_CONSUMPTION = 20 / 10;

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(4, 5));
        points.add(new Point(11, 5));

        double distanceBetweenCities = 0;
        for(int i = 0; i < points.size() - 1; i++) {
            distanceBetweenCities += calculateRoadLength(points.get(i), points.get(i + 1));
        }

        double neededFuel = distanceBetweenCities * FUEL_CONSUMPTION;

        System.out.println("Needed fuel = " + neededFuel); // result = 24
    }

    private static double calculateRoadLength(Point firstPoint, Point secondPoint) {
        return Math.sqrt(Math.pow(secondPoint.getY() - firstPoint.getY(), 2) + Math.pow(secondPoint.getX() - firstPoint.getX(), 2));
    }
}

