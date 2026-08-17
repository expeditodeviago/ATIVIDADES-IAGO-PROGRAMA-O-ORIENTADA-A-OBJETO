# 📚 Atividades de Programação Orientada a Objetos (POO)

Repositório dedicado ao armazenamento e organização das atividades práticas desenvolvidas durante o semestre na disciplina de **Programação Orientada a Objetos em Java**.

---

## 📁 Estrutura do Projeto

O projeto está organizado por pacotes dentro de `src/`, facilitando a navegação e execução de cada atividade individualmente:

```text
src/
├── atividade01_herois/
│   ├── AvaliacaoHeroi.java     # Modelagem de heróis, notas, ranks e construtores
│   ├── GuildaNerd.java         # Gestão de guilda, média geral e eleição de MVP
│   └── Main.java               # Classe de teste e execução da atividade 01
│
└── atividade02_aluno/
    ├── AvaliacaoAluno.java     # Modelagem de avaliação escolar com construtor sem argumentos
    └── Main.java               # Instanciação de objetos e exibição de relatórios
```

---

## 📝 Resumo das Atividades

### 🔹 Atividade 01: Avaliação de Heróis & Guilda Nerd
- **Conceitos:** Classes, objetos, sobrecarga de construtores, métodos de cálculo (médias simples e ponderadas), validações estáticas e agregação de objetos.
- **Execução:**
  ```bash
  javac -d . src/atividade01_herois/*.java
  java atividade01_herois.Main
  ```

### 🔹 Atividade 02: Avaliação Escolar (Construtor Sem Argumentos)
- **Conceitos:** Instanciação de objetos utilizando **construtor padrão sem argumentos**, encapsulamento (getters/setters), atributos de aluno, matéria, professor e notas, cálculo de média e verificação de situação acadêmica.
- **Execução:**
  ```bash
  javac -d . src/atividade02_aluno/*.java
  java atividade02_aluno.Main
  ```
