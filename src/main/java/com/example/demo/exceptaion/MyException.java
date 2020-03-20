package com.example.demo.exceptaion;

import com.example.demo.utils.MessageHelper;

public class MyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 异常信息编号
     */
    private final String code;
    /**
     * 本Class实现所有程序定义的异常采用系统内标准消息代码的定义方式进行处理，其目的主要是方便后续问题查找和解决以及国际化。
     * @param code
     * @param parameters
     */
    public MyException(String code, String... parameters){
        super(MessageHelper.getMessage(code, parameters));
        this.code = code;
    }

    /**
     * 本Class实现所有程序定义的异常采用系统内标准消息代码的定义方式进行处理，其目的主要是方便后续问题查找和解决以及国际化。
     * @param code
     * @param cause
     * @param parameters
     */
    public MyException(String code, Throwable cause, String... parameters){
        super(MessageHelper.getMessage(code, parameters), cause);
        this.code = code;
    }

    /**
     * 只有子类才能调用该方法，主要用于接口中传递异常信息使用
     * @param code
     * @param message
     */
    protected MyException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
