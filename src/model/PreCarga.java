package model;

import controller.LivroController;
import controller.UsuarioController;
import model.Livro;
import model.Usuario;

public class PreCarga {
    public static void carregarLivros(LivroController lc) {
        lc.cadastrarLivro(new Livro(1, "1984", "George Orwell", "Distopia", 5, 1949));
        lc.cadastrarLivro(new Livro(2, "O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", 3, 1954));
    }
    public static void carregarUsuarios(UsuarioController uc) {
        uc.cadastrarUsuario(new Usuario("Joãozinho", "Rua XV", "joaozinho@gmail.com", "41997473031"));
        uc.cadastrarUsuario(new Usuario("Mariazinha", "Rua Fernando Torres", "mariazinha@gmail.com", "41984724817"));
    }
}
