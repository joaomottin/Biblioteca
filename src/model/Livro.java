package model;

public class Livro implements Bibliotecavel{
    private String titulo, autor, categoria;
    private int id, exemplares, anoPublicacao;
    
    public Livro(String titulo, String autor, String categoria, int id, int exemplares, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.id = id;
        this.exemplares = exemplares;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", autor=" + autor + ", categoria=" + categoria + ", id=" + id
                + ", exemplares=" + exemplares + ", anoPublicacao=" + anoPublicacao + "]";
    }

    @Override
    public String getDescricao() {
        return "Livro: " + titulo + " por " + autor + " (" + anoPublicacao + ")";
    }
    
}
