package com.bankapp.exception;

/**
 * MapStruct: exception for mapping actions.
 *
 * @author Iurii Ivanov
 */

public class MapperException extends RuntimeException{

    public MapperException() {
        super();
    }

    /**
     * This constructor need for MapStruct.
     *
     * @param message about mapping problem
     */
    public MapperException(String message) {
        super(message);
    }
}
