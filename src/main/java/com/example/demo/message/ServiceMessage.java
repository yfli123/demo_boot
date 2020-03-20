package com.example.demo.message;


import com.example.demo.exceptaion.MyException;
import com.example.demo.utils.MessageHelper;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class ServiceMessage<T> {
    private static String  EXCEPTION_0 = "0";
    private static String  EXCEPTION_1 = "1";

    private String message;
    private String code;
    private String isException;
    private T body;



    public static ServiceMessage success(Object object,String code){
        ServiceMessage message = new ServiceMessage();
        message.setBody(object);
        message.setIsException(EXCEPTION_0);
        if(StringUtils.isEmpty(code)){
            message.setMessage(MessageHelper.getMessage("sys0000"));
            message.setCode("sys0000");
        } else {
            message.setMessage(MessageHelper.getMessage(code));
            message.setCode(code);
        }
        return message;
    }

    public static ServiceMessage fail(Object o,String defaultCode,Exception error,String ...params){
        ServiceMessage message = new ServiceMessage();
        message.setBody(o);
        message.setIsException(EXCEPTION_1);
        if(error instanceof MyException){
            String code = ((MyException) error).getCode();
            message.setCode(code);
            message.setMessage(MessageHelper.getMessage(code,error.toString()));
        } else if(!StringUtils.isEmpty(defaultCode)){
            message.setCode(defaultCode);
            message.setMessage(MessageHelper.getMessage(defaultCode,params));
        } else {
            message.setCode("sys9999");
            message.setMessage(MessageHelper.getMessage("sys9999",error.toString()));
        }
        return message;
    }
}
