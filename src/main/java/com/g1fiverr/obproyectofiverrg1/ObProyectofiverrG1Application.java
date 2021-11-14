package com.g1fiverr.obproyectofiverrg1;

import com.g1fiverr.obproyectofiverrg1.entities.Card;
import com.g1fiverr.obproyectofiverrg1.entities.User;
import com.g1fiverr.obproyectofiverrg1.services.CardService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObProyectofiverrG1Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObProyectofiverrG1Application.class, args);
		CardService service = context.getBean(CardService.class);

		User user1 = new User(null, "Usuario 1", "passwordDificil1234", "user1@gmail.com");
		User user2 = new User(null, "Usuario 2", "passwordDificil1234", "user2@gmail.com");

		Card card1 = new Card(null, "Título 1", "Carta de prueba", "Indio 1", "Diseño",5D, 13D, user1);
		Card card2= new Card(null, "Título 2", "Esto es un testeo", "Indio 2", "Picateclas",3.5D, 9.99, user2);
		service.create(card1);
		service.create(card2);

	}

}
