package br.api.lucascode.br.warehousesystem.service;

import br.api.lucascode.br.warehousesystem.dto.cliente.ClienteRequestDto;
import br.api.lucascode.br.warehousesystem.exception.exceptions.cliente.CpfIncorretoException;
import br.api.lucascode.br.warehousesystem.exception.exceptions.empresa.CnpjIncorretoException;
import br.api.lucascode.br.warehousesystem.model.Cliente;
import br.api.lucascode.br.warehousesystem.model.enums.TipoDocumento;
import br.api.lucascode.br.warehousesystem.repository.ClienteRepository;
import br.api.lucascode.br.warehousesystem.validation.CnpjValidation;
import br.api.lucascode.br.warehousesystem.validation.CpfValidation;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository repositoryCliente;
    private final CnpjValidation validationCnpj;
    private final CpfValidation validationCpf;

    public ClienteService(ClienteRepository repositoryCliente, CnpjValidation validationCnpj,
                          CpfValidation validationCpf){

        this.repositoryCliente = repositoryCliente;
        this.validationCnpj = validationCnpj;
        this.validationCpf = validationCpf;
    }

    public ClienteRequestDto salvarCliente(Cliente cliente){
        if(cliente.getTipoDocumento() == TipoDocumento.CPF &&
                !validationCpf.confirmaCpf(cliente.getDocumento())){
            throw new CpfIncorretoException("CPF invalido");
        }
        if(cliente.getTipoDocumento() == TipoDocumento.CNPJ &&
                !validationCnpj.ComfirmarCnpj(cliente.getDocumento())){
            throw new CnpjIncorretoException("CNPJ incorreto");
        }
        repositoryCliente.save(cliente);
        return new ClienteRequestDto("Clinete salvo com sucesso!");
    }
}
