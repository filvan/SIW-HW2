package it.uniroma3.siw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Indirizzo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String via;

	@Column(nullable = false)
	private String numeroCivico;

	@Column(nullable = false)
	private String comune;

	@Column(nullable = false)
	private String cap;

	@Column(nullable = false)
	private String provincia;

	public Indirizzo() {

	}

	public Indirizzo(String via, String numeroCivico, String comune, String cap, String provincia) {
		this.via = via;
		this.numeroCivico = numeroCivico;
		this.comune = comune;
		this.cap = cap;
		this.provincia = provincia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public boolean equals(Object obj) {
		Indirizzo that = (Indirizzo)obj;
		if (this.getVia().equals(that.getVia()))
			if (this.getNumeroCivico().equals(that.getNumeroCivico()))
				if (this.getComune().equals(that.getComune()))
					return true;
		return false;
	}

	@Override
	public int hashCode() {
		return 31 * this.getVia().hashCode() 
				+ this.getNumeroCivico().hashCode()
				+ this.getComune().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Indirizzo [id=");
		builder.append(this.getId());
		builder.append(", via=");
		builder.append(this.getVia());
		builder.append(", numeroCivico=");
		builder.append(this.getNumeroCivico());
		builder.append(", comune=");
		builder.append(this.getComune());
		builder.append(", cap=");
		builder.append(this.getCap());
		builder.append(", provincia=");
		builder.append(this.getProvincia());
		builder.append("]");
		return builder.toString();
	}
}
