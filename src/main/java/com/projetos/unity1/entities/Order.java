/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projetos.unity1.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetos.unity1.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jggmr
 */
@Data
@NoArgsConstructor

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-mm-dd'T'HH:mm:ss'Z'", timezone="GMT")
    private Instant moment;

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private Integer orderStatus;

    //criando chave estrangeira e dando nome
    @JoinColumn(name = "clientId")
    @ManyToOne
    private Person client;

    public Order(Long id, Instant moment, OrderStatus orderStatus, Person client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null){
            this.orderStatus = orderStatus.getCode();
        }
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }
    
}
