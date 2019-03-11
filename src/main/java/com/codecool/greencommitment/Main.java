package com.codecool.greencommitment;

public class Main {

    public static void main(String[] args) {

        if (args[0].equals("CLIENT")) {
            // STARTING CLIENT CODE
        } else if (args[0].equals("SERVER")) {
            // STARTING SERVER CODE
        } else {
            System.out.println("Invalid argument!");
            System.out.println("Possible arguments: CLIENT, SERVER");
        }
    }
}
