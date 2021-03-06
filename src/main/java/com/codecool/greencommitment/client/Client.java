package com.codecool.greencommitment.client;

import com.codecool.greencommitment.common.Measurement;
import com.codecool.greencommitment.common.Ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class Client {

    Ui ui = new Ui();
    private static int counter = 0;
    private int id;
    private Scanner scanner = new Scanner(System.in);

    public Client() {
        counter++;
        id = counter;
    }

    public void start(String hostName, int portNumber, int sleepTime) throws UnknownHostException, IOException, InterruptedException {

        try (Socket socket = new Socket(hostName, portNumber);
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())
        ) {
            while (true) {
                Measurement randomMeasuremenet = generateRandomMeasurement();
                oos.writeObject(randomMeasuremenet);
                System.out.println("Sensor temperature sent: " + randomMeasuremenet.getValue() + " °C");
                Thread.sleep(sleepTime * 1000);
            }
        } catch (Exception e) {
            System.out.println("Client has disconnected from the server.");
        }
    }

    public Measurement generateRandomMeasurement() {

        Random rand = new Random();
        long time = System.currentTimeMillis();
        Measurement mm = new Measurement(id, rand.nextInt(35) + 5, "Celsius", time);
        return mm;
    }


}

