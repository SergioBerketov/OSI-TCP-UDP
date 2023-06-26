package ru.netology;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static final int PORT = 7777;

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(PORT);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));)
        {
            out.println("Сервер подключен!");
            System.out.println("Connected.");

            String name = in.readLine();
            out.println(String.format("Привет, %s! Твой port: %d", name, clientSocket.getPort()));
            System.out.println("Сеанс подключения завершён.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
