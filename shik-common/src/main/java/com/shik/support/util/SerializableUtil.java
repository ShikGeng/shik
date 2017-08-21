/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 */
package com.shik.support.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author gengshikun
 * @date 2017/1/9
 */
public class SerializableUtil {

    private static Logger logger = LoggerFactory.getLogger(SerializableUtil.class);

    public static Object deserialize(byte[] bytes) {
        Object result = null;

        if (isEmpty(bytes)) {
            return null;
        }
        try {
            ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteStream);
                try {
                    result = objectInputStream.readObject();
                } catch (ClassNotFoundException ex) {
                    throw new Exception("Failed to deserialize object type", ex);
                }
            } catch (Throwable ex) {
                throw new Exception("Failed to deserialize", ex);
            }
        } catch (Exception e) {
            logger.error("Failed to deserialize", e);
        }
        return result;
    }

    public static boolean isEmpty(byte[] data) {
        return (data == null) || (data.length == 0);
    }

    public static byte[] serialize(Object object) {
        byte[] result = null;

        if (object == null)
            return new byte[0];
        try {
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            try {
                if (!(object instanceof Serializable)) {
                    throw new IllegalArgumentException(SerializableUtil.class.getSimpleName() + " requires a Serializable payload " + "but received an object of type [" + object.getClass().getName() + "]");
                }

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteStream);
                objectOutputStream.writeObject(object);
                objectOutputStream.flush();
                result = byteStream.toByteArray();
            } catch (Throwable ex) {
                throw new Exception("Failed to serialize", ex);
            }
        } catch (Exception ex) {
            logger.error("Failed to serialize", ex);
        }
        return result;
    }
}
