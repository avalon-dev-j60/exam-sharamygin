
package edu.blog.models.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@NamedQueries({
@NamedQuery(
    name = "find-publication-by-id",
        query = "SELECT item "
                + "FROM Publication AS item "
                + "WHERE item.id = :id")
})
@Entity
public class Publication implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String title;
    
    @Column(columnDefinition = "long varchar")
    private String content;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;
    
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private User author;

    public Publication() {}

    
    public Publication(User author, String title, String content) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = new Date();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    
}
