package br.com.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VeiculoDTO(

        @JsonAlias("Valor")
        String valor,

        @JsonAlias("Marca")
        String marca,

        @JsonAlias("Modelo")
        String modelo,

        @JsonAlias("AnoModelo")
        Integer ano,

        @JsonAlias("Combustivel")
        String tipoCombustivel

) {
}
