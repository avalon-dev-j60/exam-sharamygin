package edu.blog.models.models;

import edu.blog.models.models.Credentials;
import edu.blog.models.models.Params;
import edu.blog.models.models.Publication;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-05T20:12:05")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Credentials> credentials;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile ListAttribute<User, Params> parameters;
    public static volatile ListAttribute<User, Publication> publications;

}