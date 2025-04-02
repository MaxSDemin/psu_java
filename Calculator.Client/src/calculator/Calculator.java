package calculator;

import calculator.Core.UdpClient;

public class Calculator {
    public static void main(String[] args) {
        try {
            String serverHost = "localhost";
            int serverPort = 5000;
            int clientPort = 0; // уникальный порт для этого клиента
            UdpClient client = new UdpClient(serverHost, serverPort, clientPort);
            client.register();
            client.listenForRequests();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
