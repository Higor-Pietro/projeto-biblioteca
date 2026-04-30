package org.example;

public class Livro {

    // Atributos

    private int id;
    private String titulo;
    private Autor autor;
    private boolean disponível;
    private int idDataBase;

    // Método Construtor

    public Livro() {

    }


    // Métodos Acessores


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean isDisponível() {
        return disponível;
    }

    public void setDisponível(boolean disponível) {
        this.disponível = disponível;
    }

    public int getIdDataBase() {
        return idDataBase;
    }

    public void setIdDataBase(int idDataBase) {
        this.idDataBase = idDataBase;
    }

    // Método para retornar disponibilidade

    public String disponibilidade() {

        if (this.disponível) {
            return "DISPONÍVEL";
        } else{
            return "INDISPONÍVEL";
        }
    }
}
