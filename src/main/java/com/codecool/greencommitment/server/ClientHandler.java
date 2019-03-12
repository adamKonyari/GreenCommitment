package com.codecool.greencommitment.server;

import com.codecool.greencommitment.common.Measurement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

public class ClientHandler extends Thread{
    private Socket s;
    private ObjectInputStream ois;

    public ClientHandler(Socket s) throws IOException {
        this.s = s;
        this.ois = new ObjectInputStream(s.getInputStream());
    }

    public void run(List<Measurement> measurementList) throws IOException, ClassNotFoundException {
        while(true) {
            measurementList.add((Measurement) ois.readObject());
            System.out.println(measurementList.size() + ".");
        }
    }
}
