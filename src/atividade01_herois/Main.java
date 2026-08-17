package atividade01_herois;

public class Main {

    public static void main(String[] args) {

        AvaliacaoHeroi h1 = new AvaliacaoHeroi();
        AvaliacaoHeroi h2 = new AvaliacaoHeroi("Homem-Aranha");
        h2.atualizarNotas(8.5, 9.0, 9.5, 9.0);

        AvaliacaoHeroi h3 = new AvaliacaoHeroi("Goku", "Dragon Ball Z");
        h3.atualizarNotas(10.0, 5.0, 7.5, 8.5);

        AvaliacaoHeroi h4 = new AvaliacaoHeroi("Hermione Granger", "Hogwarts", 6.5, 10.0);
        h4.setNotaTrabalhoEquipe(9.0);
        h4.setNotaCarisma(8.0);

        AvaliacaoHeroi h5 = new AvaliacaoHeroi("Batman", "DC Comics", 8.5, 10.0, 8.5, 7.5);
        AvaliacaoHeroi h6 = new AvaliacaoHeroi(h5);

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);
        System.out.println(h5);
        System.out.println(h6);

        System.out.println(h5.calcularMediaSimples());
        System.out.println(h5.calcularMediaPonderada(2.0, 4.0, 2.0, 2.0));
        System.out.println(h5.buscarMaiorNota());
        System.out.println(h5.buscarMenorNota());
        System.out.println(h5.estaAprovadoParaMissao());
        System.out.println(h5.determinarRank());

        h3.aplicarBonoTreinamento(1.0);
        System.out.println(h3.calcularMediaSimples());

        System.out.println(AvaliacaoHeroi.validarNota(11.5));
        System.out.println(AvaliacaoHeroi.compararHerois(h5, h3));

        System.out.println(h4.gerarFichaTecnica());

        GuildaNerd guilda = new GuildaNerd("Vingadores Nerds");
        guilda.adicionarMembro(h2);
        guilda.adicionarMembro(h3);
        guilda.adicionarMembro(h4);
        guilda.adicionarMembro(h5);

        guilda.exibirRelatorioGuilda();
    }
}