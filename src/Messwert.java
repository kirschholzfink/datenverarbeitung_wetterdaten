
public class Messwert {

	private Datum datum;
	private double temperatur;

	public Messwert(Datum datum, double temperatur) {
		this.datum = datum;
		this.temperatur = temperatur;
	}

	public Datum getDatum() {
		return datum;
	}

	public double getTemperatur() {
		return temperatur;
	}

	@Override
	public String toString() {
		return "Temperatur am " + datum + " : " + temperatur + " °C";
	}

}
