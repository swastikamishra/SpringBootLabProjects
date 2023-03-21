package edu.tutorial.service;

import java.util.List;


import org.springframework.http.ResponseEntity;

import edu.tutorial.entity.Tutorial;
import edu.tutorial.exception.GlobalExceptionForTutorial;

public interface TutorialService {
	
	 String description();

    ResponseEntity<Tutorial> createTutorial(Tutorial tutorial) throws GlobalExceptionForTutorial;
	
	ResponseEntity<Tutorial> updateTutorial(int id,Tutorial tutorial) throws GlobalExceptionForTutorial;
	
	ResponseEntity<List<Tutorial>> getAllTutorials(String title);
	
	ResponseEntity<Tutorial> getAllTutorialsById(int id);

	ResponseEntity<Tutorial> deleteTutorial(int id);

	


}
