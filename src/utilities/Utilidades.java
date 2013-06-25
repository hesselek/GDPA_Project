package utilities;

public class Utilidades {
	public String conversorDb(int cantidad){
		String moneda = " mc";
		if(cantidad>=10 && cantidad<=100){
			cantidad = cantidad/10;
			moneda = " mp";
		}
		if(cantidad>=100){
			cantidad = cantidad/100;
			moneda = " mo";
		}
			String r = cantidad+moneda;
			String formada = "";
			for(int i=r.length()-1; i>=0; i--)
				formada = Character.toString(r.charAt(i)) +formada;		
			
			for(int i=11-formada.length(); i>=0;i--)
				formada = " "+formada;		
		return formada;
		
	}

}
