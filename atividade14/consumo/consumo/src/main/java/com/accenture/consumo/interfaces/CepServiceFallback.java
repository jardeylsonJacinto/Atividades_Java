package com.accenture.consumo.interfaces;

import com.accenture.consumo.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class CepServiceFallback implements CepService {

    @Override
    public Endereco buscaEnderecoPorCep(String cep) {
        return new Endereco();
    }
}
