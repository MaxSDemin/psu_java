package calculator.Core.Server;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CalculationResultAggregator {
    private double _totalResult;
    private int _expectedResponses;
    private int _receivedResponses;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    
    public synchronized void reset(int expectedResponses) {
        _totalResult = 0.0;
        _receivedResponses = 0;
        _expectedResponses = expectedResponses;
    }
    
    public synchronized void addPartialResult(double partial) {
        double oldResult = _totalResult;
        _totalResult += partial;
        _receivedResponses++;
        pcs.firePropertyChange("partialResult", oldResult, _totalResult);
        if (_receivedResponses == _expectedResponses) {
            // Все ответы получены – уведомляем об окончательном результате
            pcs.firePropertyChange("finalResult", null, _totalResult);
        }
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
}
