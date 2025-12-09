package br.ufrn.Estacionamento.Domain;

public class Carro {
    private String placa;
    private String modelo;
    private String cor;

    public Carro() {
        this.placa = "";
        this.modelo = "";
        this.cor = "";
    }

    public Carro(String placa, String modelo, String cor) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
