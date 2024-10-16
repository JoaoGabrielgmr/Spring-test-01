/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.projetos.unity1.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 *
 * @author jggmr
 */
@EqualsAndHashCode
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_person")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@EqualsAndHashCode.Exclude
	@Column (name="nomecompleto")
	private String name;

	@EqualsAndHashCode.Exclude
	private String email;

	@EqualsAndHashCode.Exclude
	private String phone;

	@EqualsAndHashCode.Exclude
	private String password;


	//fazendo a associacao de chave estrangeira
	@EqualsAndHashCode.Exclude
	@Setter(AccessLevel.NONE)
	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<Order> orders;

}

