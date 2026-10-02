package br.api.lucascode.br.warehousesystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class NotaFiscalItemId implements Serializable {

    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "id_nota_fiscal")
    private Integer idNotaFiscal;

    protected  NotaFiscalItemId(){}

    public NotaFiscalItemId(Integer idProduto, Integer idNotaFiscal) {
        this.idProduto = idProduto;
        this.idNotaFiscal = idNotaFiscal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotaFiscalItemId)) return false;
        NotaFiscalItemId that = (NotaFiscalItemId) o;
        return Objects.equals(idProduto, that.idProduto) &&
                Objects.equals(idNotaFiscal, that.idNotaFiscal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, idNotaFiscal);
    }
}
