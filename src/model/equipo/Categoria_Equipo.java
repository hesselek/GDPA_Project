package model.equipo;

public enum Categoria_Equipo {
	
	Ropa("Ropa"), Comida("Comida y Alojamiento Diario"),Provisiones("Provisiones para Casa"),
	Tachas("Tachas y Arneses"),Varios("Equipo vario"),Transporte("Transporte"),Animales("Animales"),
	Servicios("Servicios"),Armaduras("Armaduras"),Armas("Armas");
	
	private String value;

	private Categoria_Equipo(String categoria) {
		this.value = categoria;
	}

	public String getCategoria() {
		return value;
	}
	@Override
	public String toString(){
		return value;
		
	}
	
}
