package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.CitaMedica;

@Stateless
public class CitaMedicaFacade extends AbstractFacade<CitaMedica> {

	@PersistenceContext(unitName = "repasos")
	private EntityManager em;

	public CitaMedicaFacade() {
		super(CitaMedica.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	/*
	 * public List<Cliente> readCliente(char estado) { Query query =
	 * em.createNamedQuery("getByEstadoC"); query.setParameter("estado", estado);
	 * List result = query.getResultList(); if (result.isEmpty()) {
	 * System.out.println("No hay datos"); } return result; }
	 * 
	 * 
	 * public List<Cliente> readClienteByCedula(String cedula) {
	 * System.out.println("LLega la cedula al facade" + cedula); Query query =
	 * em.createNamedQuery("getByCedula"); query.setParameter("cedula", cedula);
	 * List result = query.getResultList(); if (result.isEmpty()) { System.out.
	 * println("No se ha realizado la busqueda todavia o no hay registros"); }
	 * return result; }
	 * 
	 * public List<Cliente> registroCliente(String cedula){
	 * System.out.println("Llega al cliente facade "+ cedula ); Query query =
	 * em.createNamedQuery("getClienteRegistro"); query.setParameter("cedula",
	 * cedula); List result = query.getResultList(); if(result.isEmpty()) {
	 * System.out.println("No se puede registrar el usuario"); } return result;
	 * 
	 * }
	 * 
	 * public void updateCliente(String usuario, String contrasena, String cedula) {
	 * Query query = em.createNativeQuery("UPDATE Cliente SET usuario = " + usuario
	 * + ", contrasena = "+ contrasena + " WHERE cedula = " + cedula);
	 * query.executeUpdate(); System.out.println("Consulta Actuliza cliente" +
	 * query);
	 * 
	 * }
	 */

}