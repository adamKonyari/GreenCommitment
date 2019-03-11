package com.codecool.greencommitment;

import com.codecool.greencommitment.client.Client;
import com.codecool.greencommitment.server.Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        if (args[0].equals("CLIENT")) {
            Client client = new Client();
            client.start(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        } else if (args[0].equals("SERVER")) {
            Server server = new Server();
            server.start(Integer.parseInt(args[1]));
            // STARTING SERVER CODE
        } else {
            System.out.println("Invalid argument!");
            System.out.println("Possible arguments: CLIENT, SERVER");

        }
    }
}
