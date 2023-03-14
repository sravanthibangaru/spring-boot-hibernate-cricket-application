package com.example.player.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.player.repository.PlayerRepository;
import com.example.player.model.Player;
import com.example.player.repository.PlayerJpaRepository;

// Write your code here
@Service 
public class PlayerJpaService implements PlayerRepository{
    @Autowired 
    private PlayerJpaRepository playerRepository;

    @Override
    public ArrayList<Player> getAllPlayers(){
        List<Player> playersList = playerRepository.findAll();
        ArrayList<Player> players = new ArrayList<>(playersList);
        return players;
    }

    @Override
    public Player getPlayerById(int playerId){
        try{
            Player player = playerRepository.findById(playerId).get();
            return player;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    @Override
    public Player updatePlayer(int playerId, Player player){
        try{
            Player existingPlayer = playerRepository.findById(playerId).get();
            if(player.getPlayerName() != null){
                existingPlayer.setPlayerName(player.getPlayerName());
            }
            if(player.getJerseyNumber() != 0){
                existingPlayer.setJerseyNumber(player.getJerseyNumber());
            }
            if(player.getRole() != null){
                existingPlayer.setRole(player.getRole());
            }
            playerRepository.save(existingPlayer);
            return existingPlayer;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePlayer(int playerId){
        try{
            playerRepository.deleteById(playerId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}