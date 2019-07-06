
package edu.blog.models.services;

import edu.blog.models.core.CRUD;
import edu.blog.models.models.User;
import javax.ejb.Local;


@Local
public interface UserServiceLocal extends CRUD<User> {
 User find (String email);
}
