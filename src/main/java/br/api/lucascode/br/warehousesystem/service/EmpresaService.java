package br.api.lucascode.br.warehousesystem.service;

import br.api.lucascode.br.warehousesystem.dto.EmpresaRequestDto;
import br.api.lucascode.br.warehousesystem.model.Empresa;
import br.api.lucascode.br.warehousesystem.repository.EmpresaRepository;
import br.api.lucascode.br.warehousesystem.validation.CnpjValidation;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    private final EmpresaRepository repositoryEmpresa;
    private final CnpjValidation validationCnpj;

    public EmpresaService(EmpresaRepository repositoryEmpresa, CnpjValidation validationCnpj){
        this.repositoryEmpresa = repositoryEmpresa;
        this.validationCnpj = validationCnpj;
    }

    public EmpresaRequestDto salvarEmpresa(Empresa empresa){

    }
}
