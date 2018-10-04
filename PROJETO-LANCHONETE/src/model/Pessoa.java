package model;

import java.io.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * A classe <b>Pessoa</b> modela a entidade <b>Pessoa</b> do domínio da aplicação
 * A classe <b>Pessoa</b> é uma generalização
 * @author RaulRomulo
 * @since 1.0
 * @version 1.0
 */
public class Pessoa implements Serializable {



    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private String email;
    private String telefone;

    /**
     *Atributos da entidade generalizada <b>Pessoa</b>
     * @param nome indica o nome do usuário
     * @param cpf indica o cpf do usuário
     * @param nascimento indica a data de nascimento do usuário
     * @param email indica o email do usuário
     * @param telefone indica o numero do telefone do usuário
     */
    public Pessoa(String nome, String cpf, LocalDate nascimento, String email, String telefone ) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.email = email;
        this.telefone = telefone;
    }

    /**
     * get e set da classe Pessoa
     * @return aponta e retorna os atributos da classse
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    /**
     * metodo toString que é uma representação textual da classe
     *
     */
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getCpf(), pessoa.getCpf()) &&
                Objects.equals(getEmail(), pessoa.getEmail());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCpf(), getEmail());
    }
}

