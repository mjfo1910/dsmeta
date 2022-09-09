package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Missoes;

public interface MissoesRepository extends JpaRepository<Missoes, Long> {
	@Query("SELECT obj FROM Missoes obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.contribuicao DESC")
	Page<Missoes> findMissoes(LocalDate min, LocalDate max, Pageable pageable);

}
