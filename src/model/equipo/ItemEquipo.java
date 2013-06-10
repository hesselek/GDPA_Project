package model.equipo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemEquipo {
	
	@Id
	@Column(name = "nombre", unique=true, nullable=false)
	private String nombre;
	private byte categoria;
	private long peso;
	private int precioMin;
	private int precioMax;
	private ItemEquipo equipo;
	
	public ItemEquipo(){
		
	}

	public ItemEquipo(String nombre, byte categoria, long peso, int precioMin,
			int precioMax, ItemEquipo equipo) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.peso = peso;
		this.precioMin = precioMin;
		this.precioMax = precioMax;
		this.equipo = equipo;
	}
	
	
	
	

}
