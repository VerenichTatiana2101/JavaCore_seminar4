package exceptions;

public class WrongLoginException extends Exception{
    String msg;
    int currentLength;

    public WrongLoginException(String msg) {
        super(msg);
    }

    // public WrongLoginException(int currentLength) {
    //     super();
    //     this.currentLength = currentLength;
    //     }

    // @Override
    // public String getMessage() {
    //     return String.format("Your login is of incorrect length, expected < 20, given %d.", currentLength);
    // }
    
}
