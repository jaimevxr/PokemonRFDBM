package com.daw.pokemonrojofuego;

import com.daw.pokemonrojofuego.EntityManagerUtil;
import com.daw.pokemonrojofuego.Entrenador;
import java.util.List;
import javax.persistence.EntityManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Alumnado
 */
public class EntrenadorDAO {

    // Metodo select, encontrar entrenador de la base de datos por su id
    public Entrenador buscarPorId(int id) {

        EntityManager em = EntityManagerUtil.getEntityManager();
        Entrenador entrenador = em.find(Entrenador.class, id);
        em.close();

        return entrenador;
    }

    public Entrenador buscarPorNombre(String nombreEntrenador) {
        EntityManager em = EntityManagerUtil.getEntityManager();

        // consulta para buscar el nombre
        javax.persistence.TypedQuery<Entrenador> consulta = em.createQuery("SELECT e FROM Entrenador e WHERE e.nombre_entrenador = :nombre", Entrenador.class);

        // pasamos el parámetro a esa consulta
        consulta.setParameter("nombre", nombreEntrenador);

        // ejecutamos la consulta y guardamos los resultados en la lista 
        List<Entrenador> resultados = consulta.getResultList();

        em.close();

        // comprobamos si encontramos a alguien
        if (!resultados.isEmpty()) {
            return resultados.get(0);
        } else {
            return null;
        }
    }

    void guardar(Entrenador entrenador) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entrenador);
        em.getTransaction().commit();
        em.close();
    }
    
    public void actualizar(Entrenador entrenador) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(entrenador);
        em.getTransaction().commit();
        em.close();
    }
    
    public void borrar(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        Entrenador entrenador = em.find(Entrenador.class, id);
        if (entrenador != null) {
            em.remove(entrenador);
        }
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Entrenador> obtenerTodos() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        javax.persistence.TypedQuery<Entrenador> consulta = em.createQuery("SELECT e FROM Entrenador e", Entrenador.class);
        List<Entrenador> lista = consulta.getResultList();
        em.close();
        return lista;
    }
}
