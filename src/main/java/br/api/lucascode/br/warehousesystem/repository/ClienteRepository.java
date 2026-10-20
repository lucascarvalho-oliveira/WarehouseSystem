package br.api.lucascode.br.warehousesystem.repository;

import br.api.lucascode.br.warehousesystem.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
