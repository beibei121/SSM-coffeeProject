package org.ccunix.coffee.exception;
/**
 * 自定义系统异常
 */
public class SystemException extends Exception{
    private String message;
    public SystemException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
