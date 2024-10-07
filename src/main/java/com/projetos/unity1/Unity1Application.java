package com.projetos.unity1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SpringBootApplication
public class Unity1Application {

	public static void main(String[] args) {
		SpringApplication.run(Unity1Application.class, args);

		
		Person p1 = new Person(null, "Joao Gabriel","aaa@gmail.com", 30);
		Person p2 = new Person(null, "Gabriel","bbb@gmail.com", 20);
		Person p3 = new Person(null, "Joao","ccc@gmail.com", 15);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("pronto");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
	}

}
