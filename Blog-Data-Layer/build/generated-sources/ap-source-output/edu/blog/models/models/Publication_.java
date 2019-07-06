package edu.blog.models.models;

import edu.blog.models.models.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-05T20:46:38")
@StaticMetamodel(Publication.class)
public class Publication_ { 

    public static volatile SingularAttribute<Publication, Date> createdAt;
    public static volatile SingularAttribute<Publication, User> author;
    public static volatile SingularAttribute<Publication, Long> id;
    public static volatile SingularAttribute<Publication, String> title;
    public static volatile SingularAttribute<Publication, String> content;

}