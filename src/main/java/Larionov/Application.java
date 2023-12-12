package Larionov;

import Larionov.dao.GestioneEventiDAO;
import Larionov.entities.GestioneEventi;
import Larionov.entities.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FS0423-M4-W3-L2-homeWork-2");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        GestioneEventiDAO sd = new GestioneEventiDAO(em);


        GestioneEventi eventoUno = new GestioneEventi("Compleanno", LocalDate.of(2023,12,25), "Una BIG festa Di Compleanno" , TipoEvento.PRIVATO, 200);
//        sd.save(eventoUno);
        System.out.println("Hello World!");
    }
}
