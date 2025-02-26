package calculator;

/**
 *
 * @author admin
 */
public class RecIntegral {
    private double _topBorder = 0.0;
    private double _bottomBorder = 0.0;
    private double _stepWidth = 0.0;
    private double _result = 0.0;
    
    public RecIntegral(double topBorder, double bottomBorder, double stepWidth) {
        _topBorder = topBorder;
        _bottomBorder = bottomBorder;
        _stepWidth = stepWidth;
        _result = Double.NaN;
    }
    
    public double getTopBorder() { return _topBorder; }
    public double getBottomBorder() { return _bottomBorder; }
    public double getStepWidth() { return _stepWidth; }
    public double getResult() { return _result; }
    
    public void calculateIntegral() {
        // Ensure that the step width is positive
        if (_stepWidth <= 0) {
            throw new IllegalArgumentException("Step width must be positive");
        }

        double sign = 1.0;
        // If the top border is less than the bottom border, swap them and invert the sign of the result
        if (_topBorder < _bottomBorder) {
            double temp = _topBorder;
            _topBorder = _bottomBorder;
            _bottomBorder = temp;
            sign = -1.0;
        }

        double sum = 0.0;
        // Integrate using the trapezoidal rule
        for (double x = _bottomBorder; x < _topBorder; x += _stepWidth) {
            double nextX = Math.min(x + _stepWidth, _topBorder);
            // Calculate the area of the trapezoid between x and nextX
            double area = (nextX - x) * (Math.exp(-x) + Math.exp(-nextX)) / 2.0;
            sum += area;
        }
        _result =  sign * sum;
    }
}
