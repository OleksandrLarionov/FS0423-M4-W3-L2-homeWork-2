package Larionov;

import Larionov.dao.GestioneEventiDAO;
import Larionov.entities.GestioneEventi;
import Larionov.entities.TipoEvento;
import com.github.javafaker.Faker;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FS0423-M4-W3-L2-homeWork-2");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        GestioneEventiDAO ged = new GestioneEventiDAO(em);
        Faker faker = new Faker();

//        *****************************SUPPLIERS******************************
        Supplier<LocalDate> dateSupplier = () -> {
            Random rdm = new Random();
            int randomYear = rdm.nextInt(2000,2024);
            int randomDay = rdm.nextInt(1,30);
            int randomMonth = rdm.nextInt(1,12);
            return LocalDate.of(randomYear, randomMonth,randomDay);
        };

        Supplier<Integer> pplInvitationSupplier = () -> {
            Random rndm = new Random();
            int ppl = rndm.nextInt(1, 150);
            return  ppl;
        };

        Supplier<TipoEvento> supplierEventoRndm = () -> {
            Random rndm = new Random();
            int numRandom = rndm.nextInt(1,3);
            if (numRandom == 1) {
                return TipoEvento.PRIVATO;
            } else {
                return TipoEvento.PUBBLICO;
            }
        };

        Supplier<GestioneEventi> nuovoEventoSupplier = () -> new GestioneEventi(faker.name().title(), dateSupplier.get(), faker.gameOfThrones().city(), supplierEventoRndm.get(), pplInvitationSupplier.get());

//        ********************CREAZIONE EVENTI****************

//        for (int i = 0; i < 70; i++){
//            ged.save(nuovoEventoSupplier.get());
//        }
//
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

        List<GestioneEventi> listaEventiTry2 = ged.getAllEvents();
        listaEventiTry2.forEach(System.out::println);

//        ********************DELETE EVENT****************
        System.out.println("********************EVENTI CANCELLATI********************");

        ged.findByIdAndDelete(3);

        em.close();
        emf.close();

    }
}
