package com.example;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class PersistenceService {

    @PersistenceContext(unitName = "demoPU")
    EntityManager entityManager;
    
    public PersistenceService () {};

    public List<User> getAllUsers () {
        TypedQuery<User> result = entityManager.createQuery("select u from User u", User.class); 
        List<User> users = result.getResultList();
        return users;       
    }

    public void addUser (User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
}