package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.PontoTuristico;
import util.JPAUtil;

public class PontoTuristicoDAO {

	public static void salvar(PontoTuristico ponto) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(ponto);
		em.getTransaction().commit();
		em.close();
	}

	public static void editar(PontoTuristico ponto) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(ponto);
		em.getTransaction().commit();
		em.close();
	}

	public static PontoTuristico buscarPorId(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		PontoTuristico ponto = em.find(PontoTuristico.class, id);
		em.close();
		return ponto;
	}

	public static void excluir(PontoTuristico ponto) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		ponto = em.find(PontoTuristico.class, ponto.getId());
		em.remove(ponto);
		em.getTransaction().commit();
		em.close();
	}

	public static List<PontoTuristico> listar() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query query = em.createQuery("select p from PontoTuristico p");
		List<PontoTuristico> lista = query.getResultList();
		em.close();
		return lista;
	}

}
