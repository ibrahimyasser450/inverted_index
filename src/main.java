import java.io.IOException;

import java.util.Scanner;


public class main {
    public static void main(String[] args) throws IOException {
        InvertedIndex index = new InvertedIndex();
    for (int i = 1; i <= 10; i++) {
            index.buildIndex( i + ".txt");}
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a word to search for: ");
            String query = scanner.nextLine();
            if (query.equals("exit")) break;
            index.search(query);
        }
    }
}