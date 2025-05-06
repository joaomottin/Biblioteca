package controller;

import java.util.List;

import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class BibliotecaController {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    // Cadastro de Livro
    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    // Cadastro de Usuário
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    //Em construção...

}
