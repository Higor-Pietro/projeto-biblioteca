package org.example;

public class Autor {

    // Atributos

    private int id;
    private String nome;
    private int idDataBase;


    // Método Construtor


    public Autor() {

    }

    // Métodos Acessores


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDataBase() {
        return idDataBase;
    }

    public void setIdDataBase(int idDataBase) {
        this.idDataBase = idDataBase;
    }
}
