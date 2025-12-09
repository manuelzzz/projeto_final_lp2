package br.ufrn;

import br.ufrn.Annotations.InfoAutor;
import br.ufrn.Estacionamento.Domain.Carro;
import br.ufrn.Estacionamento.Domain.Vaga;
import br.ufrn.Estacionamento.Repository.VagaRepository;

public class Main {

    public static void main(String[] args) {

        VagaRepository estacionamento = new VagaRepository();

        // Verifica se o tipo de estacionamento possui autor
        Class<?> classEstacionamento = estacionamento.getClass();
        if (classEstacionamento.isAnnotationPresent(InfoAutor.class)) {
            InfoAutor infoAutor = classEstacionamento.getAnnotation(InfoAutor.class);
            System.out.println("Autor da classe " + classEstacionamento.getSimpleName() + ": " + infoAutor.nome() + ", Data: " + infoAutor.data());
        }

        // Verifica se a classe vaga possui autor
        Class<?> classVaga = Vaga.class;
        if (classVaga.isAnnotationPresent(InfoAutor.class)) {
            InfoAutor infoAutor = classVaga.getAnnotation(InfoAutor.class);
            System.out.println("Autor da classe " + classVaga.getSimpleName() + ": " + infoAutor.nome() + ", Data: " + infoAutor.data());
        }

        Vaga vaga1 = new Vaga(1);
        Vaga vaga2 = new Vaga(2);
        Vaga vaga3 = new Vaga(3);
        Vaga vaga4 = new Vaga(4);
        Vaga vaga5 = new Vaga(5);
        Vaga vaga6 = new Vaga(6);

        Carro carro1 = new Carro("ABC-1234", "Toyota Corolla", "Prata");
        Carro carro2 = new Carro("DEF-5678", "Honda Civic", "Preto");
        Carro carro3 = new Carro("GHI-9012", "Ford Focus", "Branco");
        vaga1.ocuparVaga(carro1);
        vaga4.ocuparVaga(carro2);

        estacionamento.salvar(vaga3);
        estacionamento.salvar(vaga1);
        estacionamento.salvar(vaga5);
        estacionamento.salvar(vaga2);
        estacionamento.salvar(vaga4);
        estacionamento.salvar(vaga6);

        estacionamento.listarVagas();
        separator();

        estacionamento.estacionarCarro(carro3);
        estacionamento.listarVagas();
    }

    static private void separator() {
        System.out.println("--------------------------------------------------");
    }
}
