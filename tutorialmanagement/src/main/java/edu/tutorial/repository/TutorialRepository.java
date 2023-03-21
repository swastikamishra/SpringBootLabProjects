  package edu.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.tutorial.entity.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

	// custom spring boot search mechanism

	List<Tutorial> findByTitleContaining(String title);

	List<Tutorial> findByPublished(boolean published);
}
