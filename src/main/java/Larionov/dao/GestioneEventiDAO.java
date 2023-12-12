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
        // serve una transazione apportare le modifiche in magnera sicura
        EntityTransaction transazione =  em.getTransaction();

        // iniziare la transazione
        transazione.begin();

        // aggiungo lo studente al Persistance Context
        em.persist(evento);

        // termino la transazione con il salvataggio effettivo nella tabella
        transazione.commit();

        System.out.println("Studente" + evento.getTitolo() + "è stato salvato con successo");
    };
    public GestioneEventi findById(long id){
        //SELECT * FROM students WHERE id = 1
        //il primo parametro è l'entita e il secondo l'id
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

            System.out.println("Studente ");

        } else {
            System.out.println("Studente non trovato");
        }

    };
}
