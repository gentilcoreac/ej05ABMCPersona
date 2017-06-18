package controlers;
import java.util.ArrayList;
import entity.Persona;

public class CtrlABMPersona {
	private ArrayList<Persona> pers;
	
	public CtrlABMPersona(){
		pers= new ArrayList<Persona>();
		pers.add(new Persona("Alberto Carlos","Gentilcore","37831713",true));
		pers.add(new Persona("Andres","Lopapa","121212",true));
		}
	
	public void add(Persona p){
		this.pers.add(p);
	}
	public void delete(Persona p){
		this.pers.remove(p);
	}
	public void update(Persona p){
		this.update(p);
	}
	
	
	public Persona getByDni(Persona p){
		return this.pers.get(this.pers.indexOf(p));
		//return this.getByDni(p.getDni());
	}
	public Persona getByDni(String dni){
		for(int i=0; i<this.pers.size(); i++){
			if(pers.get(i).getDni().equals(dni)){				//REGLA DE IGUALDAD.DEPENDERÁ DEL NEGOCIO
				return pers.get(i);
			}
		}
		return null;
	}
	
	public Persona getByNombreApellido(Persona p){
			for(int i=0; i<this.pers.size();i++){
				if(pers.get(i).getNombre().equalsIgnoreCase(p.getNombre()) &&
					pers.get(i).getApellido().equalsIgnoreCase(p.getApellido())){
					return pers.get(i);
				}
			}
		return null;
		}

	public ArrayList<Persona> getAll(){
		return this.pers;
	}
}


