package com.bridgelabz.employeepayrollapp.exception;

/**
 * Purpose : To demonstrate the message shown through CustomException if it is occurred
 *
 * @author : Ramkrishna Sheral
 * @version : 0.0.1
 * @since : 15-12-2021
 */
public class NoDataFoundException extends  RuntimeException{
    /**
     * Purpose : This method is used to define the message used to throw during exception
     *
     * @param message defines the exception message
     */
    public NoDataFoundException(String message){
        super(message);
    }
}
