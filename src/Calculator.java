/**
 * Created by Kit on 10/4/2014.
 */
public class Calculator {

    private int result = 0;
    private int counter = 0;
    private Operation operation;

    public int calculate(int number, Operation operation) {
        if (operation != Operation.EQUAL) {
            this.operation = operation;
        }

        switch (this.operation) {
            case PLUS:
                result += number;
                break;
            case MINUS:
                if(counter == 0){
                    result = number - result;
                    counter++;
                }
                else {
                    result -= number;
                }
                break;
        }

        return result;
    }

}
