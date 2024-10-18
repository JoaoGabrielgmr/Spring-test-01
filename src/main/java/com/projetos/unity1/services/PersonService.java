/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projetos.unity1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.projetos.unity1.entities.Person;
import com.projetos.unity1.repositories.PersonRepository;
import com.projetos.unity1.services.exceptions.ResourceNotFoundException;

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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Person insert(Person obj){
        return personRepository.save(obj);
    }

    public void delete(Long id){
        personRepository.deleteById(id);
    }

    public Person update(Long id, Person obj){
        Person entity = personRepository.getReferenceById(id);
        updateData(entity, obj);
        return personRepository.save(entity);
    }
    
    private void updateData(Person entity, Person obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
    
}    
