/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab11bonus;

/**
 *
 * @author adria
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController {
    private final List<Games> games=new ArrayList<>();
    @Autowired
    private GameRepo gameRepo;

    @GetMapping
    public List<Games> getAllGames() {
        List<Games> g= (List<Games>) gameRepo.findAll();
        if(g==null)
            throw new MyException("Games not found");
        return g;
    }

    @GetMapping("/{id}")
    public Games show(@PathVariable("id") Integer id){
        return games.stream()
                .filter(g->g.getId()==id).findFirst()
                .orElseThrow( ()->new MyException("Game not found"));
    }

    @PostMapping("/games")
    public Games create(@RequestBody Map<String, String> body){
        String id_castigator = body.get("id_castigator");
        Games g = new Games();
        g.setIdCastigator(Integer.parseInt(id_castigator));
        String id_player1=body.get("id_player1");
        g.setIdPlayer1(Integer.parseInt(id_player1));
        String id_player2=body.get("id_player2");
        g.setIdPlayer2(Integer.parseInt(id_player2));
        games.add(g);
        return gameRepo.save(g);
    }
}
