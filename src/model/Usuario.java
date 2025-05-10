package model;

import java.util.List;

public class Usuario implements Bibliotecavel{
    private String nome, endereco, email;
    private String telefone;
    private List<Emprestimo> emprestimos;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String getDescricao() {
        return "Usuário: " + nome + " - Email: " + email;
    }

    @Override
    public String toString() {
        return "Usuarios [nome=" + nome + ", endereco=" + endereco + ", email=" + email + ", telefone=" + telefone
                + "]";
    }

    
}
