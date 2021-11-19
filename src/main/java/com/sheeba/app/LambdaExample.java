package com.sheeba.app;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExample {
    String s() {
        return "sucess";
    }

    public static void main(String[] arg) throws IOException {
        List<String> value = new ArrayList<>();
        value.add("boy");
        value.add("girl");
        value.add("grandma");
        value.add("grand father");
        value.add("grand father");

//        (String s )->System.out.println(s);
        value.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        Sayable sayable = () -> {
            return "calling interface Sayable";
        };

        String output = sayable.say();

//        for (int i = 1; i <= 5; i++) {
//            int num = i * 5;
//            System.out.println(num);
//        }
//        for(int i=0;i<=50;i++){
//            if(i%5==0){
//                System.out.println(i);
//            }
//        }

        Stream.iterate(1, element -> element + 1)
                .filter(element -> element % 5 == 0)
                .limit(5)
                .forEach(System.out::println);

        List<DrinksPojo> drinksList = new ArrayList<>();
        DrinksPojo fanta = new DrinksPojo("fanta", 10, 50);
        DrinksPojo pepsi = new DrinksPojo("pepsi", 0, 15);
        DrinksPojo cock = new DrinksPojo("cock", 10, 10);
        DrinksPojo miranda = new DrinksPojo("miranda", 10, 20);
        DrinksPojo appleJuice = new DrinksPojo("appleJuice", 4, 56);
        DrinksPojo mango = new DrinksPojo("mango", 7, 89);
        DrinksPojo grapes = new DrinksPojo("grapes", 9, 23);
        DrinksPojo lemon = new DrinksPojo("lemon", 10, 50);
        DrinksPojo frooti = new DrinksPojo("frooti", 9, 89);

        drinksList.add(fanta);
        drinksList.add(pepsi);
        drinksList.add(cock);
        drinksList.add(miranda);
        drinksList.add(appleJuice);
        drinksList.add(mango);
        drinksList.add(grapes);
        drinksList.add(lemon);
        drinksList.add(frooti);

        List<DrinksPojo> drink = drinksList.stream()
                .filter(product -> product.getStock() > 0)
                .collect(Collectors.toList());

        List<String> productName = drinksList.stream()
                .filter(product -> product.getStock() > 0)
                .map(product -> product.getProductName())
                .collect(Collectors.toList());

        List<String> allProductName = drinksList.stream()
                .map(product -> product.getProductName())
                .collect(Collectors.toList());

        drinksList.stream()
                .filter(d -> d.getStock() > 0)
                .forEach(d -> d.getProductName());

        Set<String> coolDrinks = drinksList.stream()
                .filter(c -> c.getStock() > 0)
                .map(d -> d.getProductName())
                .collect(Collectors.toSet());

        Stream.iterate(0, element -> element + 1)
                .filter(element -> element % 2 == 0)
                .limit(10)
                .forEach(val -> System.out.println(val));

        Map<Integer, List<String>> stockMapByNames = new HashMap<>();
        for (DrinksPojo drinksPojo : drinksList) {
            boolean isStockPresent = stockMapByNames.containsKey(drinksPojo.getStock());
            if (isStockPresent) {
                List<String> productNames = stockMapByNames.get(drinksPojo.getStock());
                stockMapByNames.put(drinksPojo.getStock(), productNames);
            } else {
                List<String> productNames = new ArrayList<>();
                stockMapByNames.put(drinksPojo.getStock(), productNames);
            }
        }

        Map<Integer, List<String>> stock = drinksList.stream()
                .limit(2)
                .collect(Collectors.groupingBy(DrinksPojo::getStock, Collectors.mapping(DrinksPojo::getProductName, Collectors.toList())));

        Map<String, Long> countProduct = drinksList.stream()
                .collect(Collectors.groupingBy(DrinksPojo::getProductName, Collectors.counting()));

        List<DrinksPojo> drinks = new ArrayList<>();
        DrinksPojo fanta1 = new DrinksPojo("fanta", 10, 50);
        DrinksPojo fanta2 = new DrinksPojo("fanta", 10, 50);
        DrinksPojo fanta3 = new DrinksPojo("fanta", 10, 50);
        DrinksPojo pepsi1 = new DrinksPojo("pepsi", 0, 34);
        DrinksPojo pepsi2 = new DrinksPojo("pepsi", 8, 34);
        DrinksPojo pepsi3 = new DrinksPojo("pepsi", 0, 34);
        DrinksPojo pepsi4 = new DrinksPojo("pepsi", 0, 34);
        DrinksPojo lemon1 = new DrinksPojo("lemon", 10, 20);
        DrinksPojo lemon2 = new DrinksPojo("lemon", 10, 20);
        drinks.add(fanta1);
        drinks.add(fanta2);
        drinks.add(fanta3);
        drinks.add(pepsi1);
        drinks.add(pepsi2);
        drinks.add(pepsi3);
        drinks.add(pepsi4);
        drinks.add(lemon1);
        drinks.add(lemon2);

        Map<String, Long> mapByName = drinks.stream()
                .collect(Collectors.groupingBy(DrinksPojo::getProductName, Collectors.counting()));

        Map<String, Integer> mapStock = new HashMap<>();
        for (DrinksPojo d : drinks) {
            boolean isProductNamePresent = mapStock.containsKey(d.getProductName());
            if (isProductNamePresent) {
                int count = mapStock.get(d.getProductName());
                int total = 0;
                total = count + d.getStock();
                mapStock.put(d.getProductName(), total);
            } else {
                int stocks = d.getStock();
                mapStock.put(d.getProductName(), stocks);
            }
        }

        Map<String, Integer> mapStockTotal = drinks.stream()
                .collect(Collectors.groupingBy(DrinksPojo::getProductName, Collectors.summingInt(DrinksPojo::getStock)));

        Map<String, Double> rateMap = drinksList.stream().collect(Collectors.toMap(DrinksPojo::getProductName, DrinksPojo::getCost));

        Map<String, List<String>> mapByRate = drinks.stream().collect(Collectors.groupingBy(DrinksPojo::getProductName, Collectors.mapping(d -> {
            if (d.getCost() <= 20) return "normal";
            else return "high";
        }, Collectors.toList())));

        Map<String, String> typeOfCost = drinksList.stream()
                .collect(Collectors.toMap(DrinksPojo::getProductName, (d -> {
                    if (d.getCost() <= 10) return "low price" + " : " + d.getCost();
                    else if (d.getCost() > 10 && d.getCost() <= 50) return "medium" + " : " + d.getCost();
                    else return "high" + " : " + d.getCost();
                })));

        double maxCost = drinksList.stream()
                .mapToDouble(DrinksPojo::getCost)
                .max().orElse(0.0);

        List<Double> costHigh = drinksList.stream()
                .filter(d -> d.getCost() >= 50)
                .sorted(Comparator.comparing(DrinksPojo::getCost))
                .map(DrinksPojo::getCost)
                .collect(Collectors.toList());

        List<String> maxName = drinksList.stream()
                .filter(d -> d.getCost() >= 50)
                .sorted(Comparator.comparing(DrinksPojo::getCost))
                .map(DrinksPojo::getProductName)
                .collect(Collectors.toList());

        List<Double> costHighUnique = drinksList.stream()
                .filter(d -> d.getCost() >= 50)
                .sorted(Comparator.comparing(DrinksPojo::getCost))
                .map(DrinksPojo::getCost)
                .distinct()
                .collect(Collectors.toList());

        List<Integer> getLength = drinksList.stream()
                .map(DrinksPojo::getProductName)
                .map(d -> d.length())
                .collect(Collectors.toList());

        List<String> helloWorld = Arrays.asList("hello", "world");

        List<String[]> words = helloWorld.stream().map(word -> word.split(""))
                .collect(Collectors.toList());

        List<String> wordUnique = helloWorld.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

//        File file = new File("M:\\Documents\\List_Textfile.txt");
//        List<String> text = Files.readAllLines(file.toPath());
//        text.parallelStream().forEach(System.out::println);


    }
}
