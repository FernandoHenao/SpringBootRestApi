package com.example.demo.service;

import lombok.AllArgsConstructor;
import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;
import com.example.demo.service.ActorService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {

    private ActorRepository actorRepository;

    @Override
    public Actor createActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor getActorById(Long actorId) {
        Optional<Actor> optionalActor = actorRepository.findById(actorId);
        return optionalActor.get();
    }

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public Actor updateActor(Actor actor) {
        Actor existingActor = actorRepository.findById(actor.getActor_id()).get();
        existingActor.setFirstName(actor.getFirstName());
        existingActor.setLastName(actor.getLastName());
        existingActor.setLastUpdate(actor.getLastUpdate());
        Actor updatedActor= actorRepository.save(existingActor);
        return updatedActor;
    }

    @Override
    public void deleteActor(Long actorId) {
        actorRepository.deleteById(actorId);
    }
}