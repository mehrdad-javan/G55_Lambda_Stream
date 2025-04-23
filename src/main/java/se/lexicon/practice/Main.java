package se.lexicon.practice;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Apple iPhone 14", 999.99, 25));
        productList.add(new Product("Samsung Galaxy S22", 849.99, 30));
        productList.add(new Product("Sony WH-1000XM5 Headphones", 379.99, 0));
        productList.add(new Product("Dell XPS 13 Laptop", 1199.99, 10));
        productList.add(new Product("B Apple Watch Series 8", 399.00, 20));
        productList.add(new Product("GoPro HERO11", 499.99, 18));
        productList.add(new Product("Nintendo Switch OLED", 349.99, 22));
        productList.add(new Product("Amazon Echo Dot (5th Gen)", 49.99, 0));
        productList.add(new Product("Canon EOS R50 Camera", 679.99, 8));
        productList.add(new Product("Logitech MX Master 3S Mouse", 99.99, 40));


        // Print out all Products that have stock value of 0.
        Conditional stockValueZero = product -> product.getStock() == 0;
        Action actionPrint = product -> System.out.println(product.toString());
        process(productList, stockValueZero, actionPrint);

        System.out.println("-------------------");

        // Print out the productName of all the Products that starts with B.
        Conditional conditionalStartsWithB = product -> product.getProductName().startsWith("B");
        //Action actionPrintName = product -> System.out.println(product.getProductName());
        process(productList, conditionalStartsWithB, actionPrint);

        // Print out all Products that have price above 100 AND lower than 150
        // todo: needs completion
        // Increase the price of all Products that have a stock value of less than 10 AND above 0 by 50%
        // todo: needs completion

    }

    public static void process(List<Product> productList, Conditional conditional, Action action){
        for(Product product : productList){
            if(conditional.test(product)){
                action.execute(product);
            }
        }
    }

}
