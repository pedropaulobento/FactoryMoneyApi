package br.com.factorymoney.api.repository.lancamento;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.factorymoney.api.dto.LancamentoEstatisticaCategoria;
import br.com.factorymoney.api.dto.LancamentoEstatisticaDia;
import br.com.factorymoney.api.dto.LancamentoEstatisticaPessoa;
import br.com.factorymoney.api.model.Lancamento;
import br.com.factorymoney.api.repository.filter.LancamentoFilter;
import br.com.factorymoney.api.repository.projection.ResumoLancamento;

public interface LancamentoRepositoryQuery {
	
	
	List<LancamentoEstatisticaPessoa> porPessoa(LocalDate inicio, LocalDate fim);
	List<LancamentoEstatisticaCategoria> porCategoria(LocalDate mesReferencia);
	List<LancamentoEstatisticaDia> porDia(LocalDate mesReferencia);

	Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
	
}
