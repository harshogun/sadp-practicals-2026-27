
package com.harsh.sadp.iterator;

public class Main {

    private static void printMenu(
            String title, MenuIterator iterator) {

        System.out.println("\n" + title);
        System.out.println("--------------------");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {

        BreakfastMenu breakfast = new BreakfastMenu();
        LunchMenu lunch = new LunchMenu();
        DinnerMenu dinner = new DinnerMenu();

        printMenu("BREAKFAST MENU", breakfast.createIterator());
        printMenu("LUNCH MENU", lunch.createIterator());
        printMenu("DINNER MENU", dinner.createIterator());
    }
}
