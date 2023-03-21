package edu.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.tutorial.entity.Tutorial;
import edu.tutorial.exception.GlobalExceptionForTutorial;

import edu.tutorial.service.TutorialService;


@RestController
@RequestMapping("/api")
public class TutorialController {

	@Autowired
	private TutorialService tutorialService;
	
	
	@GetMapping("/desc")
	public String description() {
		
		return tutorialService.description();
	} 
	
	@PostMapping("/tutorials")
	public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial)throws GlobalExceptionForTutorial {
		 {
			 return tutorialService.createTutorial(tutorial);
		 }
	}

	@PutMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") int id, @RequestBody Tutorial tutorial)throws GlobalExceptionForTutorial {
		{
			return tutorialService.updateTutorial(id, tutorial);
		}
	}

	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
		
		return tutorialService.getAllTutorials(title);
	}

	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> getAllTutorialsById(@PathVariable int id) {
		
		return tutorialService.getAllTutorialsById(id);
		

	}

	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial> deleteTutorial(@PathVariable int id) {
		
		return tutorialService.deleteTutorial(id);
	}

}
