package com.example.demo.service;

import com.example.demo.model.Actor;
import java.util.List;

public interface ActorService {
    Actor createActor(Actor actor);

    Actor getActorById(Long actorId);

    List<Actor> getAllActors();

    Actor updateActor(Actor actor);

    void deleteActor(Long actorId);
}