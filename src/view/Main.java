// faz a main
package view;

import controller.BibliotecaController;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Listar Livros");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Registrar Empréstimo");
            System.out.println("6. Registrar Devolução");
            System.out.println("7. Listar Empréstimos");
            System.out.println("8. Listar Empréstimos por Usuário");
            System.out.println("9. Listar Empréstimos Atrasados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Quantidade de exemplares: ");
                    int exemplares = scanner.nextInt();
                    System.out.print("Ano de publicação: ");
                    int ano = scanner.nextInt();

                    Livro livro = new Livro(titulo, autor, categoria, id, exemplares, ano);
                    controller.cadastrarLivro(livro);
                }

                case 2 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    int telefone = scanner.nextInt();

                    Usuario usuario = new Usuario();
                    usuario.setNome(nome);
                    usuario.setEndereco(endereco);
                    usuario.setEmail(email);
                    usuario.setTelefone(telefone);
                    controller.cadastrarUsuario(usuario);
                }

                case 3 -> controller.listarLivros().forEach(System.out::println);

                case 4 -> controller.listarUsuarios().forEach(System.out::println);

                case 5 -> {
                    System.out.print("ID do livro: ");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Email do usuário: ");
                    String email = scanner.nextLine();
                    System.out.print("Dias para devolução: ");
                    int dias = scanner.nextInt();
                    controller.registrarEmprestimo(idLivro, email, dias);
                }

                case 6 -> {
                    System.out.print("Email do usuário para devolução: ");
                    String emailDev = scanner.nextLine();
                    List<Emprestimo> emprestimos = controller.listarEmprestimosPorUsuario(emailDev);
                    if (emprestimos.isEmpty()) {
                        System.out.println("Nenhum empréstimo encontrado.");
                        break;
                    }

                    for (int i = 0; i < emprestimos.size(); i++) {
                        System.out.println((i + 1) + " - " + emprestimos.get(i));
                    }

                    System.out.print("Escolha o número do empréstimo a devolver: ");
                    int escolha = scanner.nextInt();
                    if (escolha >= 1 && escolha <= emprestimos.size()) {
                        controller.registrarDevolucao(emprestimos.get(escolha - 1), LocalDate.now());
                    }
                }

                case 7 -> controller.listarEmprestimos().forEach(System.out::println);

                case 8 -> {
                    System.out.print("Email do usuário: ");
                    String email = scanner.nextLine();
                    controller.listarEmprestimosPorUsuario(email).forEach(System.out::println);
                }

                case 9 -> controller.listarEmprestimosAtrasados().forEach(System.out::println);

                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
