/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taskhub.PERSISTENCE;

import com.mycompany.taskhub.LOGIC.TaskGroup;
import com.mycompany.taskhub.PERSISTENCE.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author roony
 */
public class TaskGroupJpaController implements Serializable {

    public TaskGroupJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TaskGroup taskGroup) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(taskGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TaskGroup taskGroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            taskGroup = em.merge(taskGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = taskGroup.getId();
                if (findTaskGroup(id) == null) {
                    throw new NonexistentEntityException("The taskGroup with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TaskGroup taskGroup;
            try {
                taskGroup = em.getReference(TaskGroup.class, id);
                taskGroup.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The taskGroup with id " + id + " no longer exists.", enfe);
            }
            em.remove(taskGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TaskGroup> findTaskGroupEntities() {
        return findTaskGroupEntities(true, -1, -1);
    }

    public List<TaskGroup> findTaskGroupEntities(int maxResults, int firstResult) {
        return findTaskGroupEntities(false, maxResults, firstResult);
    }

    private List<TaskGroup> findTaskGroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TaskGroup.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TaskGroup findTaskGroup(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TaskGroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getTaskGroupCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TaskGroup> rt = cq.from(TaskGroup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
