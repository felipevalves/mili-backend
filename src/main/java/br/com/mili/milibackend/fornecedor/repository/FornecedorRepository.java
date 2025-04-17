package br.com.mili.milibackend.fornecedor.repository;


import br.com.mili.milibackend.fornecedor.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    Optional<Fornecedor> findByCodUsuario(Integer codUsuario);
}
