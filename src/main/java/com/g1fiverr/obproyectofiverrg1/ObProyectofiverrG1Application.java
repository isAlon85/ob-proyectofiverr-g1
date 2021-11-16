package com.g1fiverr.obproyectofiverrg1;

import com.g1fiverr.obproyectofiverrg1.entities.Card;
import com.g1fiverr.obproyectofiverrg1.entities.Picture;
import com.g1fiverr.obproyectofiverrg1.repositories.CardRepository;
import com.g1fiverr.obproyectofiverrg1.repositories.PictureRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Arrays;

@SpringBootApplication
public class ObProyectofiverrG1Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObProyectofiverrG1Application.class, args);
		CardRepository cardRepository = context.getBean(CardRepository.class);
		PictureRepository pictureRepository = context.getBean(PictureRepository.class);

		System.out.println("Card's number in DB when repository initialized: " + cardRepository.findAll().size());
		System.out.println("Picture's number in DB when repository initialized:: " + pictureRepository.findAll().size());

		Card card1 = new Card(null, "Título 1", "Carta de prueba", "Indio1", 1,5, 12.99D);
		Card card2= new Card(null, "Título 2", "Esto es un testeo", "Indio2", 1,3, 9.99D);
		Card card3 = new Card(null, "Título 3", "Probando 1 2 3", "Indio3", 1,5, 19.99D);
		Card card4= new Card(null, "Título 4", "Ahora probamos una descripción con muchos caracteres", "Indio4", 2,1, 9.99D);
		Card card5 = new Card(null, "Título 5", "!!!", "Indio5", 2,5, 14.99D);
		Card card6= new Card(null, "Título 6", "Seguimos testeando", "Indio6", 3,2, 9.99D);
		Card card7= new Card(null, "Título 7", "Card sin imagenes asociadas", "Indio7", 4,1, 7.99D);

		Picture picture1 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-reponsive-design.jpg");
		Picture picture2 = new Picture(null, "https://fiverr-res.cloudinary.com/t_gig_cards_web,q_auto,f_auto/gigs2/157750073/original/2ebbcdec8dfa206d22464f93e50d5429f5631523.png");
		Picture picture3 = new Picture(null, "https://fiverr-res.cloudinary.com/t_gig_cards_web,q_auto,f_auto/gigs3/157750073/original/7fad27143dca2503db2efcc620d299ae2f76d0cd.png");
		Picture picture4 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-reponsive-des.jpg");
		Picture picture5 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-reponsive-d.jpg");
		Picture picture6 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-reponsive-.jpg");
		Picture picture7 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-reponsive.jpg");
		Picture picture8 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-reponsiv.jpg");
		Picture picture9 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-reponsiv.jpg");
		Picture pictureA = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-reponsi.jpg");
		Picture pictureB = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-repons.jpg");
		Picture pictureC = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/200969812/original/5702308a024e74c35fed4e0d8c94a6eb6260a4ed/do-professional-full-website-creation-with-repon.jpg");

		card1.addPicture(picture1);
		card1.addPicture(picture2);
		card2.addPicture(picture3);
		card3.addPicture(picture4);
		card3.addPicture(picture5);
		card3.addPicture(picture6);
		card4.addPicture(picture7);
		card4.addPicture(picture8);
		card4.addPicture(picture9);
		card5.addPicture(pictureA);
		card6.addPicture(pictureB);
		card6.addPicture(pictureC);

		cardRepository.saveAll(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));
		pictureRepository.saveAll(Arrays.asList(picture1, picture2, picture3, picture4, picture5, picture6,
				picture7, picture8, picture9, pictureA, pictureB, pictureC));

		System.out.println("Card 1 picture count: " + card1.getPictures().stream().count());
		System.out.println("Card 2 picture count: " + card2.getPictures().stream().count());
		System.out.println("Card 3 picture count: " + card3.getPictures().stream().count());
		System.out.println("Card 4 picture count: " + card4.getPictures().stream().count());
		System.out.println("Card 5 picture count: " + card5.getPictures().stream().count());
		System.out.println("Card 6 picture count: " + card6.getPictures().stream().count());
		System.out.println("Card 7 picture count: " + card7.getPictures().stream().count());

		System.out.println("Picture 1 card: " + picture1.getCard().getId());
		System.out.println("Picture 2 card: " + picture2.getCard().getId());
		System.out.println("Picture 3 card: " + picture3.getCard().getId());
		System.out.println("Picture 4 card: " + picture4.getCard().getId());
		System.out.println("Picture 5 card: " + picture5.getCard().getId());
		System.out.println("Picture 6 card: " + picture6.getCard().getId());
		System.out.println("Picture 7 card: " + picture7.getCard().getId());
		System.out.println("Picture 8 card: " + picture8.getCard().getId());
		System.out.println("Picture 9 card: " + picture9.getCard().getId());
		System.out.println("Picture A card: " + pictureA.getCard().getId());
		System.out.println("Picture B card: " + pictureB.getCard().getId());
		System.out.println("Picture C card: " + pictureC.getCard().getId());


		System.out.println("Card's number in DB after executing main: " + cardRepository.findAll().size());
		System.out.println("Picture's number in DB after executing main: " + pictureRepository.findAll().size());
	}

}
