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

import com.example.demo.entity.Produtora;
import com.example.demo.repository.ProdutoraRepository;

@RestController
@RequestMapping("/api/produtoras")
public class ProdutoraController {


	// Property
	
	@Autowired
	private ProdutoraRepository produtoraRepository;


	// Resource
	
	@GetMapping
	public List<Produtora> listaTodos() {
		return produtoraRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Produtora> listarUm(@PathVariable Long id) { 
		return produtoraRepository.findById(id);
	}

	@PostMapping
	public Produtora cadastrar(@RequestBody Produtora produtora) {
		return produtoraRepository.save(produtora);
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		produtoraRepository.deleteById(id);
		return "A produtora com Id: " + id + " Foi deletado com sucesso";
	}
	
	@PutMapping("/{id}")
	public Produtora atualizar(@RequestBody Produtora produtora, @PathVariable Long id) {
		Produtora produtoraSaved = produtoraRepository.findById(id).get();

		produtoraSaved.setNome(produtora.getNome()); 
		produtoraSaved.setFaturamentoAnual(produtora.getFaturamentoAnual());
		produtoraSaved.setFundadaEm(produtora.getFundadaEm());

		return produtoraRepository.save(produtoraSaved); 
	}
}
