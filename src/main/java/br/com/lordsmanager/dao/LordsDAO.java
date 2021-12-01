package br.com.lordsmanager.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LordsDAO<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;

	static {
		try {
			emf = Persistence
					.createEntityManagerFactory("lordsmanager");
		} catch (Exception e) {
			// logar -> log4j
		}
	}

	public LordsDAO() {
		this(null);
	}

	public LordsDAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public LordsDAO<E> abrirT() {
		em.getTransaction().begin();
		return this;
	}
	
	public LordsDAO<E> fecharT() {
		em.getTransaction().commit();
		return this;
	}

	public LordsDAO<E> voltarT() {
		em.getTransaction().rollback();
		return this;
	}

	public LordsDAO<E> incluir(E entidade) {
		em.persist(entidade);
		em.flush();
		return this;
	}

	public LordsDAO<E> atualizar(E entidade) {
		em.merge(entidade);
		return this;
	}


	public Object incluirId(E entidade) {
		em.persist(entidade);
		return entidade;
	}

	public LordsDAO<E> incluirAtomico(E entidade) {
		return this.abrirT().incluir(entidade).fecharT();
	}
	
	public E obterPorID(Object id) {
		return em.find(classe, id);
	}

	public List<E> obterTodos() {
		return this.obterTodos(10, 0);
	}
	
	public List<E> obterTodos(int qtde, int deslocamento) {
		if(classe == null) {
			throw new UnsupportedOperationException("Classe nula.");
		}
		
		String jpql = "select e from " + classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(qtde);
		query.setFirstResult(deslocamento);
		return query.getResultList();
	}

	public List<E> consultar(String nomeConsulta, Object... params) {
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);

		for (int i = 0; i < params.length; i += 2) {
			query.setParameter(params[i].toString(), params[i + 1]);
		}

		return query.getResultList();
	}

	public List<E> consultarNative(String nomeConsulta, Object... params) {

		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);

		for (int i = 0; i < params.length; i += 1) {
			query.setParameter(i+1, params[i]);
		}

		return query.getResultList();
	}

	public E consultarUm(String nomeConsulta, Object... params) {
		List<E> lista = consultar(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	public void fechar() {
		em.close();
	}
}
