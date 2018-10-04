package dao;

import model.Funcionario;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FuncionarioDao implements DaoGenerico <Funcionario> {
    private File file;

    public FuncionarioDao() throws IOException {
        file = new File("Funcionario");
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public Set<Funcionario> getFuncionarios() throws IOException, ClassNotFoundException {
        if (file.length() > 0) {
            try (ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(file))) {
                return (Set<Funcionario>) in.readObject();
            }
        } else {
            return new HashSet<>();
        }
    }

    public void atualizarArquivo(Set<Funcionario> funcionarios) throws IOException {
        try (ObjectOutput out = new ObjectOutputStream(
                new FileOutputStream(file))) {
            out.writeObject(funcionarios);
        }

    }
    @Override
    public boolean Salvar(Funcionario funcionario) throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionarios = getFuncionarios();
        if (funcionarios.add(funcionario)) {
            atualizarArquivo(funcionarios);
            return true;
        } else return false;
    }

    @Override
    public boolean Deletar(Funcionario funcionario) throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionarios = getFuncionarios();
        if (funcionarios.remove(funcionario)){
            atualizarArquivo(funcionarios);
            return true;
        }
        else return false;
    }
    @Override
    public Set<Funcionario> Listar() throws IOException, ClassNotFoundException,
            FileNotFoundException {

        if (file.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

            return (Set<Funcionario>) in.readObject();

        } else {
            return getFuncionarios();
        }
    }
    @Override
    public Funcionario Buscar(String email) throws IOException, ClassNotFoundException,
            FileNotFoundException {

        Set<Funcionario> funcionarios = Listar();

        for (Funcionario funcionario : funcionarios) {
            if (email.equals(funcionario.getEmail())) {
                return funcionario;
            }
        }
        return null;
    }
    @Override
    public boolean Editar(String email, Funcionario funcionario) throws IOException, ClassNotFoundException {
        if (Buscar(email) != null) {
            Deletar(funcionario);
            return Salvar(funcionario);
        }
        return false;
    }

    public boolean Autenticar(String email, String senha) throws IOException, ClassNotFoundException {
        Funcionario funcionario = Buscar(email);
        if (funcionario != null) {
            if (funcionario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }

}
