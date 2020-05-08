package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Game;
import com.example.demo.repository.GameRepository;

@RestController
@RequestMapping("/api/games")
public class GameController {

	@Autowired
	private GameRepository gameRepository;

	@PostMapping
	public Game cadastrar(@RequestBody Game game) {
		return gameRepository.save(game);
	}

	@GetMapping
	public List<Game> listaTodos() {
		return gameRepository.findAll();
	}
	
	@GetMapping("/lucas-maia")
	public String olaMundo() {
	   
		return "Ola Mundo";
	}
	
	@DeleteMapping("/{id}")
	public String delete (@PathVariable Long id) {
		gameRepository.deleteById(id);
		return "Objeto Game com Id: " + id + " Deletado com sucesso";
		
	}

}
