package br.ufrn.Abb.Domain;

public class Arvore<T extends Comparable<T>> {
    private No<T> raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void inserir(T data) {
        raiz = inserirRecursivo(raiz, data);
    }

    public boolean buscar(T data) {
        return buscaRecursiva(raiz, data);
    }

    public void remover(T data) {
        raiz = removerRecursivo(raiz, data);
    }

    private No<T> inserirRecursivo(No<T> no, T data) {
        if (no == null) {
            return new No<>(data);
        }

        if (data.compareTo(no.getValor()) < 0) {
            no.setEsquerda(inserirRecursivo(no.getEsquerda(), data));
        } else if (data.compareTo(no.getValor()) > 0) {
            no.setDireita(inserirRecursivo(no.getDireita(), data));
        }

        return no;
    }

    private boolean buscaRecursiva(No<T> no, T data) {
        if (no == null) return false;

        if (data.compareTo(no.getValor()) == 0) {
            return true;
        } else if (data.compareTo(no.getValor()) < 0) {
            return buscaRecursiva(no.getEsquerda(), data);
        } else {
            return buscaRecursiva(no.getDireita(), data);
        }
    }

    private No<T> removerRecursivo(No<T> no, T data) {
        if (no == null) {
            return null;
        }

        int cmp = data.compareTo(no.getValor());

        if (cmp < 0) {
            no.setEsquerda(removerRecursivo(no.getEsquerda(), data));
        } else if (cmp > 0) {
            no.setDireita(removerRecursivo(no.getDireita(), data));
        } else {

            if (no.getEsquerda() == null && no.getDireita() == null) {
                return null;
            }

            if (no.getEsquerda() == null) {
                return no.getDireita();
            }
            if (no.getDireita() == null) {
                return no.getEsquerda();
            }

            No<T> sucessor = menorNo(no.getDireita());
            no.setValor(sucessor.getValor());
            no.setDireita(removerRecursivo(no.getDireita(), sucessor.getValor()));
        }

        return no;
    }

    private No<T> menorNo(No<T> no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }
}
