package model.equipo;

public enum Categoria_Equipo {
	
	Ropa("Ropa"), Comida("Comida y Alojamiento Diario"),Provisiones("Provisiones para Casa"),
	Tachas("Tachas y Arneses"),Vario("Equipo vario"),Transporte("Transporte"),Animales("Animales"),
	Servicios("Servicios"),Armaduras("Armaduras"),Armas("Armas");
	
	private String categoria;

	private Categoria_Equipo(String categoria) {
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}
	
	
}
