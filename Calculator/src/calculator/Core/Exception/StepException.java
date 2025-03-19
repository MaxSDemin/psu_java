package calculator.Core.Exception;

public class StepException extends Exception {
    public StepException(double step, double lowerBound, double upperBound){
        String message = String.format(
                "Step exception (Step is bigger than borders): step - %f, lower bound - %f, upper bound - %f",
                step, lowerBound, upperBound);
        super(message);
    }
    
    public String getExceptionName(){
        return "StepException";
    }
}