package org.fiuba.exceptions;

public class OccupiedFieldException extends RuntimeException {
    public OccupiedFieldException(String message) {
        super(message);
    }
}
