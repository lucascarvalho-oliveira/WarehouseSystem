package br.api.lucascode.br.warehousesystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer idProduto;
    @NotBlank
    private String nome;
    @Positive
    private Integer quantidade;
    @Positive
    private BigDecimal precoUnitario;
    @Positive
    private BigDecimal precoTotal;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Empresa empresa;

    protected Produto(){}

    public Produto(String nome, Integer quantidade, BigDecimal precoUnitario,
                   BigDecimal precoTotal, Empresa empresa) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoTotal = precoTotal;
        this.empresa = empresa;
    }
}
