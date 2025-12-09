package br.ufrn;

import br.ufrn.Estacionamento.Domain.Carro;
import br.ufrn.Estacionamento.Domain.Vaga;
import br.ufrn.Estacionamento.Repository.EstacionamentoRepository;
import br.ufrn.Estacionamento.Repository.GenericRepository;

public class Main {
    public static void main(String[] args) {
        GenericRepository<Vaga> repository = new EstacionamentoRepository();

        Vaga vaga1 = new Vaga(1);
        repository.salvar(vaga1);
        Carro carro1 = new Carro("ABC-1234", "Toyota Corolla", "Prata");
        vaga1.ocuparVaga(carro1);
    }
}