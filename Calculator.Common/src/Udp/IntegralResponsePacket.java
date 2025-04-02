package Udp;

import java.io.Serializable;

public class IntegralResponsePacket implements Serializable {
    private static final long serialVersionUID = 1L;
    private final double partialResult;
    
    public IntegralResponsePacket(double partialResult) {
        this.partialResult = partialResult;
    }
    
    public double getPartialResult() {
        return partialResult;
    }
}
