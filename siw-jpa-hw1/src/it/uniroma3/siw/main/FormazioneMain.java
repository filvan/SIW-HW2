package it.uniroma3.siw.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Docente;
import it.uniroma3.siw.model.Societa;

public class FormazioneMain {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("training-unit");
		EntityManager em = emf.createEntityManager();
		
		
		Societa s = new Societa();
		s.setRagioneSociale("Azienda");
		s.setTelefono("0123456789");
		EntityTransaction tx = em.getTransaction();
		
		Docente d = new Docente();
		Corso corso1 = new Corso();
		Corso corso2 = new Corso();
		corso1.setNome("corso1");
		corso2.setNome("corso2");
		d.setNome("Mario");
		d.setCognome("Rossi");
		d.setPartitaIva("123");
		d.getCorsi().add(corso1);
		d.getCorsi().add(corso2);
		
		tx.begin();
		em.persist(d);
		tx.commit();
		
		em.close();
		
		em = emf.createEntityManager();
		TypedQuery<Docente> selectQuery = em.createQuery("SELECT d FROM Docente d", Docente.class);
		List<Docente> docenti = selectQuery.getResultList();
		System.out.println("----");
		for (Docente docente : docenti) {
			docente.getCorsi();
			for (Corso c : d.getCorsi()) {
				System.out.println(c);
			}
		}
		
		emf.close();
	}

}
