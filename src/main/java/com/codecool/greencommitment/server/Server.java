package com.codecool.greencommitment.server;

import com.codecool.greencommitment.common.Measurement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Server {
    private ServerSocket serverSocket;
    private List<Measurement> measurements = new ArrayList<>();

    public Server(int portNumber) {
        try {
            this.serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(int portNumber) throws IOException, ClassNotFoundException {
        while(true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                // ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                // System.out.println(ois.readObject());
                Thread thread = new ClientHandler(socket);
                ((ClientHandler) thread).run(measurements);
                // System.out.println(measurements.size() + ".");
            }
            catch (Exception e){
                e.getStackTrace();
            }
        }
    }
}
