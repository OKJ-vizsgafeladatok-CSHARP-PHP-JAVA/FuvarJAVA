import java.time.LocalDateTime;

public class Fuvar {

	private int id;
	private LocalDateTime ind;
	private int utazas_idotartam;
	private double tavolsag;
	private double viteldij;
	private double borravalo;
	private String fizetes_modja;
	public Fuvar(int id, LocalDateTime ind, int utazas_idotartam, double tavolsag, double viteldij, double borravalo,
			String fizetes_modja) {
		super();
		this.id = id;
		this.ind = ind;
		this.utazas_idotartam = utazas_idotartam;
		this.tavolsag = tavolsag;
		this.viteldij = viteldij;
		this.borravalo = borravalo;
		this.fizetes_modja = fizetes_modja;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getInd() {
		return ind;
	}
	public void setInd(LocalDateTime ind) {
		this.ind = ind;
	}
	public int getUtazas_idotartam() {
		return utazas_idotartam;
	}
	public void setUtazas_idotartam(int utazas_idotartam) {
		this.utazas_idotartam = utazas_idotartam;
	}
	public double getTavolsag() {
		return tavolsag;
	}
	public void setTavolsag(double tavolsag) {
		this.tavolsag = tavolsag;
	}
	public double getViteldij() {
		return viteldij;
	}
	public void setViteldij(double viteldij) {
		this.viteldij = viteldij;
	}
	public double getBorravalo() {
		return borravalo;
	}
	public void setBorravalo(double borravalo) {
		this.borravalo = borravalo;
	}
	public String getFizetes_modja() {
		return fizetes_modja;
	}
	public void setFizetes_modja(String fizetes_modja) {
		this.fizetes_modja = fizetes_modja;
	}
	@Override
	public String toString() {
		return "Fuvar [id=" + id + ", ind=" + ind + ", utazas_idotartam=" + utazas_idotartam + ", tavolsag=" + tavolsag
				+ ", viteldij=" + viteldij + ", borravalo=" + borravalo + ", fizetes_modja=" + fizetes_modja + "]";
	}
	
	public double fuvarBevetele() {
		double bev=0.0;
		bev=viteldij+borravalo;
		return bev;
	}
}
