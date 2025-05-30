package application;

import model.entities.Product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        System.out.println("Write the source file path:");
        String sourceFileStr = sc.nextLine();

        File sourceFile = new File(sourceFileStr);
        String sourceFolder = sourceFile.getParent();

        boolean success = new File(sourceFolder + "/out").mkdir();

        String targetFileStr = sourceFolder + "/out/summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {

            String itemCsv = br.readLine();

            while (itemCsv != null) {
                String[] vect = itemCsv.split(",");
                String name = vect[0];
                double price = Double.parseDouble(vect[1]);
                int quantity = Integer.parseInt(vect[2]);

                products.add(new Product(name, price, quantity));
                itemCsv = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

                for (Product product : products) {
                    bw.write(product.getName() + "," + product.totalValue());
                    bw.newLine();
                }

                System.out.println(targetFileStr + " CREATED!");
            } catch (IOException e) {
                System.out.println("File couldn't be created! " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error Reading File: " + e.getMessage());
        }
    }
}
