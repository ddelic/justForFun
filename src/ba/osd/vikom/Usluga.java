package ba.osd.vikom;


public class Usluga {

	public String naziv;

	public double cijena;

	public int min;
	
	public int max;
	
	
	public Usluga(String naziv, double cijena) {
		this.cijena = cijena;
		this.naziv = naziv;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(o instanceof Usluga) {
			Usluga u = (Usluga) o;
			if(this.getNaziv().equalsIgnoreCase(u.getNaziv()))
				return true;
			else 
				return false;
		}
		else 
			return false;
	}
	
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}
	
	public String toString() {
		return "Naziv usluge: "+this.naziv+".\tCijena usluge: "+this.cijena;
	}

}
