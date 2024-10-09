/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

package com.projetos.unity1.entities.enums;

import lombok.Getter;

/**
 *
 * @author jggmr
 */
public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    @Getter
    private int code;

    private OrderStatus(int code){
        this.code = code;
    }

    public static OrderStatus valueOf(int code){
        for(OrderStatus value: OrderStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus Code");
    }
}
