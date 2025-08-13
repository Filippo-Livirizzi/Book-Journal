package it.book.bookshelf.f.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "user_book")
@Entity
public class user_book {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Integer id;

    private String recensione;
    private int voto;
    private String stato;

    public enum Stato {
        LETTO,
        DA_LEGGERE,
        IN_CORSO
    }
    
    @ManyToOne
    private Libro libro;

    @ManyToOne
    private User user;

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
     * @return int return the voto
     */
    public int getVoto() {
        return voto;
    }

    /**
     * @param voto the voto to set
     */
    public void setVoto(int voto) {
        this.voto = voto;
    }

    /**
     * @return String return the stato
     */
    public String getStato() {
        return stato;
    }

    /**
     * @param stato the stato to set
     */
    public void setStato(String stato) {
        this.stato = stato;
    }



    /**
     * @return Book return the book
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * @param book the book to set
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }


    /**
     * @return User return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

}
