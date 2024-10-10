/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.projetos.unity1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.unity1.entities.Product;

/**
 *
 * @author jggmr
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
}
