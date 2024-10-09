/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projetos.unity1.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetos.unity1.entities.Order;
import com.projetos.unity1.entities.Person;
import com.projetos.unity1.entities.enums.OrderStatus;
import com.projetos.unity1.repositories.OrderRepository;
import com.projetos.unity1.repositories.PersonRepository;

/**
 *
 * @author jggmr
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

      @Autowired
    private PersonRepository personRepository;
      @Autowired
    private OrderRepository orderRepository;

   

    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person(null, "Joao Gabriel","aaa@gmail.com", 30, null);
		Person p2 = new Person(null, "Gabriel","bbb@gmail.com", 20, null);
        personRepository.saveAll(Arrays.asList(p1,p2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.CANCELED, p1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, p2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, p1);

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }


}
