import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jogo> listaJogos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("========== SISTEMA DE GERENCIAMENTO ==========");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Opção inválida! Digite um número.");
                scanner.nextLine();
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do jogo: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    boolean idExiste = false;
                    for (Jogo j : listaJogos) {
                        if (j.getId() == id) {
                            idExiste = true;
                            break;
                        }
                    }

                    if (idExiste) {
                        System.out.println("Erro: Já existe um jogo cadastrado com esse ID!");
                    } else {
                        System.out.print("Digite o nome do jogo: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o gênero do jogo: ");
                        String genero = scanner.nextLine();

                        Jogo novoJogo = new Jogo(id, nome, genero);
                        listaJogos.add(novoJogo);
                        System.out.println("Jogo cadastrado com sucesso!");
                    }
                    break;

                case 2:
                    if (listaJogos.isEmpty()) {
                        System.out.println("Não há registros cadastrados.");
                    } else {
                        System.out.println("--- LISTA DE JOGOS ---");
                        for (Jogo j : listaJogos) {
                            System.out.println("ID: " + j.getId() + " | Nome: " + j.getNome() + " | Gênero: " + j.getGenero());
                        }
                    }
                    break;

                case 3:
                    if (listaJogos.isEmpty()) {
                        System.out.println("Não há registros cadastrados.");
                    } else {
                        System.out.print("Digite o ID que deseja buscar: ");
                        int buscaId = scanner.nextInt();
                        scanner.nextLine();

                        Jogo jogoEncontrado = null;
                        for (Jogo j : listaJogos) {
                            if (j.getId() == buscaId) {
                                jogoEncontrado = j;
                                break;
                            }
                        }

                        if (jogoEncontrado != null) {
                            System.out.println("Jogo encontrado:");
                            System.out.println("ID: " + jogoEncontrado.getId() + " | Nome: " + jogoEncontrado.getNome() + " | Gênero: " + jogoEncontrado.getGenero());
                        } else {
                            System.out.println("ID não existe.");
                        }
                    }
                    break;

                case 4:
                    if (listaJogos.isEmpty()) {
                        System.out.println("Não há registros cadastrados.");
                    } else {
                        System.out.print("Digite o ID do jogo que deseja atualizar: ");
                        int atualizaId = scanner.nextInt();
                        scanner.nextLine();

                        Jogo jogoAtualizar = null;
                        for (Jogo j : listaJogos) {
                            if (j.getId() == atualizaId) {
                                jogoAtualizar = j;
                                break;
                            }
                        }

                        if (jogoAtualizar != null) {
                            System.out.print("Digite o novo nome: ");
                            String novoNome = scanner.nextLine();
                            System.out.print("Digite o novo gênero: ");
                            String novoGenero = scanner.nextLine();

                            jogoAtualizar.setNome(novoNome);
                            jogoAtualizar.setGenero(novoGenero);
                            System.out.println("Registro atualizado com sucesso!");
                        } else {
                            System.out.println("ID não existe.");
                        }
                    }
                    break;

                case 5:
                    if (listaJogos.isEmpty()) {
                        System.out.println("Não há registros cadastrados.");
                    } else {
                        System.out.print("Digite o ID do jogo que deseja excluir: ");
                        int excluiId = scanner.nextInt();
                        scanner.nextLine();

                        Jogo jogoExcluir = null;
                        for (Jogo j : listaJogos) {
                            if (j.getId() == excluiId) {
                                jogoExcluir = j;
                                break;
                            }
                        }

                        if (jogoExcluir != null) {
                            listaJogos.remove(jogoExcluir);
                            System.out.println("Registro excluído com sucesso!");
                        } else {
                            System.out.println("ID não existe.");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
}
