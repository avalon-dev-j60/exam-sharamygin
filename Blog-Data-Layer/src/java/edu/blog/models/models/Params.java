

package edu.blog.models.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/*@NamedQueries({
@NamedQuery(
    name = "find-publication-by-id",
        query = "SELECT item "
                + "FROM Params AS item "
                + "WHERE item.id = :id")

})
*/
@Entity
public class Params implements Serializable{
    
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String z1;
    
    @Column(nullable = false)
    private String z2;
    
    @Column(nullable = false)
    private String m;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private User author;

    public Params() {
    }

    public Params(User author, String z1, String z2, String m) {
        this.z1 = z1;
        this.z2 = z2;
        this.m = m;
        this.author = author;
    }

    public void setZ1(String z1) {
        this.z1 = z1;
    }

    public void setZ2(String z2) {
        this.z2 = z2;
    }

    public void setM(String m) {
        this.m = m;
    }
    
    
    
    
}
