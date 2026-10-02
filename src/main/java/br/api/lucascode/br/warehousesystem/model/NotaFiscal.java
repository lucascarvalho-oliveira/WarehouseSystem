package br.api.lucascode.br.warehousesystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nota_fiscal")
    private Integer idNotaFiscal;
    @NotBlank
    private String cfop;
    @NotNull
    private LocalDate dataEmissao;

    @ManyToOne
    @JoinColumn(name = "id_emitente")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "id_destinatario")
    private Cliente cliente;

    @OneToMany(mappedBy = "notaFiscal")
    private List<NotaFiscalItem> notaFiscalItemList;

    protected NotaFiscal(){}

    public NotaFiscal(String cfop, LocalDate dataEmissao, Empresa empresa, Cliente cliente) {
        this.cfop = cfop;
        this.dataEmissao = dataEmissao;
        this.empresa = empresa;
        this.cliente = cliente;
    }
}
