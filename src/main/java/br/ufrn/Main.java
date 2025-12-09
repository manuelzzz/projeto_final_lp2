package br.ufrn;

import br.ufrn.Estacionamento.Domain.Carro;
import br.ufrn.Estacionamento.Domain.Vaga;
import br.ufrn.Estacionamento.Repository.VagaRepository;

public class Main {
    public static void main(String[] args) {
        VagaRepository repository = new VagaRepository();

        Vaga vaga1 = new Vaga(1);
        Carro carro1 = new Carro("ABC-1234", "Toyota Corolla", "Prata");
        vaga1.ocuparVaga(carro1);
        repository.salvar(vaga1);

        Vaga vaga2 = new Vaga(2);
        Carro carro2 = new Carro("XYZ-5678", "Honda Civic", "Preto");
        vaga2.ocuparVaga(carro2);
        repository.salvar(vaga2);

        repository.listarVagas();
    }
}