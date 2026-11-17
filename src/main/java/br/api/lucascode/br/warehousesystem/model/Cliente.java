package br.api.lucascode.br.warehousesystem.model;

import br.api.lucascode.br.warehousesystem.model.enums.TipoDocumento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String documento;

    private TipoDocumento tipoDocumento;

    private boolean emailConfirmado;

    protected Cliente(){}

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @OneToMany(mappedBy = "nota_fiscal")@JsonIgnore
    List<NotaFiscal> notasFiscais;

    public Cliente(String nome, String email, TipoDocumento tipoDocumento, String documento, boolean emailConfirmado) {
        this.nome = nome;
        this.email = email;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.emailConfirmado = emailConfirmado;

        this.notasFiscais = new ArrayList<>();
    }
}
