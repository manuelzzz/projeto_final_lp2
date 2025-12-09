package br.ufrn.Estacionamento.Repository;

import br.ufrn.Abb.Domain.Arvore;

public class EstacionamentoRepository<Vaga> implements GenericRepository<Vaga> {
    private Arvore<Vaga> arvore;

    @Override
    public void salvar(Vaga entity) {
    }

    @Override
    public Vaga buscarPorId(int id) {
        return null;
    }

    @Override
    public void deletar(int id) {
    }

    @Override
    public void atualizar(Vaga entity) {
    }
}
