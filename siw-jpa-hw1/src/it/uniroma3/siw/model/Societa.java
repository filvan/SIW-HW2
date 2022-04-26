package it.uniroma3.siw.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Societa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 2000, nullable = false)
	private String ragioneSociale;
	
	
	/* Fetch: default (eager)
	 * Cascade: c'è una forte dipendenza dell'indirizzo dalla società, quasi come se ci fosse una composizione tra l'uno e l'altro.
	 * Nel contesto dell'esercizio, non possono esistere indirizzi che non siano indirizzi di società.
	 * Perciò ha senso che le operazioni di persist e di remove sulla società si propaghino anche sul suo indirizzo. */
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "id_sede")
	private Indirizzo sede;
	
	@Column(nullable = false)
	private String telefono;

	public Societa() {
		
	}

	public Societa(String ragioneSociale, Indirizzo sede, String telefono) {
		this.ragioneSociale = ragioneSociale;
		this.sede = sede;
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public Indirizzo getSede() {
		return sede;
	}

	public void setSede(Indirizzo sede) {
		this.sede = sede;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public boolean equals(Object obj) {
		Societa that = (Societa) obj;
		if (this.getRagioneSociale().equals(that.getRagioneSociale()))
			if (this.getSede().equals(that.getSede()))
				if (this.getTelefono().equals(that.getTelefono()))
					return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * this.getRagioneSociale().hashCode() 
				+ this.getSede().hashCode() 
				+ this.getTelefono().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Societa [id=");
		builder.append(this.getId());
		builder.append(", ragioneSociale=");
		builder.append(this.getRagioneSociale());
		builder.append(", sede=");
		builder.append(this.getSede());
		builder.append(", telefono=");
		builder.append(this.getTelefono());
		builder.append("]");
		return builder.toString();
	}
}
