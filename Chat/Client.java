package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket("localhost", 8080)) {

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread thread = new Thread(() -> {
                while (true) try {
                    out.writeUTF((new Scanner(System.in).nextLine()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.setDaemon(true);
            thread.start();

            while (true){
                try {
                    in.read();
                }
                catch (Exception ex){
                    System.out.println("Server closed");
                    break;
                }
            }

        }
    }
}
