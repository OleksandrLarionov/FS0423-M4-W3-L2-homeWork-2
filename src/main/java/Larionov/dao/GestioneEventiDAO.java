package Larionov.dao;

import Larionov.entities.GestioneEventi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

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
    public GestioneEventi getById(long id){
        GestioneEventi found = em.find(GestioneEventi.class, id);
        return found;
    };
    public void findByIdAndDelete(long id){
        GestioneEventi found = this.getById(id);

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
    public List<GestioneEventi> getAllEvents() {
        List<GestioneEventi> listaEventi = em.createQuery("SELECT e FROM GestioneEventi e", GestioneEventi.class).getResultList();
        return listaEventi;
    }
}
