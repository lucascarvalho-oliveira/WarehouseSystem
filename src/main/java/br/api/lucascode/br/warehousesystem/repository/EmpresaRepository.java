package br.api.lucascode.br.warehousesystem.repository;

import br.api.lucascode.br.warehousesystem.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
