package com.example.demo.UserRepository;

import com.example.demo.model.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository <Game, Long> {

    Iterable<Game> findByNameContains(String name);
}
