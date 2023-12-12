package Larionov;

import Larionov.dao.GestioneEventiDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("FS0423-M4-W3-L2-homeWork-2");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        GestioneEventiDAO sd = new GestioneEventiDAO(em);


        System.out.println("Hello World!");
    }
}
