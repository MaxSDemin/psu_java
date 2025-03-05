package calculator;

public class RecIntegral {
    final double MINIMAL_DOUBLE_VALUE = 0.000001;
    final double MAXIMUM_DOUBLE_VALUE = 1000000;
    
    private double _topBorder = 0.0;
    private double _bottomBorder = 0.0;
    private double _stepWidth = 0.0;
    private double _result = 0.0;
    
    public RecIntegral(double topBorder, double bottomBorder, double stepWidth) throws IntegralValueException {
        _topBorder = topBorder;
        _bottomBorder = bottomBorder;
        // Check of values in range
        if (bottomBorder < MINIMAL_DOUBLE_VALUE || bottomBorder > MAXIMUM_DOUBLE_VALUE ||
                topBorder < MINIMAL_DOUBLE_VALUE || topBorder > MAXIMUM_DOUBLE_VALUE ||
                stepWidth < MINIMAL_DOUBLE_VALUE || stepWidth > MAXIMUM_DOUBLE_VALUE) {
            throw new IntegralValueException(
                    MINIMAL_DOUBLE_VALUE, MAXIMUM_DOUBLE_VALUE);
        }
        _stepWidth = stepWidth;
        _result = Double.NaN;
    }
    
    public double getTopBorder() { return _topBorder; }
    public double getBottomBorder() { return _bottomBorder; }
    public double getStepWidth() { return _stepWidth; }
    public double getResult() { return _result; }
    
    public void calculateIntegral() throws StepException {
        double sign = 1.0;
        // If the top border is less than the bottom border, swap them and invert the sign of the result
        if (_topBorder < _bottomBorder) {
            double temp = _topBorder;
            _topBorder = _bottomBorder;
            _bottomBorder = temp;
            sign = -1.0;
        }
        
        if (_stepWidth > _topBorder - _bottomBorder) {
            throw new StepException(_stepWidth, _bottomBorder, _topBorder);
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
