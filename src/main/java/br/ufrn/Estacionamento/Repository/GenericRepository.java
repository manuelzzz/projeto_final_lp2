package br.ufrn.Estacionamento.Repository;

public interface GenericRepository<T extends Comparable<T>> {
    void salvar(T entity);

    T buscarPorId(int id);

    void deletar(int id);

    void atualizar(T entity);
}
