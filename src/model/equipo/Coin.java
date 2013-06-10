package model.equipo;

public enum Coin {
	mc(1),mp(10),me(50),mo(100),mpt(500);
	private int value;

	private Coin(int value) {
		this.value = value;
	}
	
	
}
