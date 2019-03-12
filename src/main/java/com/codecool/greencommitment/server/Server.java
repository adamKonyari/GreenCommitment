package com.codecool.greencommitment.server;

import com.codecool.greencommitment.common.Measurement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
    private ServerSocket ss;
    private List<Measurement> measurements = new ArrayList<>();

    public Server(int portNumber) {
        try {
            this.ss = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(int portNumber) throws IOException, ClassNotFoundException {
        while(true){
            Socket socket = null;

            try {
                socket = ss.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                measurements.add((Measurement) ois.readObject());
                // System.out.println(ois.readObject());
                System.out.println(measurements.size());
                Thread thread = new ClientHandler(socket);
                thread.start();
            }
            catch (Exception e){
                e.getStackTrace();
            }
        }
    }
}
