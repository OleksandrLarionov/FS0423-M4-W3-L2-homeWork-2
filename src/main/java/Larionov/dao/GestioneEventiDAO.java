package Larionov.dao;

import Larionov.entities.GestioneEventi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GestioneEventiDAO {
    private final EntityManager em;

    public GestioneEventiDAO(EntityManager em) {
        this.em = em;
    }
    public void save(GestioneEventi evento){

        EntityTransaction transazione =  em.getTransaction();

        transazione.begin();

        em.persist(evento);

        transazione.commit();

        System.out.println("Evento" + evento.getTitolo() + "è stato salvato con successo");
    };
    public GestioneEventi findById(long id){
        GestioneEventi found = em.find(GestioneEventi.class, id);
        return found;
    };
    public void deleteByIdAndDelete(long id){
        GestioneEventi found = this.findById(id);

        if (found != null){
            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("Evento cancellato");

        } else {
            System.out.println("Evento non trovato");
        }

    };
}
