package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class BibliotecaController {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public void registrarEmprestimo(int livroId, String emailUsuario, int diasDeEmprestimo) {
        Livro livro = livros.stream().filter(l -> l.getId() == livroId).findFirst().orElse(null);
        Usuario usuario = usuarios.stream().filter(u -> u.getEmail().equalsIgnoreCase(emailUsuario)).findFirst().orElse(null);

        if (livro == null || usuario == null || livro.getExemplares() <= 0) {
            System.out.println("Erro: livro ou usuário não encontrado, ou sem exemplares disponíveis.");
            return;
        }

        LocalDate hoje = LocalDate.now();
        LocalDate devolucao = hoje.plusDays(diasDeEmprestimo);

        Emprestimo emprestimo = new Emprestimo(livro, usuario, hoje, devolucao, null, false);
        emprestimos.add(emprestimo);
        livro.setExemplares(livro.getExemplares() - 1);

        System.out.println("Empréstimo registrado com sucesso!");
    }

    public void registrarDevolucao(Emprestimo emprestimo, LocalDate dataDevolucao) {
        emprestimo.setDataDevolucaoReal(dataDevolucao);
        emprestimo.setAtrasado(dataDevolucao.isAfter(emprestimo.getDataDevolucaoPrevista()));

        Livro livro = emprestimo.getLivro();
        livro.setExemplares(livro.getExemplares() + 1);

        System.out.println("Devolução registrada com sucesso!");
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public List<Emprestimo> listarEmprestimosPorUsuario(String email) {
        return emprestimos.stream()
                .filter(e -> e.getUsuario().getEmail().equalsIgnoreCase(email))
                .collect(Collectors.toList());
    }

    public List<Emprestimo> listarEmprestimosAtrasados() {
        return emprestimos.stream().filter(Emprestimo::isAtrasado).collect(Collectors.toList());
    }
}
