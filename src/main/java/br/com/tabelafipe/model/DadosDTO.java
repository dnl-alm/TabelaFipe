package br.com.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosDTO(
        Integer codigo,
        String nome
) {
}
