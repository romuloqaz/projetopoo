package view;

import dao.FuncionarioDao;
import model.Funcionario;

import java.io.IOException;
import java.time.LocalDate;

public class App2 {
    public static void main(String[] args) {
       try {
           FuncionarioDao dao = new FuncionarioDao();
           System.out.println(dao.Salvar(new Funcionario("joao","111-111-111-01",LocalDate.now(),"joaozinho","123","190",Funcionario.Setor.ATENDIMENTO)));
           System.out.println(dao.Salvar(new Funcionario("maria","111-111-111-02",LocalDate.now(),"mariazinha","123","192",Funcionario.Setor.ATENDIMENTO)));
           System.out.println(dao.Buscar("joaozinho"));
           System.out.println(dao.getFuncionarios());
           System.out.println(dao.Buscar("mariazinha"));
           System.out.println(dao.getFuncionarios());
           System.out.println(dao.Deletar(new Funcionario("joao","111-111-111-01",LocalDate.now(),"joaozinho","123","190",Funcionario.Setor.ATENDIMENTO)));
           System.out.println(dao.getFuncionarios());

       } catch (IOException|ClassNotFoundException e) {
           e.printStackTrace();
       }
    }
}
