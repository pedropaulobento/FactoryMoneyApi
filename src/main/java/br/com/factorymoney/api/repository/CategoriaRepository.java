package br.com.factorymoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.factorymoney.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
