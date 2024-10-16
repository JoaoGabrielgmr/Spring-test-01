/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projetos.unity1.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetos.unity1.entities.PK.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jggmr
 */
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter

@Entity
@Table(name = "tb_order_item")
public class OrderItem  implements Serializable{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private OrderItemPK id = new OrderItemPK();

    @EqualsAndHashCode.Exclude
    private Integer quantity;

    @EqualsAndHashCode.Exclude
    private Double price;

    public OrderItem(Order order, Product product, Double price, Integer quantity) {
        id.setOrder(order);
        id.setProduct(product);
        this.price = price;
        this.quantity = quantity;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public void setOrder(Order order){
        id.setOrder(order);
    }

   
    public Product getProduct(){
        return id.getProduct();
    }

    public void setProduct(Product product){
        id.setProduct(product);
    }
    
    public Double getSubTotal(){
        return price * quantity;
    }
}
