package com.beisbolicos.playerStats.controller;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beisbolicos.playerStats.entity.People;
import com.beisbolicos.playerStats.serviceImpl.PeopleService;

@RestController
public class PeopleController {

	@Autowired
	PeopleService peopleService;

	@PostMapping(value = "/people")
	public ResponseEntity<Object> createEmployee(@RequestBody People people) {

		peopleService.createPeople(people);
		return new ResponseEntity<Object>("Successfully Saved", HttpStatus.OK);
	}

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<Object> getPeople(@PathVariable String id) {

		People people = peopleService.getPeopleById(id);
		return new ResponseEntity<Object>(people, HttpStatus.OK);
	}

	@PutMapping(value = "/people")
	public ResponseEntity<Object> updateEmployee(@RequestBody People people) {

		peopleService.updatePeople(people);
		return new ResponseEntity<Object>("Successfully Updated", HttpStatus.OK);
	}

	@DeleteMapping(value = "/people/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable String id) {

		peopleService.deletePeople(id);
		return new ResponseEntity<Object>("Successfully Deleted", HttpStatus.OK);
	}
	
	@GetMapping(value="/people")
	public ResponseEntity <Object> getPeople(){
		List<People> people = peopleService.getPeople();
		ResponseEntity<Object> listPeople = new ResponseEntity<>(people, HttpStatus.OK);
		//for(People item : people) {
		//	listPeople.add(new ResponseEntity<Object>(status))
		//}
		return listPeople;
	}
	
	@GetMapping(value="/people/{teamId}/{yearId}")
	public ResponseEntity <Object> getPeople(@PathVariable String teamId, @PathVariable int yearId){
		List<People> people = peopleService.getPeople(teamId, yearId);
		ResponseEntity<Object> listPeople = new ResponseEntity<Object>(people, HttpStatus.OK);
		return listPeople;
	}

}