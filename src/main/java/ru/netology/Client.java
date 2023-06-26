package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 7777;

    public static void main(String[] args) {

        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));)
        {
            String answer = in.readLine();
            System.out.println(answer);
            String name = "Студент";
            out.println(name);

            answer = in.readLine();
            System.out.println(answer);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
