package com.example.demo.service;

import com.example.demo.model.Game;

public interface GameService {


    void save(Game game);

    Iterable<Game> findAll();

    Iterable<Game> findByName(String name);

    void deleteById(long id);

    void updateGame(long id, Game game);
}
