package com.codecool.greencommitment.server;

import com.codecool.greencommitment.common.Measurement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

public class ClientThread extends Thread{
    private Socket clientSocket;
    private int clientNo;
    private List<Measurement> measurementList;

    ClientThread(Socket inSocket, int counter, List<Measurement> measurementList) {
        this.measurementList = measurementList;
        this.clientSocket = inSocket;
        this.clientNo = counter;
    }

    public void run() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            String clientMessage = "";
            while(!clientMessage.equals("x")) {
                if(objectInputStream.readObject() instanceof Measurement) {
                    measurementList.add((Measurement) objectInputStream.readObject());
                } else if(objectInputStream.readObject() instanceof String) {
                    clientMessage = (String) objectInputStream.readObject();
                }
                System.out.println("Server has received data from Client #" + clientNo);
            }
            objectInputStream.close();
        } catch(Exception e) {
        } finally {
            System.out.println("Client #" + clientNo + ". disconnected!");
        }
    }
}
