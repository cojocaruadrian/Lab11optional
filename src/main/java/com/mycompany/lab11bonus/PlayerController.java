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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class PlayerController {

    @Autowired
    private PlayerRepo playerRepo;
    private final List<Players> players=new ArrayList<>();

    @GetMapping("/players")
    public List getAllPlayers() {
        return (List) playerRepo.findAll();
    }

    @GetMapping("/players/{id}")
    public Players show(@PathVariable("id") Integer id){
        return players.stream()
                .filter(g->g.getId()==id).findFirst()
                .orElseThrow( ()->new MyException("Player not found"));
    }

    @PostMapping("/players")
    public Players create(@RequestBody Map<String, String> body){
        String nume = body.get("nume");
        Players p = new Players();
        p.setNume(nume);
        players.add(p);
        return playerRepo.save(p);
    }

    @PutMapping("/players/{id}")
    public Players updateUser(@RequestBody Map<String, String> body, @PathVariable Integer id) {
        String nume = body.get("nume");
        Players p = new Players();
        p.setNume(nume);
        p.setId(id);
        players.add(p);
        return playerRepo.save(p);
    }

    @DeleteMapping("/players/{id}")
    public boolean delete(@PathVariable String id){
        int PlayerID = Integer.parseInt(id);
        for(Players p: players){
            if(p.getId()==PlayerID)
                players.remove(p);
        }
        playerRepo.deleteById(PlayerID);
        return true;
    }
}
