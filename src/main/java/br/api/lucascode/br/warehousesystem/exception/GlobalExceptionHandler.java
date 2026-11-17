package br.api.lucascode.br.warehousesystem.exception;

import br.api.lucascode.br.warehousesystem.exception.exceptions.cliente.CpfIncorretoException;
import br.api.lucascode.br.warehousesystem.exception.exceptions.empresa.CnpjIncorretoException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CnpjIncorretoException.class)
    public ResponseEntity<ErroResponse> handleCnpjIncorreto(
            CnpjIncorretoException ex, HttpServletRequest request){

        ErroResponse erro = new ErroResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CpfIncorretoException.class)
    public ResponseEntity<ErroResponse> handleCpfIncorreto(
            CpfIncorretoException ex, HttpServletRequest request){

        ErroResponse erro = new ErroResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }
}
