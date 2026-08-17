package atividade02_aluno;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== ATIVIDADE 02: ORIENTACAO A OBJETOS COM CONSTRUTOR SEM ARGUMENTOS ===\n");

        // 1. Instanciando o objeto usando o CONSTRUTOR SEM ARGUMENTOS
        AvaliacaoAluno avaliacao1 = new AvaliacaoAluno();

        System.out.println("-> Objeto recem-criado com valores padrao do construtor sem argumentos:");
        System.out.println(avaliacao1);
        System.out.println();

        // 2. Preenchendo os dados solicitados na atividade atraves dos metodos setters
        avaliacao1.setNomeAluno("Iago Expedito");
        avaliacao1.setMateria("Programacao Orientada a Objetos");
        avaliacao1.setProfessor("Prof. Carlos Eduardo");
        avaliacao1.setNotas(8.5, 9.0, 7.5);

        // 3. Exibindo o relatorio completo
        System.out.println("-> Dados preenchidos para a Avaliacao 1:");
        avaliacao1.exibirRelatorio();

        // 4. Instanciando um segundo objeto com construtor sem argumentos
        AvaliacaoAluno avaliacao2 = new AvaliacaoAluno();
        avaliacao2.setNomeAluno("Maria Clara");
        avaliacao2.setMateria("Estrutura de Dados");
        avaliacao2.setProfessor("Profa. Juliana Santos");
        avaliacao2.setNota1(6.0);
        avaliacao2.setNota2(5.5);
        avaliacao2.setNota3(6.5);

        System.out.println("-> Dados preenchidos para a Avaliacao 2:");
        avaliacao2.exibirRelatorio();
    }
}