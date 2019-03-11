package com.codecool.greencommitment.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void start(int pontNumber) throws IOException {

        ServerSocket ss = new ServerSocket(pontNumber);
        Socket socket = ss.accept();

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
    }

}
