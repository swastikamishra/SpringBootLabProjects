package edu.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.tutorial.entity.Tutorial;
import edu.tutorial.repository.TutorialRepository;

@SpringBootApplication
public class TutorialmanagementApplication implements CommandLineRunner {

	@Autowired
	private TutorialRepository tutorialRepository;

	public static void main(String[] args) {
		SpringApplication.run(TutorialmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tutorial t1 = Tutorial.builder().title("Java").description("Core Java").published(false).build();
		Tutorial t2 = Tutorial.builder().title("Java").description("Advanced Java").published(false).build();
		Tutorial t3 = Tutorial.builder().title("Java").description("Spring Boot with Java").published(true).build();
		Tutorial t4 = Tutorial.builder().title("Python").description("Core Python").published(false).build();
		Tutorial t5 = Tutorial.builder().title("Python").description("Data Science with Python").published(false).build();
		Tutorial t6 = Tutorial.builder().title("Python").description("Machine Learning with Python").published(true).build();
		tutorialRepository.save(t1);
		tutorialRepository.save(t2);
		tutorialRepository.save(t3);
		tutorialRepository.save(t4);
		tutorialRepository.save(t5);
		tutorialRepository.save(t6);
		System.out.println("--------------------------all saved----------------------");

	}

}
