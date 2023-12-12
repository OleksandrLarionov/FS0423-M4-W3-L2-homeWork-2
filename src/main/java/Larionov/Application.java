package Larionov;

import Larionov.dao.GestioneEventiDAO;
import Larionov.entities.GestioneEventi;
import Larionov.entities.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FS0423-M4-W3-L2-homeWork-2");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        GestioneEventiDAO sd = new GestioneEventiDAO(em);

//        ********************CREAZIONE EVENTI****************
        GestioneEventi eventoUno = new GestioneEventi("Compleanno", LocalDate.of(2023,2,4), "Una BIG festa Di Compleanno" , TipoEvento.PRIVATO, 200);
        GestioneEventi eventoDue = new GestioneEventi("Piscina", LocalDate.of(2023,1,25), "Una festa in piscina" , TipoEvento.PUBBLICO, 200);
        GestioneEventi eventoTre = new GestioneEventi("Lavoro", LocalDate.of(2023,5,5), "Festa nuovo incarico" , TipoEvento.PRIVATO, 200);
        GestioneEventi eventoQuattro = new GestioneEventi("Sagra", LocalDate.of(2023,12,10), "Sagra della porchetta" , TipoEvento.PUBBLICO, 200);
        GestioneEventi eventoCinque = new GestioneEventi("Compleanno", LocalDate.of(2023,10,20), "Una festa Di Compleanno" , TipoEvento.PRIVATO, 200);
        GestioneEventi eventoSei = new GestioneEventi("Disco", LocalDate.of(2023,11,25), "Disco" , TipoEvento.PUBBLICO, 200);

//        ********************SAVE EVENTs****************

//        sd.save(eventoUno);
//        sd.save(eventoDue);
//        sd.save(eventoTre);
//        sd.save(eventoQuattro);
//        sd.save(eventoCinque);
//        sd.save(eventoSei);

//        ********************FIND EVENT****************

//        for (int i = 1 ; i < 6; i++) {
//            GestioneEventi eventoFromDb = sd.getById(i);
//            if (eventoFromDb != null) {
//                System.out.println(eventoFromDb);
//            } else {
//                System.out.println("L'eventoFromDb con id: " + i + " non è presente o è stato rimosso");
//            }
//        }
        System.out.println("********************LISTA EVENTI********************");

//        List<GestioneEventi> listaEventi = sd.getAllEvents();
//        listaEventi.forEach(System.out::println);

        List<GestioneEventi> listaEventiTry2 = sd.getAllEvents();
        listaEventiTry2.forEach(System.out::println);

//        ********************DELETE EVENT****************
        System.out.println("********************EVENTI CANCELLATI********************");

        sd.findByIdAndDelete(3);

        em.close();
        emf.close();

    }
}
