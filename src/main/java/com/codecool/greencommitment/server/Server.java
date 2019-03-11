package com.codecool.greencommitment.server;

import com.codecool.greencommitment.common.Measurement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;


public class Server {

    private List<Measurement> measurements;

    public void start(int pontNumber) throws IOException, ClassNotFoundException {

        ServerSocket ss = new ServerSocket(pontNumber);

        while (true) {
            Socket socket = ss.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            measurements.add((Measurement) ois.readObject());
            System.out.println(measurements.size());
        }
    }

}
