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

		//Creating cards
		Card card1 = new Card(null, "I will design modern responsive website UI UX design",
				"Hi, I am Ruchi Bhut. I believe in clean & quality work. I deliver creative, strategic, " +
						"and innovative solutions to help brands with new challenges while managing every touch-point.",
				"RuchiBhut", "Web Design",5, 139.99D);
		Card card2= new Card(null, "I will layout design supreme whitepaper or crypto white paper",
				"My name is Alex and I have 12 years of experience in thousands of projects in various industries. "
				, "Alex", "Graphic Design",5, 240.00D);
		Card card3 = new Card(null, "I will design and create your shopify website",
				"Hi there, " +
						"my name is Heather and I specialise in helping e-commerce businesses launch a strong online presence"
				, "Heather", "Web Design",5, 2100.00D);
		Card card4= new Card(null, "I will do a remarkable video editing and post production job for you",
				"I have worked for fashion & music videos, social media content, video games, commercials and documentaries.",
				"SlideSoul", "Video & Animation",4, 139.99D);
		Card card5 = new Card(null, "I will make your life or travel exciting video",
				"Are you looking to edit your random videos to something exciting ? ",
				"Luka", "Video & Animation",5, 99.99D);
		Card card6= new Card(null, "I will create google advanced SEO stack",
				"We have an Advance Technique FOR Google SEO which Googgle LOVES itself",
				"FaisikKhan", "SEO",4, 32.00D);
		Card card7= new Card(null, "I will rock your local SEO traffic and leads",
				"I have 8 years of SEO experience, and I've been VP of a company which does search engine optimization in the US and Canada.",
				"onlinedoctors", "SEO",5, 274.99D);
		Card card8= new Card(null, "I will write an engaging, persuasive article",
				"Let me help you out.", "Mathew", "SEO", 5, 232.65D);
		Card card9= new Card(null, "I will manually translate english to korean or vice versa",
				"All kinds of text is welcome! ", "Translation", "gowoonson", 4, 4.65D);
		Card card10= new Card(null, "I will translate italian to english traduzione inglese italiano",
				"I will proficiently translate for you from English to Italian and vice versa.",
				"Translation", "Marco", 5, 9.50D);
		Card card11= new Card(null, "I will design and code android,ios apps and websites",
				"We are firm with over 15 highly skilled developers working in different technologies.We have designed  " +
						"and built many  iOS and Android apps for last 6 years.",
						"Mobile App", "alidogar", 5, 270.00D);
		Card card12 = new Card(null, "I will do development and design for android and iphone application",
				"We have created a variety of apps and websites including e-commerce, chat, social, business, dating, banking etc.",
				"Mobile App", "ioslover", 4, 189.00D);

		//Creating pictures
		Picture picture1 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/166530150/original/9b7d04f2c3f16ed6171a39b7d30a17994021c648/design-modern-responsive-website-ui-ux-design.jpg");
		Picture picture2 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs2/166530150/original/df86a543151c8e0aec7ecc193f2bf44e7f5ac32d/design-modern-responsive-website-ui-ux-design.jpg");
		Picture picture3 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/171997883/original/9f02c1a951df76a1b2032c8fb85f1c3123d4af1b/design-unique-creative-business-website.jpg");
		Picture picture4 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/223739658/original/9bf00d87e496c47870ac5a6c256c4eaad2586919/design-and-create-your-shopify-website.jpg");
		Picture picture5 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs2/223739658/original/393589852fea08b18e2c2cac97ac729f09d14c2a/design-and-create-your-shopify-website.jpg");
		Picture picture6 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs3/223739658/original/f8a8b249093765ad73c70b57f25fd50a0491444f/design-and-create-your-shopify-website.jpg");
		Picture picture7 = new Picture(null, "https://fiverr-res.cloudinary.com/videos/so_24.28141,t_main1,q_auto,f_auto/bhtmbt0qwttey7eeuhgt/do-a-remarkable-video-editing-and-post-production-job-for-you.png");
		Picture picture8 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/179882468/original/ff1bbeb9db45d0d1889d03d4a8631c57cc4f07e2/do-a-remarkable-video-editing-and-post-production-job-for-you.jpg");
		Picture picture9 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs2/179882468/original/7fb47f1f50ff6c6270b0aa38e27167f4dbbb5e12/do-a-remarkable-video-editing-and-post-production-job-for-you.jpg");
		Picture pictureA = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/106447547/original/f60a7586f93c488e06f58544c95db6f62228de54/make-your-life-or-travel-exciting-video.jpg");
		Picture pictureB = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/114252862/original/26322760920b015accf42c0fa3fd0fdf7f3d65a7/create-google-advanced-seo-stack.png");
		Picture pictureC = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs2/114252862/original/461f1ab6c2247c41be0040048e1979051bae5307/create-google-advanced-seo-stack.jpg");
		Picture pictureD = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs2/106447547/original/7e099ef77828ccfdc620c55bf69b4bc9a0375172/make-your-life-or-travel-exciting-video.jpg");
		Picture pictureE = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/105873111/original/cbbe09c453da8e7b1b5b80dd3f4564db3f3995b3/rock-your-local-seo-traffic-and-leads.jpg");
		Picture pictureF = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_smartwm/t_main1,q_auto,f_auto,q_auto,f_auto/attachments/delivery/asset/35b32952f5249e9217c27af3fbeb4553-1611866051/Title%20-%20Dr%20Site%203/rock-your-local-seo-traffic-and-leads.JPG");
		Picture pictureG = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/224742044/original/5119fb4d2ab58e9d138d3a970fe124c2a8888044/rank-your-local-business-in-local-search.jpg");
		Picture pictureH = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs2/171997883/original/63faf5a5fd85264bde685c01b3d5bbcf1156048e/design-unique-creative-business-website.jpg");
		Picture picture10 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/180086830/original/eebeda17edee1032dc897d62639cf17547af767c/engage-and-persuade-your-readers.png");
		Picture picture11 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/142771531/original/6335bb9fa60fa466a84db46fc7c94ed2f898f404/manually-translate-english-to-korean-and-vice-versa.png");
		Picture picture12 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/145961880/original/c3e270d18af1da4f81166b9c997d034a521c7c88/make-professional-translations-italian-english-fast-delivery.jpg");
		Picture picture13 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/100836013/original/1831e959609257f9b807df0ceb3c90070134e634/design-and-code-android-apps.jpg");
		Picture picture14 = new Picture(null, "https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/3112527/original/bca1d81b8714bc0aafaa9e8b4cd3f74fb7ee73a7/convert-your-app-in-ios-7.jpg");

		//Adding pictures to cards
		card1.addPicture(picture1);
		card1.addPicture(picture2);
		card2.addPicture(picture3);
		card2.addPicture(pictureH);
		card3.addPicture(picture4);
		card3.addPicture(picture5);
		card3.addPicture(picture6);
		card4.addPicture(picture7);
		card4.addPicture(picture8);
		card4.addPicture(picture9);
		card5.addPicture(pictureA);
		card5.addPicture(pictureD);
		card6.addPicture(pictureB);
		card6.addPicture(pictureC);
		card7.addPicture(pictureE);
		card7.addPicture(pictureF);
		card7.addPicture(pictureG);
		card8.addPicture(picture10);
		card9.addPicture(picture11);
		card10.addPicture(picture12);
		card11.addPicture(picture13);
		card12.addPicture(picture14);

		//Saving cards and pictures in DB
		cardRepository.saveAll(Arrays.asList(card1, card2, card3, card4, card5, card6, card7, card8, card9, card10,
				card11, card12));
		pictureRepository.saveAll(Arrays.asList(picture1, picture2, picture3, picture4, picture5, picture6,
				picture7, picture8, picture9, pictureA, pictureB, pictureC, pictureD, pictureE, pictureF, pictureG,
				pictureH, picture10, picture11, picture12, picture13, picture14));

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
