/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projetos.unity1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.projetos.unity1.entities.Person;
import com.projetos.unity1.repositories.PersonRepository;

/**
 *
 * @author jggmr
 */

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        Optional<Person> obj = personRepository.findById(id);
        return obj.get();
    }
}
