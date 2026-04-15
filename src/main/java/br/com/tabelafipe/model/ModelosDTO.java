package br.com.tabelafipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ModelosDTO(
        List<DadosDTO> modelos
) {
}
