package calculator.Core.Integral;

public class IntegralThread extends Thread {
    private final double start;
    private final double end;
    private final double stepWidth;
    private double partialResult = 0.0;

    public IntegralThread(double start, double end, double stepWidth) {
        this.start = start;
        this.end = end;
        this.stepWidth = stepWidth;
    }

    public double getPartialResult() {
        return partialResult;
    }

    @Override
    public void run() {
        for (double x = start; x < end; x += stepWidth) {
            double nextX = Math.min(x + stepWidth, end);
            double area = (nextX - x) * (Math.exp(-x) + Math.exp(-nextX)) / 2.0;
            partialResult += area;
        }
    }
}
