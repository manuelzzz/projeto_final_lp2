package br.ufrn.Estacionamento.Repository;

import br.ufrn.Abb.Domain.Arvore;
import br.ufrn.Estacionamento.Domain.Vaga;

public class EstacionamentoRepository implements GenericRepository<Vaga> {
    private Arvore<Vaga> arvore = new Arvore<>();

    public void listarVagas() {
        arvore.emOrdem();
    }

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
}
