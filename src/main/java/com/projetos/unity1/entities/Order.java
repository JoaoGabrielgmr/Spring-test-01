/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projetos.unity1.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetos.unity1.entities.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jggmr
 */
@EqualsAndHashCode
@NoArgsConstructor

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Exclude
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-mm-dd'T'HH:mm:ss'Z'", timezone="GMT")
    private Instant moment;

    @EqualsAndHashCode.Exclude
    private Integer orderStatus;

    //criando chave estrangeira e dando nome
    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "clientId")
    @ManyToOne
    private Person client;


    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();


    @EqualsAndHashCode.Exclude
    @Getter
    @Setter
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

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
    
    public Set<OrderItem> getItems(){
        return items;
    }

}
