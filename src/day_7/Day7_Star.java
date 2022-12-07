package day_7;

/**
 * Mikołaj postanowił w tym roku skorzytać z pomocy nowoczesnych technologii.
 * Zamiast kupować choinkę i ozdoby postanowił użyć takich wygenerowanych w konsoli
 * Pomoż Mikołajowi! Przygotuj kod, który wypisze na ekranie gwiazdkę.
 * Jeżeli potrafisz, nie wpisuj gwiazdki bezposrednio w printy - pokombinuj z pętlami.
 * Tak, żeby gwiazdka wygenerowała się sama!
 * Gwiazdka może mieć dowolny kształt, wygeneruj taki jaki potrafisz. Przykładowe gwiazdki:
 *     *       *       *         *
 *     *         *   *        *******
 * *********   **********      *****
 *     *         *   *        *******
 *     *       *       *         *
 */

public class Day7_Star {

    private static final String EMPTY_SPACE = " ";
    private static final String PART_OF_STAR = "*";
    private static final Integer NUMBER_OF_SPACES_ON_NEXT_LEVEL_OF_STAR = 4;
    private static final Integer CENTER_OF_STAR = 2;

    public static void main(String[] args) {
        int size = 9;
        drawStar(size);
    }

    private static void drawStar(int size) {
        int numberOfSpacesInFrontOfArm = 0;
        int numberOfSpacesBetweenTwoArmsOfStar = size * CENTER_OF_STAR - NUMBER_OF_SPACES_ON_NEXT_LEVEL_OF_STAR;
        for (int i = 0; i < size; i++) {

            if (i < size / CENTER_OF_STAR) {
                drawEmptySpaces(numberOfSpacesInFrontOfArm);
                drawStarParts(numberOfSpacesInFrontOfArm, numberOfSpacesBetweenTwoArmsOfStar);
                numberOfSpacesInFrontOfArm++;
                numberOfSpacesBetweenTwoArmsOfStar -= NUMBER_OF_SPACES_ON_NEXT_LEVEL_OF_STAR;
            } else if (i > size / CENTER_OF_STAR) {
                numberOfSpacesInFrontOfArm--;
                numberOfSpacesBetweenTwoArmsOfStar += NUMBER_OF_SPACES_ON_NEXT_LEVEL_OF_STAR;
                drawEmptySpaces(numberOfSpacesInFrontOfArm);
                drawStarParts(numberOfSpacesInFrontOfArm, numberOfSpacesBetweenTwoArmsOfStar);
            } else {
                drawCenterOfStar(size);
            }
        }
    }

    private static void drawEmptySpaces(int numberOfSpaces) {
        for (int i = numberOfSpaces; i > 0; i--) {
            System.out.print(EMPTY_SPACE);
        }
    }

    private static void drawStarParts(int numberOfSpacesInFrontOfArm, int numberOfSpacesBetweenTwoArmsOfStar) {
        drawEmptySpaces(numberOfSpacesInFrontOfArm);
        System.out.print(PART_OF_STAR);
        drawEmptySpaces(numberOfSpacesBetweenTwoArmsOfStar);
        System.out.println(PART_OF_STAR);
    }

    private static void drawCenterOfStar(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(PART_OF_STAR + EMPTY_SPACE);
        }
        System.out.println(EMPTY_SPACE);
    }
}
