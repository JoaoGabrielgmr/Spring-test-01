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

import com.projetos.unity1.entities.Category;
import com.projetos.unity1.entities.Order;
import com.projetos.unity1.entities.Person;
import com.projetos.unity1.entities.Product;
import com.projetos.unity1.entities.enums.OrderStatus;
import com.projetos.unity1.repositories.CategoryRepository;
import com.projetos.unity1.repositories.OrderRepository;
import com.projetos.unity1.repositories.PersonRepository;
import com.projetos.unity1.repositories.ProductRepository;

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
      @Autowired
    private CategoryRepository categoryRepository;
      @Autowired
    private ProductRepository productRepository;

  
    @Override
    public void run(String... args) throws Exception {

      Category c1 = new Category(null, "Eletronics");
      Category c2 = new Category(null, "Computers");
      Category c3 = new Category(null, "Books");

      categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

      Person person1 = new Person(null, "Joao Gabriel","aaa@gmail.com", 30, null);
      Person person2 = new Person(null, "Gabriel","bbb@gmail.com", 20, null);

      personRepository.saveAll(Arrays.asList(person1,person2));

      Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.CANCELED, p1);
      Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, p2);
      Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, p1);

      orderRepository.saveAll(Arrays.asList(o1,o2,o3));

      Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
      Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
      Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
      Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
      Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 

      productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

    }


}
