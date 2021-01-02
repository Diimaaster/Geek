package lvl2.hw6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    private static final int SERVER_PORT = 8189;

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Ожидание подключения...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Соединение установлено!");

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            Scanner inn = new Scanner(System.in);

            while (true) {
                String message = in.readUTF();
                String msg = inn.nextLine();
                System.out.println("Сообщение пользователя: " + message);
                System.out.println("Сообщение c консоли: " + msg);
                if ((message.equals("/exit"))||(msg.equals("/exit"))) {
                    break;
                }

                out.writeUTF(message.toUpperCase());
                out.writeUTF(msg.toUpperCase());
            }

            System.out.println("Сервер остановлен");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Порт уже занят");
        }


    }
}
