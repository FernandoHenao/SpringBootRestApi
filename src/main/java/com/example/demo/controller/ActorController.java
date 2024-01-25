package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.model.Actor;
import com.example.demo.service.ActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/actors")
public class ActorController {

    private ActorService actorService;

    // build create  REST API
    @PostMapping("/save")
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor){
        Actor savedActor = actorService.createActor(actor);
        return new ResponseEntity<>(savedActor, HttpStatus.CREATED);
    }

    // build get actor by id REST API
    // http://localhost:8080/api/actors/1
    @GetMapping("/findById/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable("id") Long actorId){
        Actor actor = actorService.getActorById(actorId);
        return new ResponseEntity<>(actor, HttpStatus.OK);
    }

    // Build Get All Actors REST API
    // http://localhost:8080/api/actors
    @GetMapping("/findAll")
    public ResponseEntity<List<Actor>> getAllActors(){
        List<Actor> actors = actorService.getAllActors();
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }

    // Build Update Actor REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/actors/1
    public ResponseEntity<Actor> updateActor(@PathVariable("id") Long actorId,
                                           @RequestBody Actor actor){
        actor.setActor_id(actorId);
        Actor updatedActor = actorService.updateActor(actor);
        return new ResponseEntity<>(updatedActor, HttpStatus.OK);
    }

    // Build Delete Actor REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteActor(@PathVariable("id") Long actorId){
        actorService.deleteActor(actorId);
        return new ResponseEntity<>("Actor successfully deleted!", HttpStatus.OK);
    }
}