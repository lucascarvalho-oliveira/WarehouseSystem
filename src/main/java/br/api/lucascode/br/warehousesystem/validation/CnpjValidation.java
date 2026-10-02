package br.api.lucascode.br.warehousesystem.validation;

import br.api.lucascode.br.warehousesystem.exception.Exceptions.CnpjIncorretoException;
import org.springframework.stereotype.Component;

@Component
public class CnpjValidation {

    public boolean ComfirmarCnpj (String cnpj){
        if(cnpj == null || !ehValido(cnpj.replaceAll("\\D", ""))){
            throw new CnpjIncorretoException("CNPJ inválido");
        }
        return true;
    }

    private boolean ehValido(String cnpj){
        return cnpj.length() == 14 && validarRepeticao(cnpj) && digitos(cnpj);
    }

    private boolean validarRepeticao(String cnpj){
        boolean ehIguais = true;

        for(int i = 1; i < cnpj.length(); i++){
            if(cnpj.charAt(0) != cnpj.charAt(i)){
                ehIguais = false;
                break;
            }
        }
        return !ehIguais;
    }

    private boolean digitos(String cnpj){
        int[] peso_1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] peso_2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int primeiroDigito = validarDigito(cnpj.substring(0, 12), peso_1);
        int segundoDigito = validarDigito(cnpj.substring(0, 13), peso_2);

        return primeiroDigito == cnpj.charAt(12) - '0' && segundoDigito == cnpj.charAt(13) - '0';
    }

    private int validarDigito(String cnpj, int[] peso){
        int soma = 0;

        for(int i = 0; i < cnpj.length(); i++){
            int numero = cnpj.charAt(i) - '0';
            soma += numero * peso[i];
        }

        int restoDivisao = soma % 11;

        if(restoDivisao < 2){
            return 0;
        }else{
            return 11 - restoDivisao;
        }
    }
}
