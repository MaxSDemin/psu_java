package Udp;

import java.io.Serializable;

public class IntegralRequestPacket implements Serializable {
    private static final long serialVersionUID = 1L;
    private final double _start;
    private final double _end;
    private final double _stepWidth;
    
    public IntegralRequestPacket(double start, double end, double stepWidth) {
        _start = start;
        _end = end;
        _stepWidth = stepWidth;
    }
    
    public double getStart() { return _start; }
    public double getEnd() { return _end; }
    public double getStepWidth() { return _stepWidth; }
}

