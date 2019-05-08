

public class Persoon {
	String voorNaam;
	String achterNaam;
	
	public String getVoorNaam() {
		return voorNaam;
	}
	public void setVoorNaam(String voorNaam) {
		this.voorNaam = voorNaam;
	}
	public String getAchterNaam() {
		return achterNaam;
	}
	public void setAchterNaam(String achterNaam) {
		this.achterNaam = achterNaam;
	}
	
	public String toString() {
		return voorNaam+" "+ achterNaam;
	}
}
