package br.com.tabelafipe.model.veiculo;

public class Veiculo {

    private TipoVeiculo tipoVeiculo;
    private Double valor;
    private String marca;
    private String modelo;
    private Integer anoModelo;
    private String combustivel;
    private String codigoFipe;
    private String mesReferencia;
    private String siglaCombustivel;

    public Veiculo() {
    }

    public Veiculo(TipoVeiculo tipoVeiculo, Double valor, String marca, String modelo, Integer anoModelo, String combustivel, String codigoFipe, String mesReferencia, String siglaCombustivel) {
        this.tipoVeiculo = tipoVeiculo;
        this.valor = valor;
        this.marca = marca;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.combustivel = combustivel;
        this.codigoFipe = codigoFipe;
        this.mesReferencia = mesReferencia;
        this.siglaCombustivel = siglaCombustivel;
    }

    public Veiculo(VeiculoDTO veiculoDTO) {
        try{
            this.tipoVeiculo = TipoVeiculo.fromCodigo(Integer.valueOf(veiculoDTO.tipoVeiculo()));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            this.valor = Double.valueOf(veiculoDTO.valor());
        } catch (NumberFormatException ex) {
            this.valor = 0.0;
        }

        this.marca = veiculoDTO.marca();
        this.modelo = veiculoDTO.modelo();


        try {
            this.anoModelo = Integer.valueOf(veiculoDTO.anoModelo());
        } catch (NumberFormatException ex) {
            this.anoModelo = 0;
        }

        this.combustivel = veiculoDTO.combustivel();
        this.codigoFipe = veiculoDTO.codigoFipe();
        this.mesReferencia = veiculoDTO.mesReferencia();
        this.siglaCombustivel = veiculoDTO.siglaCombustivel();
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getSiglaCombustivel() {
        return siglaCombustivel;
    }

    public void setSiglaCombustivel(String siglaCombustivel) {
        this.siglaCombustivel = siglaCombustivel;
    }
}
