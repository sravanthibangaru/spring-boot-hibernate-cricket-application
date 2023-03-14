package com.example.player.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.player.model.Player;
import com.example.player.service.PlayerJpaService;
// Write your code here

@RestController 
public class PlayerController{
    @Autowired 
    public PlayerJpaService playerJpaService;

    @GetMapping("/players")
    public ArrayList<Player> getAllPlayers(){
        return playerJpaService.getAllPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId){
        return playerJpaService.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return playerJpaService.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player){
        return playerJpaService.updatePlayer(playerId, player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId){
        playerJpaService.deletePlayer(playerId);
    }

}