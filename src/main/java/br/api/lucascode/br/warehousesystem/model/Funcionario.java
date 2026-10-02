package br.api.lucascode.br.warehousesystem.model;

import br.api.lucascode.br.warehousesystem.model.enums.RoleFuncionario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    @NotBlank
    private String nome;
    @NotBlank
    private LocalDate dataNascimento;
    @NotBlank
    private String telefone;
    @NotBlank
    private String senha;

    private RoleFuncionario roleFuncionario;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    protected Funcionario(){}

    public Funcionario(String nome, LocalDate dataNascimento, String telefone,
                       RoleFuncionario roleFuncionario, String senha, Empresa empresa) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.roleFuncionario = roleFuncionario;
        this.senha = senha;
        this.empresa = empresa;
    }
}

