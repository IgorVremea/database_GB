package model.exceptions;

import java.io.IOException;

public class InvalidNameException extends IOException {
    public InvalidNameException(String msg, Exception e){
        super(msg, e);
    }
}
