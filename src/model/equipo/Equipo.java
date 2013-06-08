package model.equipo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipo {
	private byte categoria;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nombre", unique=true, nullable=false)
	private String nombre;
	private int peso;
	private int precioMin;
	private int precioMax;
	private Equipo equipo;
	
	public Equipo(){
		
	}
	
	public Equipo(byte categoria, String nombre, int peso, int precioMin,
			int precioMax, Equipo equipo) {
		this.categoria = categoria;
		this.nombre = nombre;
		this.peso = peso;
		this.precioMin = precioMin;
		this.precioMax = precioMax;
		this.equipo = equipo;
	}
	
	
	

}
