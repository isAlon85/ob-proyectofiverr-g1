package com.g1fiverr.obproyectofiverrg1;

import com.g1fiverr.obproyectofiverrg1.entities.Card;
import com.g1fiverr.obproyectofiverrg1.services.CardServiceImpl;
import com.g1fiverr.obproyectofiverrg1.services.PictureServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObProyectofiverrG1Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObProyectofiverrG1Application.class, args);
		CardServiceImpl service1 = context.getBean(CardServiceImpl.class);
		PictureServiceImpl service2 = context.getBean(PictureServiceImpl.class);

		Card card1 = new Card(null, "Título 1", "Carta de prueba", "Indio1", "Diseño",5D, 13D);
		Card card2= new Card(null, "Título 2", "Esto es un testeo", "Indio2", "Picateclas",3.5D, 9.99D);
		service1.create(card1);
		service1.create(card2);

	}

}
