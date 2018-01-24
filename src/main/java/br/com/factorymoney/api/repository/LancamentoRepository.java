package br.com.factorymoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.factorymoney.api.model.Lancamento;
import br.com.factorymoney.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
