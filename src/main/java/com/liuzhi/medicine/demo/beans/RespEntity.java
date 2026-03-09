package com.liuzhi.medicine.demo.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * @author solve
 */
@Data
public class RespEntity<T> implements Serializable {

    public boolean status = true;
    public int code = 200;
    public String message = "SUCCESS";
    public T data;

    public static <T> RespEntity<T> success(T data) {
        RespEntity<T> resp = new RespEntity<T>();
        resp.data = data;
        return resp;
    }

    public static <T> RespEntity<T> success(int code, String msg, Boolean status, T data) {
        RespEntity<T> resp = new RespEntity<T>();
        resp.status = status;
        resp.code = code;
        resp.message = msg;
        resp.data = data;
        return resp;
    }

    public static <T> RespEntity<T> error(String errMsg) {
        RespEntity<T> resp = new RespEntity<T>();
        resp.status = false;
        resp.code = 500;
        resp.message = errMsg;
        return resp;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "code='" + code + '\'' +
                ", msg='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
