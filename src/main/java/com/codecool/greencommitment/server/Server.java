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
    private ServerInputThread serverInputThread = new ServerInputThread(measurementList);

    public Server(int portNumber) {
        this.portNumber = portNumber;
    }

    public void start(int portNumber) throws IOException, ClassNotFoundException {
        try {
            serverInputThread.start();
            ServerSocket serverSocket = new ServerSocket(portNumber);
            int counter = 1;
            System.out.println("Server is running...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client #" + counter + " connected.");
                ClientThread clientThread = new ClientThread(clientSocket, counter, measurementList);
                clientThread.start();
                counter++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
