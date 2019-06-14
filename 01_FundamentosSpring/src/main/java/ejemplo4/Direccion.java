package ejemplo4;

public class Direccion {
	private String nombreVia;
	private String tipoVia;
	private String cp;
	private String ciudad;

	//generata getter y setter 
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	public String getTipoVia() {
		return tipoVia;
	}
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	@Override
	public String toString() {
		return "Direccion [nombreVia=" + nombreVia + ", tipoVia=" + tipoVia + ", cp=" + cp + ", ciudad=" + ciudad + "]";
	}
	
	

}
