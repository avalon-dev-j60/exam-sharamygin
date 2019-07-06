package edu.blog.models.models;

//
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@NamedQueries({
    @NamedQuery(
        name = "find-user-by-email",
        query = "SELECT user " + "FROM USERS user " + "WHERE user.credentials.email = :email")
})

@Entity(name = "USERS")
public class User implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    
    private String surname;
    

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Credentials credentials;
    
    @OneToMany(mappedBy = "author", targetEntity = Publication.class)
    private List<Publication> publications;
    
    
    @OneToMany(cascade = {  CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.REFRESH,
                            CascadeType.PERSIST})
    private List<Params> parameters;
    
    
    {
    publications = new CopyOnWriteArrayList<>();
    }
    
    {
    parameters = new CopyOnWriteArrayList<>();
    }

    
    public User() {}

    public User(String name, String surname, Credentials credentials) {
        this.name = name;
        this.surname = surname;
        this.credentials = credentials;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User(String name, Credentials credentials) {
        this.name = name;
        this.credentials = credentials;
    }

    
    
    
    
    
    public List<Publication> getPublications() {
        return publications;
    }

    public List<Params> getParameters() {
        return parameters;
    }
    
    
    
    
    
    
    public void addPublication(Publication publication){
        publications.add(publication);
    }
    
  /*  public void addParameters(Params parameters){
        parameters
    }
    */
    
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
}
