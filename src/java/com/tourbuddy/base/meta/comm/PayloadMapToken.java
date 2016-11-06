/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tourbuddy.base.meta.comm;

import java.util.Map;

/**
 *
 * @author Nethumini
 */
public class PayloadMapToken implements Token {

    private int code;
    private String message;
    private Map<Object, Object> payload;

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

    public Map<? extends Object, ? extends Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<? extends Object, ? extends Object> payload) {
        this.payload = (Map<Object,Object>)payload;
    }

}
