package com.codecool.greencommitment.server;

import com.codecool.greencommitment.common.Measurement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private int clientNo;
    private List<Measurement> measurementList;

    ClientThread(Socket inSocket, int counter, List<Measurement> measurementList) {
        this.measurementList = measurementList;
        this.clientSocket = inSocket;
        this.clientNo = counter;
    }

    public void run() {
        try (
                ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream())
        ) {

            while (true) {
                Object input = objectInputStream.readObject();
                measurementList.add((Measurement) input);
                System.out.println("Sensor #" + clientNo + " temperature: " + ((Measurement) input).getValue() + " °C");
            }

        } catch (Exception e) {
        } finally {
            System.out.println("Client #" + clientNo + ". disconnected!");
        }
    }
}

