package com.example.demo.service;

import com.example.demo.UserRepository.GameRepository;
import com.example.demo.exceptions.RecordNotFoundException;
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

    public Iterable<Game> findByName(String name) {
        return gameRepository.findByNameContains(name);
    }

    public Iterable<Game> findBySystem(String system) {
        return gameRepository.findBySystem(system);
    }

    public void save(Game game) {
        gameRepository.save(game);
    }

    public void deleteById(long id) {
        try {
            gameRepository.deleteById(id);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            throw new RecordNotFoundException();
        }
    }


    @Override
    public void updateGame(long id, Game game) {
        if (!gameRepository.existsById(id)) throw new RecordNotFoundException();
        Game existingGame = gameRepository.findById(id).get();
        existingGame.setName(game.getName());
        existingGame.setSystem(game.getSystem());
        existingGame.setDeveloper(game.getDeveloper());
        existingGame.setUploader_id(game.getUploader_id());
        existingGame.setImage(game.getImage());
        gameRepository.save(existingGame);

    }


}
