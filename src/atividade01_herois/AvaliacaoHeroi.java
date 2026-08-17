package atividade01_herois;

public class AvaliacaoHeroi {

    private String nomeHeroi;
    private String universoOuClasse;
    private double notaPoderCombate;
    private double notaEstrategia;
    private double notaTrabalhoEquipe;
    private double notaCarisma;

    public static final double NOTA_MAXIMA = 10.0;
    public static final double NOTA_MINIMA = 0.0;

    public AvaliacaoHeroi() {
        this("Herói Anônimo", "Desconhecido", 0.0, 0.0, 0.0, 0.0);
    }

    public AvaliacaoHeroi(String nomeHeroi) {
        this(nomeHeroi, "Multiverso Nerd", 0.0, 0.0, 0.0, 0.0);
    }

    public AvaliacaoHeroi(String nomeHeroi, String universoOuClasse) {
        this(nomeHeroi, universoOuClasse, 0.0, 0.0, 0.0, 0.0);
    }

    public AvaliacaoHeroi(String nomeHeroi, String universoOuClasse, double notaPoderCombate, double notaEstrategia) {
        this(nomeHeroi, universoOuClasse, notaPoderCombate, notaEstrategia, 5.0, 5.0);
    }

    public AvaliacaoHeroi(String nomeHeroi, String universoOuClasse, double notaPoderCombate, 
                          double notaEstrategia, double notaTrabalhoEquipe, double notaCarisma) {
        this.nomeHeroi = nomeHeroi;
        this.universoOuClasse = universoOuClasse;
        setNotaPoderCombate(notaPoderCombate);
        setNotaEstrategia(notaEstrategia);
        setNotaTrabalhoEquipe(notaTrabalhoEquipe);
        setNotaCarisma(notaCarisma);
    }

    public AvaliacaoHeroi(AvaliacaoHeroi outroHeroi) {
        if (outroHeroi != null) {
            this.nomeHeroi = outroHeroi.nomeHeroi + " (Cópia)";
            this.universoOuClasse = outroHeroi.universoOuClasse;
            this.notaPoderCombate = outroHeroi.notaPoderCombate;
            this.notaEstrategia = outroHeroi.notaEstrategia;
            this.notaTrabalhoEquipe = outroHeroi.notaTrabalhoEquipe;
            this.notaCarisma = outroHeroi.notaCarisma;
        }
    }

    public double calcularMediaSimples() {
        return (notaPoderCombate + notaEstrategia + notaTrabalhoEquipe + notaCarisma) / 4.0;
    }

    public double calcularMediaPonderada(double pesoCombate, double pesoEstrategia, double pesoEquipe, double pesoCarisma) {
        double somaPesos = pesoCombate + pesoEstrategia + pesoEquipe + pesoCarisma;
        if (somaPesos <= 0) return 0.0;
        
        double somaPonderada = (notaPoderCombate * pesoCombate) 
                             + (notaEstrategia * pesoEstrategia) 
                             + (notaTrabalhoEquipe * pesoEquipe) 
                             + (notaCarisma * pesoCarisma);
        
        return somaPonderada / somaPesos;
    }

    public double calcularSomaPontos() {
        return notaPoderCombate + notaEstrategia + notaTrabalhoEquipe + notaCarisma;
    }

    public double buscarMaiorNota() {
        double maior = notaPoderCombate;
        if (notaEstrategia > maior) maior = notaEstrategia;
        if (notaTrabalhoEquipe > maior) maior = notaTrabalhoEquipe;
        if (notaCarisma > maior) maior = notaCarisma;
        return maior;
    }

    public double buscarMenorNota() {
        double menor = notaPoderCombate;
        if (notaEstrategia < menor) menor = notaEstrategia;
        if (notaTrabalhoEquipe < menor) menor = notaTrabalhoEquipe;
        if (notaCarisma < menor) menor = notaCarisma;
        return menor;
    }

    public boolean estaAprovadoParaMissao() {
        return calcularMediaSimples() >= 7.0;
    }

    public boolean ehNivelOmega() {
        return calcularMediaSimples() >= 9.0;
    }

    public boolean precisaTreinamento() {
        return notaPoderCombate < 5.0 || notaEstrategia < 5.0 
            || notaTrabalhoEquipe < 5.0 || notaCarisma < 5.0;
    }

    public String determinarRank() {
        double media = calcularMediaSimples();
        if (media >= 9.5) return "Rank SS";
        if (media >= 9.0) return "Rank S";
        if (media >= 8.0) return "Rank A";
        if (media >= 7.0) return "Rank B";
        if (media >= 5.0) return "Rank C";
        return "Rank F";
    }

    public void aplicarBonoTreinamento(double bono) {
        if (bono > 0) {
            setNotaPoderCombate(this.notaPoderCombate + bono);
            setNotaEstrategia(this.notaEstrategia + bono);
            setNotaTrabalhoEquipe(this.notaTrabalhoEquipe + bono);
            setNotaCarisma(this.notaCarisma + bono);
        }
    }

