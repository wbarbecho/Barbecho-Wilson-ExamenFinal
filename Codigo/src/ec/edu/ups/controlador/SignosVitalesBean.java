package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.SignoVitalCabeceraFacade;
import ec.edu.ups.ejb.SignoVitalDetalleFacade;
import ec.edu.ups.modelo.SignoVitalCabecera;
import ec.edu.ups.modelo.SignoVitalDetalle;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class SignosVitalesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private SignoVitalCabeceraFacade ejbSignoCabeceraFacade;
	@EJB
	private SignoVitalDetalleFacade ejbSignoDetalleFacade;

	private List<SignoVitalCabecera> listSignosCabecera;
	private List<SignoVitalDetalle> listSignosDetalle;
	private String cedula;
	private String direccion;
	private String nombre;
	private String apellido;
	private String correo;
	private char estado;
	private char temporal;
	private String temporalCedula;

	public SignosVitalesBean() {

	}

	@PostConstruct
	public void init() {
		// ejbClienteFacade.create(new Cliente(this.nombre="Hugo",
		// this.apellido="Prueba",this.cedula= "000000",this.direccion= "Nuevo",
		// this.correo="Cuenca",this.estado= 'A'));

		listSignosCabecera = ejbSignoCabeceraFacade.findAll();
		listSignosDetalle = ejbSignoDetalleFacade.findAll();
		// listEstado = ejbClienteFacade.readCliente('A');
	}

	/*
	 * public Cliente[] getList() {
	 * 
	 * return list.toArray(new Cliente[0]); }
	 * 
	 * public void setList(List<Cliente> list) { this.list = list; }
	 * 
	 * public List<Cliente> getListEstado() { return listEstado; }
	 * 
	 * public void setListEstado(List<Cliente> listEstado) { this.listEstado =
	 * listEstado; }
	 * 
	 * public List<Cliente> getListRegistro() { return listRegistro; }
	 * 
	 * public void setListRegistro(List<Cliente> listRegistro) { this.listRegistro =
	 * listRegistro; }
	 * 
	 * public String getCedula() { return cedula; }
	 * 
	 * public void setCedula(String cedula) { this.cedula = cedula; }
	 * 
	 * public String getDireccion() { return direccion; }
	 * 
	 * public void setDireccion(String direccion) { this.direccion = direccion; }
	 * 
	 * public String getNombre() { return nombre; }
	 * 
	 * public void setNombre(String nombre) { this.nombre = nombre; }
	 * 
	 * public String getApellido() { return apellido; }
	 * 
	 * public void setApellido(String apellido) { this.apellido = apellido; }
	 * 
	 * public String getCorreo() { return correo; }
	 * 
	 * public void setCorreo(String correo) { this.correo = correo; }
	 * 
	 * public char getEstado() { return estado; }
	 * 
	 * public void setEstado(char estado) { this.estado = estado; }
	 * 
	 * public String getTemporalCedula() { return temporalCedula; }
	 * 
	 * public void setTemporalCedula(String temporalCedula) { this.temporalCedula =
	 * temporalCedula; }
	 * 
	 * static String getAlphaNumericString() { int n = 20; String AlphaNumericString
	 * = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
	 * StringBuilder sb = new StringBuilder(n); for (int i = 0; i < n; i++) { int
	 * index = (int) (AlphaNumericString.length() * Math.random());
	 * sb.append(AlphaNumericString.charAt(index)); } return sb.toString(); }
	 * 
	 * public void validarCedula(FacesContext context, UIComponent comp, Object
	 * value) { System.out.println("inside validate method");
	 * 
	 * String mno = (String) value; try { Integer.parseInt(mno); } catch (Exception
	 * e) { ((UIInput) comp).setValid(false); FacesMessage message = new
	 * FacesMessage("Favor ingrese solo numeros");
	 * context.addMessage(comp.getClientId(context), message); } int i; int vect[] =
	 * new int[13]; if (mno.equals("0000000000")) { FacesMessage message = new
	 * FacesMessage("No es una cedula valida");
	 * context.addMessage(comp.getClientId(context), message); } else if
	 * (mno.length() == 10) { System.out.println("Cedula"); for (i = 0; i <
	 * mno.length(); i++) { vect[i] =
	 * Integer.parseInt(Character.toString(mno.charAt(i))); } if (vect[2] <= 6 &&
	 * vect[2] >= 0) { int comprobar[] = { 2, 1, 2, 1, 2, 1, 2, 1, 2 }; int suma =
	 * 0; for (i = 0; i < comprobar.length; i++) { vect[i] *= comprobar[i]; if
	 * (vect[i] >= 10) { vect[i] -= 9; } suma += vect[i]; } suma += vect[i]; suma %=
	 * 10; if (suma != 0) { ((UIInput) comp).setValid(false); FacesMessage message =
	 * new FacesMessage("No es una cedula valida");
	 * context.addMessage(comp.getClientId(context), message); } } } else {
	 * ((UIInput) comp).setValid(false); FacesMessage message = new
	 * FacesMessage("Favor ingrese los 10 digitos");
	 * context.addMessage(comp.getClientId(context), message); } }
	 * 
	 * // Metodos crud public String add() {
	 * 
	 * System.out.println("Llama al add"); this.estado = ('A'); Cliente cli = new
	 * Cliente(); cli.setApellido(apellido); cli.setCedula(cedula);
	 * cli.setContrasena(getAlphaNumericString()); cli.setCorreo(correo);
	 * cli.setDireccion(direccion); cli.setEstado('A'); cli.setNombre(nombre);
	 * cli.setUsuario(correo); System.out.println(cli); /*
	 * cli.setNombre(this.nombre); cli.setApellido(apellido);this.apellido,
	 * this.cedula, this.correo, this.direccion this.estado
	 * 
	 * 
	 * ejbClienteFacade.create(cli); listEstado = ejbClienteFacade.readCliente('A');
	 * 
	 * // list = ejbClienteFacade.readCliente(this.estado); return null; }
	 * 
	 * public String buscarCliente() { System.out.println("Llega la cedula al bean"
	 * + this.cedula); System.out.println("Devuelve el cliente");
	 * System.out.println(list = ejbClienteFacade.readClienteByCedula(this.cedula));
	 * 
	 * return null;
	 * 
	 * }
	 * 
	 * public String Registro() { System.out .println("Llegan los datos" +
	 * this.cedula + this.nombre + this.apellido + this.correo + this.direccion);
	 * System.out.println("Si se puede registrar el cliente");
	 * System.out.println(listRegistro =
	 * ejbClienteFacade.registroCliente(this.cedula));
	 * 
	 * return null;
	 * 
	 * }
	 * 
	 * public String eliminadoLogico(Cliente c) { temporal = c.getEstado();
	 * System.out.println("Datos de cliente" + c.toString()); if (temporal == 'A') {
	 * c.setEstado('I'); ejbClienteFacade.edit(c); listEstado =
	 * ejbClienteFacade.readCliente('A'); } else {
	 * System.out.println("No se realizo el eliminado Logico"); }
	 * 
	 * return null;
	 * 
	 * }
	 * 
	 * public String delete(Cliente c) {
	 * 
	 * ejbClienteFacade.remove(c); // list = ejbClienteFacade.findAll(); listEstado
	 * = ejbClienteFacade.readCliente(this.estado); return null; }
	 * 
	 * public String edit(Cliente c) { c.setEditable(true); return null; }
	 * 
	 * public String save(Cliente c) { c.setEstado('A'); System.out.println(c);
	 * ejbClienteFacade.edit(c); c.setEditable(false); listEstado =
	 * ejbClienteFacade.readCliente('A'); return null; }
	 * 
	 * public String iniciarSesion() { return null; }
	 * 
	 * public String getText(String text) { if (text.equals("factura")) { return
	 * "factura"; } else { return "dashboard"; } }
	 */

}