package br.ufrn.Abb.Domain;

public class No<T extends Comparable<T>> {
    private T valor;
    private No<T> esquerda;
    private No<T> direita;

    public No() {
        this.valor = null;
        this.esquerda = null;
        this.direita = null;
    }

    public No(T valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    T getValor() {
        return valor;
    }

    void setValor(T valor) {
        this.valor = valor;
    }

    No<T> getEsquerda() {
        return esquerda;
    }

    void setEsquerda(No<T> esquerda) {
        this.esquerda = esquerda;
    }

    No<T> getDireita() {
        return direita;
    }

    void setDireita(No<T> direita) {
        this.direita = direita;
    }
}