    public void resetarNotas() {
        this.notaPoderCombate = 0.0;
        this.notaEstrategia = 0.0;
        this.notaTrabalhoEquipe = 0.0;
        this.notaCarisma = 0.0;
    }

    public void atualizarNotas(double combate, double estrategia) {
        setNotaPoderCombate(combate);
        setNotaEstrategia(estrategia);
    }

    public void atualizarNotas(double combate, double estrategia, double equipe, double carisma) {
        setNotaPoderCombate(combate);
        setNotaEstrategia(estrategia);
        setNotaTrabalhoEquipe(equipe);
        setNotaCarisma(carisma);
    }

    public static boolean validarNota(double nota) {
        return nota >= NOTA_MINIMA && nota <= NOTA_MAXIMA;
    }

    public static String compararHerois(AvaliacaoHeroi h1, AvaliacaoHeroi h2) {
        if (h1 == null || h2 == null) return "Erro: Herói inválido.";
        
        double media1 = h1.calcularMediaSimples();
        double media2 = h2.calcularMediaSimples();
        
        if (media1 > media2) {
            return h1.getNomeHeroi() + " tem média maior que " + h2.getNomeHeroi() + " (" + String.format("%.2f", media1) + " vs " + String.format("%.2f", media2) + ")";
        } else if (media2 > media1) {
            return h2.getNomeHeroi() + " tem média maior que " + h1.getNomeHeroi() + " (" + String.format("%.2f", media2) + " vs " + String.format("%.2f", media1) + ")";
        } else {
            return "Empate entre " + h1.getNomeHeroi() + " e " + h2.getNomeHeroi() + " com média " + String.format("%.2f", media1);
        }
    }

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public void setNomeHeroi(String nomeHeroi) {
        this.nomeHeroi = nomeHeroi;
    }

    public String getUniversoOuClasse() {
        return universoOuClasse;
    }

    public void setUniversoOuClasse(String universoOuClasse) {
        this.universoOuClasse = universoOuClasse;
    }

    public double getNotaPoderCombate() {
        return notaPoderCombate;
    }

    public void setNotaPoderCombate(double notaPoderCombate) {
        if (validarNota(notaPoderCombate)) {
            this.notaPoderCombate = notaPoderCombate;
        } else if (notaPoderCombate > NOTA_MAXIMA) {
            this.notaPoderCombate = NOTA_MAXIMA;
        } else {
            this.notaPoderCombate = NOTA_MINIMA;
        }
    }

    public double getNotaEstrategia() {
        return notaEstrategia;
    }

    public void setNotaEstrategia(double notaEstrategia) {
        if (validarNota(notaEstrategia)) {
            this.notaEstrategia = notaEstrategia;
        } else if (notaEstrategia > NOTA_MAXIMA) {
            this.notaEstrategia = NOTA_MAXIMA;
        } else {
            this.notaEstrategia = NOTA_MINIMA;
        }
    }

    public double getNotaTrabalhoEquipe() {
        return notaTrabalhoEquipe;
    }

    public void setNotaTrabalhoEquipe(double notaTrabalhoEquipe) {
        if (validarNota(notaTrabalhoEquipe)) {
            this.notaTrabalhoEquipe = notaTrabalhoEquipe;
        } else if (notaTrabalhoEquipe > NOTA_MAXIMA) {
            this.notaTrabalhoEquipe = NOTA_MAXIMA;
        } else {
            this.notaTrabalhoEquipe = NOTA_MINIMA;
        }
    }

    public double getNotaCarisma() {
        return notaCarisma;
    }

    public void setNotaCarisma(double notaCarisma) {
        if (validarNota(notaCarisma)) {
            this.notaCarisma = notaCarisma;
        } else if (notaCarisma > NOTA_MAXIMA) {
            this.notaCarisma = NOTA_MAXIMA;
        } else {
            this.notaCarisma = NOTA_MINIMA;
        }
    }

    public String gerarFichaTecnica() {
        return "Nome: " + nomeHeroi + "\n" +
               "Universo: " + universoOuClasse + "\n" +
               "Combate: " + notaPoderCombate + "\n" +
               "Estratégia: " + notaEstrategia + "\n" +
               "Trabalho em Equipe: " + notaTrabalhoEquipe + "\n" +
               "Carisma: " + notaCarisma + "\n" +
               "Média: " + String.format("%.2f", calcularMediaSimples()) + "\n" +
               "Rank: " + determinarRank() + "\n" +
               "Aprovado: " + (estaAprovadoParaMissao() ? "Sim" : "Não");
    }

    @Override
    public String toString() {
        return nomeHeroi + " (" + universoOuClasse + ") - Média: " + String.format("%.2f", calcularMediaSimples()) + " - " + determinarRank();
    }
}
