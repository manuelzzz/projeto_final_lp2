package br.ufrn.Estacionamento.Repository;

import br.ufrn.Abb.Domain.Arvore;
import br.ufrn.Estacionamento.Domain.Carro;
import br.ufrn.Estacionamento.Domain.Vaga;

public class VagaRepository implements GenericRepository<Vaga> {
    private Arvore<Vaga> arvore = new Arvore<>();

    @Override
    public void salvar(Vaga entity) {
        arvore.inserir(entity);
    }

    @Override
    public Vaga buscarPorId(int id) {
        return arvore.buscarPorId(id);
    }

    @Override
    public void deletar(int id) {
        Vaga vaga = buscarPorId(id);

        if (vaga != null) {
            arvore.remover(vaga);
        }
    }

    @Override
    public void atualizar(Vaga entity) {
        Vaga vagaExistente = buscarPorId(entity.getNumero());

        if (vagaExistente != null) {
            arvore.remover(vagaExistente);
            arvore.inserir(entity);
        }
    }

    public void listarVagas() {
        arvore.printarArvoreEmOrdem();
    }

    public void estacionarCarro(Carro carro) {
        Vaga vagaLivre = this.buscarVagaLivre();

        if (vagaLivre != null) {
            vagaLivre.ocuparVaga(carro);
            System.out.println("Carro estacionado na vaga número: " + vagaLivre.getNumero());
        } else {
            System.out.println("Não há vagas livres disponíveis.");
        }
    }

    private Vaga buscarVagaLivre() {
        for (Vaga vaga : arvore.emOrdemList()) {
            if (!vaga.isOcupada()) {
                return vaga;
            }
        }
        return null;
    }
}
