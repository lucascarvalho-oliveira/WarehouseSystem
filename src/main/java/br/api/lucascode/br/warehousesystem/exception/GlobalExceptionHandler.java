package br.api.lucascode.br.warehousesystem.exception;

import br.api.lucascode.br.warehousesystem.exception.Exceptions.CnpjIncorretoException;
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
}
