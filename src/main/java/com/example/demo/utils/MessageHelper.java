package com.example.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * 获取系统内部统一的消息说明文本
 * 消息代码定义请参见message_{语言}.properties文件
 * @author yfli
 *
 */
@Slf4j
public class MessageHelper {

    /**
     * 缓存信息
     */
    private static Map<String, Properties> cache = new HashMap<String, Properties>();

    /**
     * 通过消息Id统一返回Message信息
     * @param messageId
     * @return
     */
    public static String getMessage(String messageId, String... parameters) {
        String locale = LocaleContextHolder.getLocale().toLanguageTag().toLowerCase();
        Properties properties = cache.get(locale);
        //缓存为空，从文件中读取
        if(properties == null) {
            properties = new Properties();
            PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();
            InputStream inputStream = null;
            URL url = null;
            try {
                inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("message_" + locale + ".properties");
                propertiesPersister.load(properties, new InputStreamReader(inputStream, "utf-8"));
                cache.put(locale, properties);
            }catch(IOException ex) {
                if(log.isErrorEnabled()) {
                    log.error("读取国际化message出错。", ex);
                }
            }finally {
                try {
                    if(inputStream != null) inputStream.close();
                }catch(IOException ex) {
                    if(log.isErrorEnabled()) {
                        log.error("读取国际化message出错。", ex);
                    }
                }
            }
        }

        String message = properties.getProperty(messageId);
        if (parameters != null && message != null) {
            for (int i = 0; i < parameters.length; i++) {
                if(parameters[i] ==  null) parameters[i] = "";
                message = message.replaceAll("\\$\\{" + i + "\\}", parameters[i]);
            }
        }

        return message;
    }

    /**
     * 清空缓存
     */
    public static void clear() {
        cache = new HashMap<String, Properties>();
    }


    public static void main(String[] args) {
        System.out.println("www,wwww".split(",").length);
        System.out.println(System.getProperty("user.dir"));
    }
}
