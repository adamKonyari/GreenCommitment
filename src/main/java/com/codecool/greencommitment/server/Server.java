package com.codecool.greencommitment.server;

import com.codecool.greencommitment.common.Measurement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {

    private List<Measurement> measurementList = new ArrayList<>();
    private int portNumber;

    public Server(int portNumber) {
        this.portNumber = portNumber;
    }

    public void start(int portNumber) throws IOException, ClassNotFoundException {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            int counter = 1;
            System.out.println("Server is running...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client No: " + counter + " has connected.");
                ClientThread clientThread = new ClientThread(clientSocket, counter, measurementList);
                clientThread.start();
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
