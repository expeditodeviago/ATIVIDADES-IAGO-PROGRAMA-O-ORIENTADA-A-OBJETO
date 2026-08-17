package atividade02_aluno;

/**
 * Classe que representa a Avaliacao Academica de um Aluno.
 * Demonstra o uso de Orientacao a Objetos, encapsulamento e construtor sem argumentos.
 */
public class AvaliacaoAluno {

    private String nomeAluno;
    private String materia;
    private String professor;
    private double nota1;
    private double nota2;
    private double nota3;

    /**
     * Construtor sem argumentos (padrao).
     * Inicializa os atributos com valores padrao.
     */
    public AvaliacaoAluno() {
        this.nomeAluno = "Nao informado";
        this.materia = "Nao informada";
        this.professor = "Nao informado";
        this.nota1 = 0.0;
        this.nota2 = 0.0;
        this.nota3 = 0.0;
    }

    // ==========================================
    // GETTERS E SETTERS (Encapsulamento)
    // ==========================================

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        if (nomeAluno != null && !nomeAluno.trim().isEmpty()) {
            this.nomeAluno = nomeAluno;
        }
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        if (materia != null && !materia.trim().isEmpty()) {
            this.materia = materia;
        }
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        if (professor != null && !professor.trim().isEmpty()) {
            this.professor = professor;
        }
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        if (validarNota(nota1)) {
            this.nota1 = nota1;
        }
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        if (validarNota(nota2)) {
            this.nota2 = nota2;
        }
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        if (validarNota(nota3)) {
            this.nota3 = nota3;
        }
    }

    /**
     * Define as tres notas de uma vez com validacao.
     */
    public void setNotas(double nota1, double nota2, double nota3) {
        setNota1(nota1);
        setNota2(nota2);
        setNota3(nota3);
    }

    // ==========================================
    // METODOS DE REGRA DE NEGOCIO
    // ==========================================

    /**
     * Valida se a nota esta no intervalo de 0.0 a 10.0.
     */
    private boolean validarNota(double nota) {
        return nota >= 0.0 && nota <= 10.0;
    }

    /**
     * Calcula a media aritmetica simples das tres notas.
     */
    public double calcularMedia() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    /**
     * Determina a situacao final do aluno com base na media.
     */
    public String verificarSituacao() {
        double media = calcularMedia();
        if (media >= 7.0) {
            return "Aprovado(a)";
        } else if (media >= 5.0) {
            return "Em Recuperacao";
        } else {
            return "Reprovado(a)";
        }
    }

    /**
     * Exibe o relatorio detalhado da avaliacao academica.
     */
    public void exibirRelatorio() {
        System.out.println("========================================");
        System.out.println("        FICHA DE AVALIACAO ESCOLAR       ");
        System.out.println("========================================");
        System.out.printf("Aluno(a)   : %s%n", nomeAluno);
        System.out.printf("Materia    : %s%n", materia);
        System.out.printf("Professor  : %s%n", professor);
        System.out.println("----------------------------------------");
        System.out.printf("Nota 1     : %.2f%n", nota1);
        System.out.printf("Nota 2     : %.2f%n", nota2);
        System.out.printf("Nota 3     : %.2f%n", nota3);
        System.out.printf("Media Final: %.2f%n", calcularMedia());
        System.out.printf("Situacao   : %s%n", verificarSituacao());
        System.out.println("========================================\n");
    }

    @Override
    public String toString() {
        return String.format("%s | Materia: %s | Prof: %s | Media: %.2f | %s",
                nomeAluno, materia, professor, calcularMedia(), verificarSituacao());
    }
}