package edu.tutorial.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.tutorial.entity.Tutorial;
import edu.tutorial.exception.GlobalExceptionForTutorial;
import edu.tutorial.repository.TutorialRepository;

@Service
public class TutorialServiceImpl implements TutorialService 
{
    @Autowired
    private TutorialRepository tutorialRepository;
	
	@Override
	public ResponseEntity<Tutorial> createTutorial(Tutorial tutorial) throws GlobalExceptionForTutorial {
		
		if (tutorial.getTitle() == tutorial.getTitle().toLowerCase())
		{
			throw new GlobalExceptionForTutorial("Title's first letter has to be captital");
		}
		try
		{
		Tutorial _tutorial = tutorialRepository
				.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
		return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		}
		
		catch (Exception e) 
		{
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@Override
	public ResponseEntity<Tutorial> updateTutorial(int id, Tutorial tutorial) throws GlobalExceptionForTutorial {
		Optional<Tutorial> tdata = tutorialRepository.findById(id);
		if (tdata.isPresent()) {
			if (tutorial.getTitle() == tutorial.getTitle().toLowerCase())
			{
				throw new GlobalExceptionForTutorial("Title's first letter has to be captital");
			}
			Tutorial _tutorial = tdata.get();
			_tutorial.setTitle(tutorial.getTitle());
			_tutorial.setDescription(tutorial.getDescription());
			_tutorial.setPublished(tutorial.isPublished());
			return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
		}
		 else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}

	@Override
	public  ResponseEntity<List<Tutorial>> getAllTutorials(String title) {
		try
		{
		List<Tutorial> tutorials = new ArrayList<Tutorial>();
		if (title == null)
			tutorialRepository.findAll().forEach(tutorials::add);
		else {
			tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

		}
		return new ResponseEntity<>(tutorials, HttpStatus.OK);
	}
		catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Tutorial> getAllTutorialsById(int id) {
		Optional<Tutorial> tdata = tutorialRepository.findById(id);
		if (tdata.isPresent()) {
			return new ResponseEntity<>(tdata.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@Override
	public ResponseEntity<Tutorial> deleteTutorial(int id) {
		try {
			tutorialRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public String description() {
		return "<body bgcolor='black' text='white'><center><h1>The java tutorial for spring boot has been published and its really helpful.</h1>"
				+ "</center></body>";
	}
	
}



