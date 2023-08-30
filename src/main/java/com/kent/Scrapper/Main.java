package com.kent.Scrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            menu(sc);
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // This method is used to display the menu
    private static void menu(Scanner sc) {

        try {
        System.out.println("Welcome to the Scrapper");
        System.out.println("1. Text Search");
        System.out.println("2. Placeholder");


        // This is the user input for the menu
        String response = String.valueOf(sc.nextLine());
        switch (response) {
            case "1":
                textSearchRequest();
                break;
            case "2":
                System.out.println("Not Implemented");
                break;
            default:
                System.out.println("Invalid Response");
                break;
        }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // This method is used to get the user input for the text search
    private static void textSearchRequest() {
        try {
            Scanner sc = new Scanner(System.in);
            ArrayList<String> urls = new ArrayList<String>();
            System.out.print("Enter the URL or URLS: ");
            urls.addAll(Arrays.asList(sc.nextLine().split(" ")));
            System.out.print("Enter the targets Name: ");
            String target = sc.nextLine();
            new textContentSearch(target, urls);
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}