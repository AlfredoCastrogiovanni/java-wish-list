package org.learning.wishlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String FILE_PATH = "./resources/data.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> wishlist = null;

        try {
            wishlist = readWishlist();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        while (true) {
            System.out.println();
            System.out.println("Do you want add a item to wishlist? (y/n)");
            String choice = scanner.nextLine();
            System.out.println();

            switch (choice) {
                case "y":
                    System.out.println("Enter the item: ");
                    wishlist.add(scanner.nextLine());
                    System.out.println("Wishlist size: " + wishlist.size());
                    break;
                case "n":
                    Collections.sort(wishlist);
                    writeWishlist(wishlist);
                    System.out.println(wishlist);
                    scanner.close();
                    return;
                default:
                System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    public static List<String> readWishlist() throws FileNotFoundException {
        File file = new File(FILE_PATH);

        List<String> wishlist = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                wishlist.add(scanner.nextLine());
            }
            return wishlist;
        } catch (Exception e) {
            throw new FileNotFoundException("File not found");
        }
    }

    public static void writeWishlist(List<String> wishlist) {
        File file = new File(FILE_PATH);

        try (FileWriter fw = new FileWriter(file)) {
            for (String item : wishlist) {
                fw.write(item + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
