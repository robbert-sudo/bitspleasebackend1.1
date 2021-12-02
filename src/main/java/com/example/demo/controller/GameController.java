package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "games")
public class GameController {

    private GameService gameService;

    @Autowired
    public
    GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity getGames() {
        Iterable<Game> games = gameService.findAll();
        return ResponseEntity.ok(games);

    }


    @PostMapping
    public ResponseEntity addGame(@RequestBody Game game) {
        gameService.save(game);
        return ResponseEntity.ok("Toegevoegd met id " + game.id);
    }



}
