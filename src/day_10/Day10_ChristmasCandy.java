package day_10;

/**
 * Mikołaj postanowił w tym roku skorzytać z pomocy nowoczesnych technologii.
 * Zamiast kupować choinkę i ozdoby postanowił użyć takich wygenerowanych w konsoli (terminalu)
 * Pomoż Mikołajowi! Przygotuj kod, który wypisze na ekranie laskę cukrową.
 * Jeżeli potrafisz, nie wpisuj laski bezpośrednio w printy - pokombinuj z pętlami.
 * Tak, żeby laska wygenerowała się sama!
 */

public class Day10_ChristmasCandy {

    public static void main(String[] args) {

        int height = 6;
        drawCandy(height);
    }

    private static void drawCandy(int height) {
        int numberOfEmptySpacesBetween = height / 3;
        int numberOfEmptySpacesBefore = 1;
        for (int i = 0; i < height; i++) {
            if (i == 0) {
                drawEmptySpaces(numberOfEmptySpacesBefore);
                drawTopOfCandy(height / 3);
                numberOfEmptySpacesBefore += numberOfEmptySpacesBetween;
            }
            if (i < height / 3) {
                System.out.print("#");
                drawEmptySpaces(numberOfEmptySpacesBetween);
                System.out.print("#\n");
            } else {
                drawEmptySpaces(numberOfEmptySpacesBefore);
                System.out.println("#");
            }
        }
    }

    private static void drawEmptySpaces(int numberOfSpaces) {
        for (int i = 0; i < numberOfSpaces; i++) {
            System.out.print(" ");
        }
    }

    private static void drawTopOfCandy(int numberOfElements) {
        for (int i = 0; i < numberOfElements; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}
