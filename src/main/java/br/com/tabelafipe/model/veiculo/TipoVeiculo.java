package br.com.tabelafipe.model.veiculo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoVeiculo {

    CARRO(1, "Carro"),
    MOTO(2, "Moto"),
    CAMINHAO(3, "Caminhão");

    private int codigo;
    private String descricao;

    TipoVeiculo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @JsonValue
    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    @JsonCreator
    public static TipoVeiculo fromCodigo(int codigo) {
        for (TipoVeiculo tipo : TipoVeiculo.values()) {
            if (tipo.codigo == codigo) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}