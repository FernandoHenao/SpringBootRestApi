package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.model.PersonOfInterest;
import com.example.demo.service.PersonOfInterestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/personOfInterests")
public class PersonOfInterestController {

    private PersonOfInterestService personOfInterestService;

    // build create  REST API
    @PostMapping("/save")
    public ResponseEntity<PersonOfInterest> createPersonOfInterest(@RequestBody PersonOfInterest personOfInterest){
        PersonOfInterest savedPersonOfInterest = personOfInterestService.createPersonOfInterest(personOfInterest);
        return new ResponseEntity<>(savedPersonOfInterest, HttpStatus.CREATED);
    }

    //hi
    // build get personOfInterest by id REST API
    // http://localhost:8080/api/personOfInterests/1
    @GetMapping("/findById/{id}")
    public ResponseEntity<PersonOfInterest> getPersonOfInterestById(@PathVariable("id") Long personOfInterestId){
        PersonOfInterest personOfInterest = personOfInterestService.getPersonOfInterestById(personOfInterestId);
        return new ResponseEntity<>(personOfInterest, HttpStatus.OK);
    }

    // Build Get All PersonOfInterests REST API
    // http://localhost:8080/api/personOfInterests
    @GetMapping("/findAll")
    public ResponseEntity<List<PersonOfInterest>> getAllPersonOfInterests(){
        List<PersonOfInterest> personOfInterests = personOfInterestService.getAllPersonOfInterests();
        return new ResponseEntity<>(personOfInterests, HttpStatus.OK);
    }

    @GetMapping("/findByLastNameDob")
    public ResponseEntity<List<PersonOfInterest>> getPersonOfInterestByLastNameDob(@RequestParam String lastName, @RequestParam int dobMonth, @RequestParam int dobDay, @RequestParam int dobYear){
        List<PersonOfInterest> personOfInterest = personOfInterestService.findByLastNameAndDob(lastName, dobMonth, dobDay, dobYear);
        return new ResponseEntity<>(personOfInterest, HttpStatus.OK);
    }

    @GetMapping("/findByFirstLastNameDobYear")
    public ResponseEntity<List<PersonOfInterest>> getPersonOfInterestByFirstLastNameDobYear(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int dobYear){
        List<PersonOfInterest> personOfInterest = personOfInterestService.findByFirstNameLastNameDobYear(firstName, lastName, dobYear);
        return new ResponseEntity<>(personOfInterest, HttpStatus.OK);
    }

    // Build Delete PersonOfInterest REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePersonOfInterest(@PathVariable("id") Long personOfInterestId){
        personOfInterestService.deletePersonOfInterest(personOfInterestId);
        return new ResponseEntity<>("PersonOfInterest successfully deleted!", HttpStatus.OK);
    }

}