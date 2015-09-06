package br.com.compositeam;

public class Discipline {
	
	private String cod;
	
	private String name;
	
	

	public Discipline(String cod, String name) {
		super();
		setCod(cod);
		setName(name);
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
