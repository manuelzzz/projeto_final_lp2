package br.ufrn.Estacionamento.Domain;

public class Vaga implements Comparable<Vaga> {
    private int numero;
    private boolean ocupada;
    private Carro carro;

    public Vaga(int numero) {
        this.numero = numero;
        this.ocupada = false;
        this.carro = null;
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
}
