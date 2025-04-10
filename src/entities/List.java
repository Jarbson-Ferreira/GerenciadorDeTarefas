package entities;

public class List {
    public Integer id;
    public String nome, descricao;
    public boolean concluido;

    public List(Integer id, String nome, String descricao, boolean concluido) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.concluido = concluido;
    }

}

