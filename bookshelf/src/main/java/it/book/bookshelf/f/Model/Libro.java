package it.book.bookshelf.f.Model;

import java.awt.Image;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "book")
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titolo;
    private String autore;
    private String genere;
    private String isbn;
    private String recensione;
    private Image immagine;



    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * @param titolo the titolo to set
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * @return String return the autore
     */
    public String getAutore() {
        return autore;
    }

    /**
     * @param autore the autore to set
     */
    public void setAutore(String autore) {
        this.autore = autore;
    }

    /**
     * @return String return the genere
     */
    public String getGenere() {
        return genere;
    }

    /**
     * @param genere the genere to set
     */
    public void setGenere(String genere) {
        this.genere = genere;
    }

    /**
     * @return String return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return String return the recensione
     */
    public String getRecensione() {
        return recensione;
    }

    /**
     * @param recensione the recensione to set
     */
    public void setRecensione(String recensione) {
        this.recensione = recensione;
    }

    /**
     * @return String return the immagine
     */
    public Image getImmagine() {
        return immagine;
    }

    /**
     * @param immagine the immagine to set
     */
    public void setImmagine(Image immagine) {
        this.immagine = immagine;
    }

}
