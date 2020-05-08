package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Game;
import com.example.demo.repository.GameRepository;

/**
 * api rest rodando no endereço localhost:1010/api/games
 * 
 * @author Lucas
 *
 */

@RestController
@RequestMapping("/api/games")
public class GameController { // receber requisiçoes http. ex: post,get,delete

	@Autowired
	private GameRepository gameRepository;


	// 01 mapeia o verbo http POST, 
	// 02 um metodo java que salva o objeto informado no banco de dados
	@PostMapping
	public Game cadastrar(@RequestBody Game game) {
		return gameRepository.save(game);
	}

	// ...
	@GetMapping // mapea o verbo http GET
	public List<Game> listaTodos() { // retorna todos as informações cadastrados no banco de dados
		return gameRepository.findAll();
	}
	
	@GetMapping("/{id}") // mapea o verbo http, GET com um parametro id
	public Optional<Game> findOne(@PathVariable Long id) { // meu metodo sempre ira retorna se ele será publico ou privado, depois o tipo de dado que ele retorna e depois o neme que será dado 
		return gameRepository.findById(id); // gameRepository ele acessa o banco de dados e busca um registro usando o id fornecido
	}

	@DeleteMapping("/{id}") // mapea o verbo http DELETE
	public String delete (@PathVariable Long id) { // retorna um parametro
		gameRepository.deleteById(id); // ele vai no banco de dados e executa a função deleta com o codigo fornecido
		return "O Game com Id: " + id + " Foi deletado com sucesso"; // texto explicativo 
	}
	
	@PutMapping("/{id}") // mapea o verbo http PUT com um parametro id
	public Game updateGame(@RequestBody Game game, @PathVariable Long id) {
		Game gameSaved = gameRepository.findById(id).get(); // pegar a informação no meu banco de dados

		gameSaved.setNome(game.getNome()); // vou modificar a informação 
		gameSaved.setAno(game.getAno());

		return gameRepository.save(gameSaved); // vou salva a informação modificada no meu banco de dados 
	}
}
