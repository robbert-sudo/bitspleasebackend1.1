package com.example.demo.service;

import com.example.demo.UserRepository.GameRepository;
import com.example.demo.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;


    public Iterable<Game> findAll() {
        Iterable<Game> games = gameRepository.findAll();
        return games;
    }

    public void save(Game game) {
        gameRepository.save(game);
    }



}
