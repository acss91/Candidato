package com.candidatos.candidatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.candidatos.candidatos.model.CartaoCredito;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {
CartaoCredito findByNumero(Long numero);
}
