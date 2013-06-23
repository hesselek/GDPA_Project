package model.equipo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemEquipo {
	
	@Id
	@Column(name = "nombre", unique=true, nullable=false)
	private String nombre;
	private byte categoria;
	private float peso;
	private int precioMin;
	private int precioMax;
	private ItemEquipo equipo;
	private boolean especial;
	
	public ItemEquipo(){
		
	}
	
	public ItemEquipo(String nombre, byte categoria){
		this.nombre = nombre;
		this.categoria = categoria;
	}
	
	public ItemEquipo(String nombre){
		this.nombre = nombre;
		
	}
	public ItemEquipo(String nombre, byte categoria, float peso, int precioMin,
			int precioMax, ItemEquipo equipo, boolean especial) 
	{
		this.nombre = nombre;
		this.categoria = categoria;
		this.peso = peso;
		this.precioMin = precioMin;
		this.precioMax = precioMax;
		this.equipo = equipo;
		this.especial = especial;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte getCategoria() {
		return categoria;
	}

	public void setCategoria(byte categoria) {
		this.categoria = categoria;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getPrecioMin() {
		return precioMin;
	}

	public void setPrecioMin(int precioMin) {
		this.precioMin = precioMin;
	}

	public int getPrecioMax() {
		return precioMax;
	}

	public void setPrecioMax(int precioMax) {
		this.precioMax = precioMax;
	}

	public ItemEquipo getEquipo() {
		return equipo;
	}

	public void setEquipo(ItemEquipo equipo) {
		this.equipo = equipo;
	}

	public boolean isEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	
	
	
	
	

}
