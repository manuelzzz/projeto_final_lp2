package br.ufrn.Estacionamento.Domain;

import br.ufrn.Annotations.InfoAutor;

@InfoAutor(nome = "Richard Matheus", data = "09-12-2025")
public class Vaga implements Comparable<Vaga> {

    private int numero;
    private boolean ocupada;
    private Carro carro;

    public Vaga(int numero) {
        this.numero = numero;
        this.ocupada = false;
        this.carro = null;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void ocuparVaga(Carro carro) {
        if (this.ocupada) {
            throw new IllegalStateException("Vaga já está ocupada.");
        }

        this.ocupada = true;
        this.carro = carro;
    }

    @Override
    public int compareTo(Vaga o) {
        return Integer.compare(this.numero, o.numero);
    }

    public void liberarVaga() {
        if (!this.ocupada) {
            throw new IllegalStateException("Vaga já está livre.");
        }

        this.ocupada = false;
        this.carro = null;
    }

    @Override
    public String toString() {
        return "Vaga { " + "numero = " + numero + ", ocupada = " + ocupada + ", carro = " + (carro != null ? carro.getPlaca() : "Nenhum") + " }";
    }
}
