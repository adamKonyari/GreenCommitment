package com.codecool.greencommitment.server;

import com.codecool.greencommitment.common.Measurement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {

    private List<Measurement> measurements = new ArrayList<>();

    public void start(int portNumber) throws IOException, ClassNotFoundException {

        ServerSocket ss = new ServerSocket(portNumber);
        Socket socket = null;

        while (true) {
            socket =  ss.accept();
            System.out.println("Object received");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            measurements.add((Measurement) ois.readObject());
        }
    }

}
