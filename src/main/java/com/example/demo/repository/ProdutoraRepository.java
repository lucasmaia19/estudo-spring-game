package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Produtora;

@Repository
public interface ProdutoraRepository extends JpaRepository<Produtora, Long> {
	
}
