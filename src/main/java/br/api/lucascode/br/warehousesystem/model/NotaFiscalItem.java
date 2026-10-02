package br.api.lucascode.br.warehousesystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class NotaFiscalItem {

    @EmbeddedId
    private NotaFiscalItemId id;

    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @ManyToOne
    @MapsId("idNotaFiscal")
    @JoinColumn(name = "id_nota_fiscal")
    private NotaFiscal notaFiscal;

    @Positive
    private Integer quantidade;
    @Positive
    private BigDecimal precoUnitario;

    @Column(insertable = false, updatable = false)
    private BigDecimal precoTotal;

    protected NotaFiscalItem(){}

    public NotaFiscalItem(Produto produto, NotaFiscal notaFiscal, Integer quantidade, BigDecimal precoUnitario) {
        this.produto = produto;
        this.notaFiscal = notaFiscal;
        this.id = new NotaFiscalItemId(produto.getIdProduto(), notaFiscal.getIdNotaFiscal());
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
}
