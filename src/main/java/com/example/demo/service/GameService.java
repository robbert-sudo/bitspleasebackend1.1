package com.example.demo.service;

import com.example.demo.model.Game;

public interface GameService {


    void save(Game game);

    Iterable<Game> findAll();
}
