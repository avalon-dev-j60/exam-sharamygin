/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.blog.models.core;


public interface CRUD<E>{
    
    void create(E entity);
    void update(E entity);
    void delete(E entity);
}
