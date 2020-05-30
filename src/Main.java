
public class Main {

	public static void main(String[] args) {

		Wetterzentrale wetterZentrale = new Wetterzentrale();

		String[] alleStationen = Wetterdaten.getStationen();
		String[] alleTemperaturen = Wetterdaten.getTemperaturen();

		for (int i = 0; i < alleStationen.length; i++) {
			String[] statsArray = alleStationen[i].split(";");
			String ID = statsArray[0];
			String ort = statsArray[1];
			String bundesland = statsArray[2];
			Wetterstation station = new Wetterstation(ID, ort, bundesland);
			wetterZentrale.addStation(station);
		}

		for (int i = 0; i < alleTemperaturen.length; i++) {
			String[] tempsArray = alleTemperaturen[i].split(" ");
			String stationsID = tempsArray[0];
			String tempDatum = tempsArray[1];
			Datum datum = new Datum(tempDatum);
			double temperatur = Double.parseDouble(tempsArray[2]);
			Messwert messwert = new Messwert(datum, temperatur);
			wetterZentrale.addMesswert(stationsID, messwert);
		}

		wetterZentrale.printTemperaturenUeber(28.0);
		wetterZentrale.printWetterstationenNachBundeslandundOrt();
		wetterZentrale.printJahreshoechsttemperaturen();

	}
}
