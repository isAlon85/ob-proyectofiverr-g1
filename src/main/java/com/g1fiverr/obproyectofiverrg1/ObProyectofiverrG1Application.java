package com.g1fiverr.obproyectofiverrg1;

import com.g1fiverr.obproyectofiverrg1.entities.Card;
import com.g1fiverr.obproyectofiverrg1.entities.Picture;
import com.g1fiverr.obproyectofiverrg1.repositories.CardRepository;
import com.g1fiverr.obproyectofiverrg1.repositories.PictureRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.net.URI;

@SpringBootApplication
public class ObProyectofiverrG1Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObProyectofiverrG1Application.class, args);
		CardRepository cardRepository = context.getBean(CardRepository.class);
		PictureRepository pictureRepository = context.getBean(PictureRepository.class);

		System.out.println("Card's number in DB: " + cardRepository.findAll().size());
		System.out.println("Picture's number in DB: " + pictureRepository.findAll().size());

		Card card1 = new Card(null, "Título 1", "Carta de prueba", "Indio1", 2,5, 13D);
		Card card2= new Card(null, "Título 2", "Esto es un testeo", "Indio2", 3,3, 9.99D);
		cardRepository.save(card1);
		cardRepository.save(card2);

		Picture picture1 = new Picture(null, URI.create("https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-reponsive-design.jpg"));
		Picture picture2 = new Picture(null, URI.create("https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-reponsive-desig.jpg"));
		Picture picture3 = new Picture(null, URI.create("https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-reponsive-desi.jpg"));
		pictureRepository.save(picture1);
		pictureRepository.save(picture2);
		pictureRepository.save(picture3);

		card1.addPicture(picture1);
//		card1.addPicture(picture2);
//		card2.addPicture(picture3);
//		picture1.setCard(card1);

		System.out.println(picture1.getCard());


		System.out.println("Card's number in DB: " + cardRepository.findAll().size());
		System.out.println("Picture's number in DB: " + pictureRepository.findAll().size());

		card1.addPicture(picture1);
		System.out.println("Card 1: " + card1.toString());
		System.out.println("Card's ID from Picture's ID " + picture1.getId() + ": " + picture1.getCard().getId());
	}

}
