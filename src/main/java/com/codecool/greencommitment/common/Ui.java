package com.codecool.greencommitment.common;

import java.util.Scanner;

public class Ui {

    Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }
}
