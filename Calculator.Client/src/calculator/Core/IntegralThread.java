package calculator.Core;

public class IntegralThread extends Thread {
    private final double _start;
    private final double _end;
    private final double _stepWidth;
    private double _partialResult = 0.0;

    public IntegralThread(double start, double end, double stepWidth) {
        _start = start;
        _end = end;
        _stepWidth = stepWidth;
    }

    public double getPartialResult() {
        return _partialResult;
    }

    @Override
    public void run() {
        System.out.println("Start calculate: [" + 
                            _start + ", " + 
                            _end + ", " + 
                            _stepWidth + "]...");
        for (double x = _start; x < _end; x += _stepWidth) {
            double nextX = Math.min(x + _stepWidth, _end);
            double area = (nextX - x) * (Math.exp(-x) + Math.exp(-nextX)) / 2.0;
            _partialResult += area;
        }
        System.out.println("End calculate: [" + 
                            _start + ", " + 
                            _end + ", " + 
                            _stepWidth + "]");
    }
}