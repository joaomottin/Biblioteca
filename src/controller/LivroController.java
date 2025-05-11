package controller;

import model.Livro;
import java.util.*;
import java.util.stream.Collectors;
import model.PreCarga;

public class LivroController {
    private final Map<Integer, Livro> livros = new HashMap<>();

    public void cadastrarLivro(Livro l) {
        livros.put(l.getId(), l);
    }

    public LivroController() {
        PreCarga.carregarLivros(this);
    }

    public Collection<Livro> listarLivros() {
        return livros.values();
    }

    public List<Livro> pesquisarPor(String termo, String tipo) {
        return livros.values().stream()
            .filter(l -> switch(tipo) {
                case "id" -> Integer.toString(l.getId()).equals(termo);
                case "titulo" -> l.getTitulo().equalsIgnoreCase(termo);
                case "autor" -> l.getAutor().equalsIgnoreCase(termo);
                case "categoria" -> l.getCategoria().equalsIgnoreCase(termo);
                default -> false;
            })
            .collect(Collectors.toList());
    }

    public Livro getLivro(int id) {
        return livros.get(id);
    }
}