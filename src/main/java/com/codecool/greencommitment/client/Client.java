package com.codecool.greencommitment.client;

import com.codecool.greencommitment.common.Measurement;
import com.codecool.greencommitment.common.Ui;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class Client {

    Ui ui = new Ui();

    public void start(String hostName, int portNumber) throws UnknownHostException, IOException {

        Socket socket = new Socket(hostName, portNumber);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        oos.writeObject(generateRandomMeasurement());


    }

    public Measurement generateRandomMeasurement() {

        Random rand = new Random();
        long time = System.currentTimeMillis();

        Measurement mm = new Measurement(Integer.parseInt(ui.getUserInput()), rand.nextInt(15) + 25, "Celsius", time);

        return mm;
    }
}
