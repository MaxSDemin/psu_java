package calculator;

public class IntegralValueException extends Exception {
    public IntegralValueException(double lowerBound, double upperBound){
        String message = String.format(
                "Value exception: lower bound - %f, upper bound - %f",
                lowerBound, upperBound);
        super(message);
    }
    
    public String getExceptionName(){
        return "IntegralValueException";
    }
}


