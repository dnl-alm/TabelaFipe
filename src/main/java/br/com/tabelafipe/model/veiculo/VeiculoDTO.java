package br.com.tabelafipe.model.veiculo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VeiculoDTO(

        String tipoVeiculo,
        String valor,
        String marca,
        String modelo,
        String anoModelo,
        String combustivel,
        String codigoFipe,
        String mesReferencia,
        String siglaCombustivel

) {
}
