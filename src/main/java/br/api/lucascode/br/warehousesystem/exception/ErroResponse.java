package br.api.lucascode.br.warehousesystem.exception;

public record ErroResponse(
        int status,
        String mensagem
){}
