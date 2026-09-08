package aula03;

import java.util.Scanner;

public class Endoffile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = 1;

        while (scanner.hasNextLine()) {

            String linha = scanner.nextLine();
            System.out.println( i + " " + linha);
            i++;
        }


    }

}
