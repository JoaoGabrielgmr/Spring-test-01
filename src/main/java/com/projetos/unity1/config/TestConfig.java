/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projetos.unity1.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetos.unity1.entities.Person;
import com.projetos.unity1.repositories.PersonRepository;

/**
 *
 * @author jggmr
 */
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

      @Autowired
    private PersonRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Person p1 = new Person(null, "Joao Gabriel","aaa@gmail.com", 30, null);
		Person p2 = new Person(null, "Gabriel","bbb@gmail.com", 20, null);
        
        repository.saveAll(Arrays.asList(p1,p2));
    }


}
