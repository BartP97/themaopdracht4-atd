/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Article;
import domain.Person;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author yanick
 */
@Stateless
public class ArticleService extends Service<Article, Long> {
    
    public ArticleService() {
        super(Article.class);
    }
    
    public List<Article> getArticles(){
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("SELECT a FROM Article a WHERE a.softDelete = FALSE");
        return query.getResultList();
    }
    
    public void deleteArticle(int id) {
        Query query = getEntityManager().createQuery("UPDATE Article a SET a.softDelete = TRUE WHERE a.id= :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
    
    public List<Article> searchArticle(String name){
        EntityManager entityManager = getEntityManager();
        
        Query query = entityManager.createQuery("SELECT a FROM Article a WHERE a.name LIKE :search");
        query.setParameter("search", "%"+name+"%");
        
        return query.getResultList();
    }
    
    public void inboeken(Long id, int count) {
        Query query = getEntityManager().createQuery("UPDATE Article a SET a.stock = a.stock + :count WHERE a.id= :id");
        query.setParameter("count", count);
        query.setParameter("id", id);
        query.executeUpdate();
    }
    
    public void uitboeken(Long id, int count) {
        Query query = getEntityManager().createQuery("UPDATE Article a SET a.stock = a.stock - :count WHERE a.id= :id");
        query.setParameter("count", count);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}