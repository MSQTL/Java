package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Create server on port: " + serverSocket.getLocalPort()
                    + " and InetAddress: " + serverSocket.getInetAddress());

            Socket user = serverSocket.accept();
            System.out.println("Client connected. Port: " + user.getLocalPort());

            DataInputStream in = new DataInputStream(user.getInputStream());
            DataOutputStream out = new DataOutputStream(user.getOutputStream());

            while (true) {
                String userMessage = in.readUTF();
                if (userMessage.equals("/end")){
                    break;
                }
                System.out.println("Клиент: " + userMessage);
            }

            System.out.println("Server closed");
        }
    }
}
