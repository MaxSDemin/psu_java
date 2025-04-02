package calculator;

import calculator.Core.Server.CalculationResultAggregator;
import calculator.Core.Server.UdpServer;
import calculator.UI.MainFrame;
import java.net.SocketException;
import javax.swing.SwingUtilities;

public class Calculator {
    public static void main(String[] args) {
        try {
            CalculationResultAggregator aggregator = new CalculationResultAggregator();
            UdpServer udpServer = new UdpServer(5000, aggregator);
            udpServer.listen();
            System.out.println("The UDP server is running on port 5000...");
            
            SwingUtilities.invokeLater(() -> {
                MainFrame frame = new MainFrame(udpServer, aggregator);
                frame.setVisible(true);
            });
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
