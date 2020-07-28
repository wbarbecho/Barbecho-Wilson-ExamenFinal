package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Paciente;

@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> {

	@PersistenceContext(unitName = "repasos")
	private EntityManager em;

	public PacienteFacade() {
		super(Paciente.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	/*
	 * public List<Telefono> readBodega(char estado) { Query query =
	 * em.createNamedQuery("getByEstado"); query.setParameter("estado", estado);
	 * List result = query.getResultList(); if (result.isEmpty()) {
	 * System.out.println("No hay datos"); } return result; }
	 * 
	 * public List<Bodega> readBodegaName(char estado){ Query query =
	 * em.createNamedQuery("getNames"); query.setParameter("estado", estado); List
	 * result = query.getResultList(); if (result.isEmpty()) {
	 * System.out.println("No hay datos"); } return result; }
	 * 
	 * public Bodega lectorBodegaNombre(String nombre) { Query query =
	 * em.createNamedQuery("getByName"); query.setParameter("nombre", nombre); List
	 * result = query.getResultList(); Bodega response = null; if
	 * (!result.isEmpty()) { response = (Bodega) result.get(0); } return response; }
	 */
}