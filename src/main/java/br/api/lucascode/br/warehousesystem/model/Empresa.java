package br.api.lucascode.br.warehousesystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    @NotBlank
    private String nome;
    @NotBlank
    private String cnpj;
    @NotBlank
    private String endereco;

    protected Empresa(){}

    @OneToMany(mappedBy = "funcionario")@JsonIgnore
    List<Funcionario> funcionarios;

    @OneToMany(mappedBy = "produto")@JsonIgnore
    List<Produto> produtos;

    @OneToMany(mappedBy = "cliente")@JsonIgnore
    List<Cliente> clientes;

    @OneToMany(mappedBy = "nota_fiscal")@JsonIgnore
    List<NotaFiscal> notasFiscais;
}

