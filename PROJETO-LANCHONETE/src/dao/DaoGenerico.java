package dao;

import model.Funcionario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

public interface DaoGenerico<T> {
    public boolean Salvar(T e) throws IOException, ClassNotFoundException,
            FileNotFoundException;
    public boolean Deletar( T e) throws IOException, ClassNotFoundException,
            FileNotFoundException;
    public  T Buscar(String id) throws IOException, ClassNotFoundException,
            FileNotFoundException;
    public boolean Editar(String id, T elemento) throws IOException, ClassNotFoundException,
            FileNotFoundException;

    boolean Deletar(Funcionario funcionario) throws IOException, ClassNotFoundException;

    public Set<Funcionario> Listar() throws IOException, ClassNotFoundException,
            FileNotFoundException;

}
