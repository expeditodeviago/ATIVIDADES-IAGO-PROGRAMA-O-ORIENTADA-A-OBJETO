package atividade01_herois;

import java.util.ArrayList;
import java.util.List;

public class GuildaNerd {

    private String nomeGuilda;
    private List<AvaliacaoHeroi> membros;

    public GuildaNerd() {
        this("Liga Nerd");
    }

    public GuildaNerd(String nomeGuilda) {
        this.nomeGuilda = nomeGuilda;
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(AvaliacaoHeroi heroi) {
        if (heroi != null) {
            this.membros.add(heroi);
        }
    }

    public boolean removerMembro(String nomeHeroi) {
        return membros.removeIf(h -> h.getNomeHeroi().equalsIgnoreCase(nomeHeroi));
    }

    public double calcularMediaGeralGuilda() {
        if (membros.isEmpty()) return 0.0;
        
        double somaMedias = 0.0;
        for (AvaliacaoHeroi heroi : membros) {
            somaMedias += heroi.calcularMediaSimples();
        }
        return somaMedias / membros.size();
    }

    public AvaliacaoHeroi buscarHeroiDestaque() {
        if (membros.isEmpty()) return null;

        AvaliacaoHeroi mvp = membros.get(0);
        for (AvaliacaoHeroi heroi : membros) {
            if (heroi.calcularMediaSimples() > mvp.calcularMediaSimples()) {
                mvp = heroi;
            }
        }
        return mvp;
    }

    public void exibirRelatorioGuilda() {
        System.out.println("Guilda: " + nomeGuilda);
        System.out.println("Total de Membros: " + membros.size());
        System.out.printf("Média Geral: %.2f\n", calcularMediaGeralGuilda());
        
        AvaliacaoHeroi mvp = buscarHeroiDestaque();
        if (mvp != null) {
            System.out.println("MVP: " + mvp.getNomeHeroi() + " - Média: " + String.format("%.2f", mvp.calcularMediaSimples()));
        }
        
        for (int i = 0; i < membros.size(); i++) {
            System.out.println(membros.get(i).toString());
        }
    }

    public String getNomeGuilda() {
        return nomeGuilda;
    }

    public void setNomeGuilda(String nomeGuilda) {
        this.nomeGuilda = nomeGuilda;
    }

    public List<AvaliacaoHeroi> getMembros() {
        return membros;
    }
}
