import java.util.ArrayList;
import java.util.List;

public class Wetterstation implements Comparable<Wetterstation> {

	private String ID;
	private String ort;
	private String bundesland;
	private List<Messwert> messwerte;


	public Wetterstation(String ID, String ort, String bundesland) {
		this.ID = ID;
		this.ort = ort;
		this.bundesland = bundesland;
		this.messwerte = new ArrayList<Messwert>();
	}


	public String getID() {
		return ID;
	}

	public String getOrt() {
		return ort;
	}

	public String getBundesland() {
		return bundesland;
	}

	public List<Messwert> getMesswerte() {

		return messwerte;

	}

	public void addMesswert(Messwert messwert) {

		messwerte.add(messwert);

	}

	@Override
	public String toString() {
		return "Station " + getOrt() + " (ID: " + getID() + ", Bundesland: " + getBundesland() + ")";
	}

	@Override
	public int compareTo(Wetterstation other) {

		if (this.bundesland.compareTo(other.getBundesland()) == 0) {
			return this.ort.compareTo(other.getOrt());
		} else {
			return this.bundesland.compareTo(other.getBundesland());
		}

	}

	public List<Messwert> getTemperaturenUeber(double temperatur) {

		List<Messwert> drüber = new ArrayList<Messwert>();

		for (int i = 0; i < getMesswerte().size(); i++) {
			if (getMesswerte().get(i).getTemperatur() > temperatur) {
				drüber.add(getMesswerte().get(i));
			}
		}
		return drüber;
	}

}
