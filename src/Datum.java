
public class Datum {

	private int jahr;
	private int monat;
	private int tag;

	public Datum(String datum) {
		String[] datumArray = datum.split("-");
		jahr = Integer.parseInt(datumArray[0]);
		monat = Integer.parseInt(datumArray[1]);
		tag = Integer.parseInt(datumArray[2]);
	}

	public int getTag() {
		return tag;
	}

	public int getMonat() {
		return monat;
	}

	public int getJahr() {
		return jahr;
	}

	@Override
	public String toString() {
		return jahr + "-" + monat + "-" + tag;
	}

}
