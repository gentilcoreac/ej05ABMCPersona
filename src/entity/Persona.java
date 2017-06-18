package entity;

public class Persona {

	private String nombre;
	private String apellido;
	private String dni;
	private boolean habilitado;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Persona(String nombre, String apellido, String dni, boolean habilitado){
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDni(dni);
		this.setHabilitado(habilitado);
	}
	public Persona() {
		// TODO Auto-generated constructor stub
	}
	
	//sobrescribo el metodo equals  
	@Override 
	public boolean equals(Object p){
		return(p instanceof Persona) &&
				(((Persona)p).getDni().equals(this.getDni()));
	
		/*if (p instanceof Persona){			//el "instanceof" si es de la clase o sub clase de Persona
			if(
					((Persona)p).getDni().equals(this.getDni()))	//tambien podria haber sacado este if y poner todo en un solo if con el && (ya que el && es cortocircuito, ya que si la primera es falsa no ejecuta la segunda)	
			return true;
		}
		return false;*/
		
	}
}
