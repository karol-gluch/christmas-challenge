package day_3;

/**
 * Mikołaj postanowił w tym roku skorzytać z pomocy nowoczesnych technologii.
 * Zamiast kupować choinkę i ozdoby postanowił użyć takich wygenerowanych w konsoli (terminalu)
 * Pomoż Mikołajowi! Przygotuj kod, który wypisze na ekranie choinkę.
 * Jeżeli potrafisz, nie wpisuj drzewka bezposrednio w printy - pokombinuj z pętlami.
 * Przygotuj funkcję przyjmującą wysokość choinki i wypisującą choinkę na ekranie.
 * Tak, żeby choinka wygenerowała się sama! Choinka może być po prostu trójkątem, albo być żłożona z kilku warstw. :)
 */

public class Day3_ChristmasTree {

    private static final String EMPTY_SPACE = " ";
    private static final String PART_OF_CHRISTMAS_TREE = "*";
    private static final String TRUNK_FOR_BIG_CHRISTMAS_TREE = "| |";
    private static final String TRUNK_FOR_SMALL_CHRISTMAS_TREE = " |";

    public static void main(String[] args) {
        int height = 7;
        if (height < 2) {
            System.out.println("Nie będzie z tego choinki :(");
        } else {
            drawChristmasTree(height);
        }
    }

    private static void drawChristmasTree(int height) {
        int numberOfSpaces = height;
        int christmasTreeWidth = 1;
        for (int i = 1; i <= height; i++) {
            numberOfSpaces--;

            drawEmptySpaces(numberOfSpaces);
            drawChristmasTreeParts(christmasTreeWidth);

            christmasTreeWidth += 2;
        }
        drawChristmasTreeTrunk(height);
    }

    private static void drawEmptySpaces(int numberOfSpaces) {
        for (int i = numberOfSpaces; i > 0; i--) {
            System.out.print(EMPTY_SPACE);
        }
    }

    private static void drawChristmasTreeParts(int christmasTreeWidth) {
        for (int i = 0; i < christmasTreeWidth; i++) {
            System.out.print(PART_OF_CHRISTMAS_TREE);
        }
        System.out.println(EMPTY_SPACE);
    }

    private static void drawChristmasTreeTrunk(int height) {
        drawEmptySpaces(height - 2);
        if (height > 2) {
            System.out.print(TRUNK_FOR_BIG_CHRISTMAS_TREE);
        } else {
            System.out.print(TRUNK_FOR_SMALL_CHRISTMAS_TREE);
        }
    }
}
