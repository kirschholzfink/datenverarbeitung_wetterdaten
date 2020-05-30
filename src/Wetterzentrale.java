import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Wetterzentrale {

	private Map<String, Wetterstation> stationen;

	public Wetterzentrale() {

		this.stationen = new HashMap<String, Wetterstation>();

	}

	public void addMesswert(String stationsID, Messwert messwert) {

		Wetterstation station = stationen.get(stationsID);
		station.addMesswert(messwert);

	}

	public void addStation(Wetterstation station) {

		stationen.put(station.getID(), station);
	}

	public void printTemperaturenUeber(double temperatur) {

		for (Map.Entry<String, Wetterstation> eintrag : stationen.entrySet()) {

			Wetterstation dieStation = eintrag.getValue();
			System.out
					.println("\nMesswerte über " + temperatur + " °C gemessen an der " + dieStation.toString() + "\n");

			int n = dieStation.getTemperaturenUeber(temperatur).size();
			if (n == 0) {
				System.out.println("Für diese Station sind keine entsprechenden Werte vorhanden.");
			}

			for (int i = 0; i < n; i++) {
				System.out.println(dieStation.getTemperaturenUeber(temperatur).get(i).toString());
			}
		}

	}

	public void printJahreshoechsttemperaturen() {

		Map<Integer, Double> maxTemps = new TreeMap<Integer, Double>();

		for (Wetterstation station : stationen.values()) {

			for (Messwert messwert : station.getMesswerte()) {

				if (maxTemps.get(messwert.getDatum().getJahr()) != null) {

					if (messwert.getTemperatur() <= maxTemps.get(messwert.getDatum().getJahr())) {
						continue;
					}
				}

				maxTemps.put(messwert.getDatum().getJahr(), messwert.getTemperatur());
			}
		}

		System.out.println("\nJahreshöchsttemperaturen 2000-2018 (Sortierung aufsteigend):\n");

		for (Map.Entry<Integer, Double> eintrag : maxTemps.entrySet()) {
			System.out.println(eintrag.getKey() + " : " + eintrag.getValue());
		}
	}


	public void printWetterstationenNachBundeslandundOrt() {

		ArrayList<Wetterstation> allStats = new ArrayList<Wetterstation>(stationen.values());
		System.out.println("\nAn folgenden Wetterstationen wurden Messungen durchgeführt: (Sortierung nach Bundesland und Ort\n");

		allStats.sort(Wetterstation::compareTo);

		for (int i = 0; i < allStats.size(); i++) {
			System.out.println(allStats.get(i).toString());
		}
	}

}
