import entities.GerenciadorDeTarefas;
import entities.List;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<List> listaDeTarefas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("-----Sistema de Gerenciador de Tarefas-----");
        GerenciadorDeTarefas.adicionarTarefas(listaDeTarefas);
        int acao;

        while (true) {
            System.out.println("0 | Encerrar Programa \n1 | Adicionar Mais Tarefas \n2 | Remover Tarefa \n3 | Atualizar Tarefa \n4 | Exibir Tarefas");
            System.out.print("Escolha uma Opção Acima: ");
            try {
                acao = sc.nextInt();
                switch (acao) {
                    case 0:
                        System.out.println("👋 Encerrando o programa...");
                        System.exit(0);
                        break;
                    case 1:
                        GerenciadorDeTarefas.adicionarTarefas(listaDeTarefas);
                        break;
                    case 2:
                        GerenciadorDeTarefas.removerTarefas(listaDeTarefas);
                        break;
                    case 3:
                        GerenciadorDeTarefas.atualizarTarefa(listaDeTarefas);
                        break;
                    case 4:
                        GerenciadorDeTarefas.exibirTarefas(listaDeTarefas);
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Entrada inválida. Digite um número!");
                sc.nextLine();
            }

        }

    }
}