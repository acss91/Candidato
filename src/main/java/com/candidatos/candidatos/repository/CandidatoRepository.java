package com.candidatos.candidatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.candidatos.candidatos.model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
Candidato findByDocumento(Long documento);
}
