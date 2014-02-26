package br.ufc.quixada.npi.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.ufc.quixada.npi.model.Contato;
import br.ufc.quixada.npi.repository.ContatoRepository;

public class JpaContatoRepositoryImpl implements ContatoRepository {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	
	
	public EntityManager getEm() {
		if (em == null) {
			emf = Persistence.createEntityManagerFactory("dev");
			em = emf.createEntityManager();
		}
		return em;	
	}
	
	/* (non-Javadoc)
	 * @see br.ufc.quixada.npi.repository.ContatoRepository#beginTransaction()
	 */
	public void beginTransaction() {
		if (tx == null) {
			tx = getEm().getTransaction();
		}
		tx.begin();
	}

	/* (non-Javadoc)
	 * @see br.ufc.quixada.npi.repository.ContatoRepository#commit()
	 */
	public void commit() {
		tx.commit();
	}

	/* (non-Javadoc)
	 * @see br.ufc.quixada.npi.repository.ContatoRepository#rollback()
	 */
	public void rollback() {
		tx.rollback();
	}

	public void save(Contato c) {
		getEm().merge(c);
	}

	public List<Contato> findAll() {
		return getEm().createQuery("from Contato", Contato.class).getResultList();
	}

	public void close() {
		if (em != null) {
			em.close();
			emf.close();
			em = null;
			emf = null;
		}
	}
	
}
