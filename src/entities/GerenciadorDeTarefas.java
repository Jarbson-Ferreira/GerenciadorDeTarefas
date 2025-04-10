package entities;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GerenciadorDeTarefas {

    public static void adicionarTarefas(ArrayList<List> listaDeTarefas) {
        Scanner sc = new Scanner(System.in);
        int quantidade = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Quantas tarefas você deseja adicionar?: ");
                quantidade = sc.nextInt();
                if (quantidade <= 0) {
                    System.out.println("Nenhuma tarefa foi adicionada!");
                }
                sc.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Digite um Número Válido!.");
                sc.nextLine();
            }
        }
        for (int i = 0; i < quantidade; i++) {
            int novoId = listaDeTarefas.size();
            System.out.println("Tarefa #" + (novoId + 1));
            System.out.print("Título da Tarefa: ");
            String nome = sc.nextLine();

            System.out.print("Descrição da Tarefa: ");
            String descricao = sc.nextLine();

            List novaTarefa = new List(novoId + 1, nome, descricao, false);
            listaDeTarefas.add(novaTarefa);
            System.out.println("✅ Tarefas adicionada com sucesso!");
        }
    }

    public static void removerTarefas(ArrayList<List> listaDeTarefas) {
        Scanner sc = new Scanner(System.in);
        int idDaTarefa;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Digite o ID da Tarefa que deseja remover: ");
                idDaTarefa = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < listaDeTarefas.size(); i++) {
                    if (listaDeTarefas.get(i).id == idDaTarefa) {
                        listaDeTarefas.remove(i);
                        System.out.println("✅ Tarefa removida com sucesso!");
                        break;
                    } else {
                        System.out.println("⚠️ Nenhuma tarefa encontrada com esse ID.");
                    }
                }
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Digite um Número Válido!.");
            }
        }
    }

    public static void atualizarTarefa(ArrayList<List> listaDeTarefas) {
        Scanner sc = new Scanner(System.in);
        int idDaTarefa;

        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Digite o ID da Tarefa que deseja atualizar: ");
            try {
                idDaTarefa = sc.nextInt();
                sc.nextLine();
                for (List listaDeTarefa : listaDeTarefas) {
                    if (listaDeTarefa.id == idDaTarefa) {
                        String novoTitulo, novaDescricao, novoEstado;
                        System.out.println("1 | Atualizar Título \n2 | Atualizar Descrição \n3 | Atualizar Estado");
                        System.out.print("Escolha um Opção: ");
                        int opcao = sc.nextInt();
                        sc.nextLine();
                        switch (opcao) {
                            case 1:
                                System.out.print("Novo Título: ");
                                novoTitulo = sc.nextLine();
                                listaDeTarefa.nome = novoTitulo;
                                System.out.println("Título atualizado com sucesso!");
                                break;
                            case 2:
                                System.out.print("Nova Descrição: ");
                                novaDescricao = sc.nextLine();
                                listaDeTarefa.descricao = novaDescricao;
                                System.out.println("Descrição atualizado com sucesso!");
                                break;
                            case 3:
                                System.out.print("Tarefa Conluída? (S/N)");
                                novoEstado = sc.nextLine().toLowerCase();
                                if (novoEstado.equals("s")) {
                                    listaDeTarefa.concluido = true;
                                }
                                System.out.println("Estado atualizado com sucesso!");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                        }
                        entradaValida = true;
                        break;
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println("Digite um ID válido!");
            }
        }
    }

    public static void exibirTarefas(ArrayList<List> listaDeTarefas) {
        for (List lista : listaDeTarefas) {
            System.out.println("ID: " + lista.id + " | Nome: " + lista.nome + " | Descrição: " + lista.descricao + " | Conclúida: " + (lista.concluido ? "✅" : "❌"));
        }
    }
}
