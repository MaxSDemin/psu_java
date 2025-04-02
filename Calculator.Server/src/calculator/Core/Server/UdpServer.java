package calculator.Core.Server;

import Udp.IntegralRequestPacket;
import Udp.IntegralResponsePacket;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class UdpServer {
    private final DatagramSocket _socket;
    private final List<SocketAddress> _clientList = new ArrayList<>();
    private final CalculationResultAggregator _aggregator;

    public UdpServer(int port, CalculationResultAggregator aggregator) throws SocketException {
        _socket = new DatagramSocket(port);
        _aggregator = aggregator;
    }
    
    // Запускаем прослушивание входящих UDP-сообщений
    public void listen() {
        new Thread(() -> {
            byte[] buf = new byte[1024];
            while (true) {
                try {
                    DatagramPacket packet = new DatagramPacket(buf, buf.length);
                    _socket.receive(packet);
                    String msg = new String(packet.getData(), 0, packet.getLength());
                    
                    // Если сообщение – регистрация, добавляем клиента
                    if ("REGISTER".equalsIgnoreCase(msg.trim())) {
                        if (!_clientList.contains(packet.getSocketAddress())) {
                            _clientList.add(packet.getSocketAddress());
                            System.out.println("The client is registered: " + packet.getSocketAddress());
                        }
                    } else {
                        // Иначе десериализуем ответ с частичным результатом
                        ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData(), 0, packet.getLength());
                        ObjectInputStream ois = new ObjectInputStream(bais);
                        IntegralResponsePacket response = (IntegralResponsePacket) ois.readObject();
                        System.out.println("Received a response from " + packet.getSocketAddress() +
                                " - Partial result: " + response.getPartialResult());
                        _aggregator.addPartialResult(response.getPartialResult());
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    // Отправка запроса конкретному клиенту
    public void sendRequest(SocketAddress clientAddress, IntegralRequestPacket request) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(request);
            oos.flush();
            byte[] data = baos.toByteArray();
            DatagramPacket packet = new DatagramPacket(data, data.length, clientAddress);
            _socket.send(packet);
            System.out.println("A request has been sent to the client " + clientAddress + ": [" 
                    + request.getStart() + ", " + request.getEnd() + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Разделение общего интервала на части и отправка запросов всем клиентам
    public void distributeIntegralCalculation(double bottomBorder, double topBorder, double stepWidth) {
        int clientCount = _clientList.size();
        if (clientCount == 0) {
            System.out.println("There are no registered clients for calculations!");
            return;
        }
        
        _aggregator.reset(clientCount);
        double totalInterval = topBorder - bottomBorder;
        double subIntervalLength = totalInterval / clientCount;
        for (int i = 0; i < clientCount; i++) {
            double subStart = bottomBorder + i * subIntervalLength;
            double subEnd = (i == clientCount - 1) ? topBorder : subStart + subIntervalLength;
            IntegralRequestPacket request = new IntegralRequestPacket(subStart, subEnd, stepWidth);
            sendRequest(_clientList.get(i), request);
        }
    }
    
    public List<SocketAddress> getClientList() {
        return _clientList;
    }
    
    public void close() {
        if (_socket != null && !_socket.isClosed()) {
            _socket.close();
        }
    }
}
