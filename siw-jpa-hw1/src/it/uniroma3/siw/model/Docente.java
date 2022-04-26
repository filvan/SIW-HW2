package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column
	private Date dataDiNascita;
	
	@Column
	private String luogoDiNascita;
	
	@Column(nullable = false, unique = true)
	private String partitaIva;
	
	/* Fetch: generalmente, quando si consultano le informazioni relative a un docente, si vogliono conoscere anche i corsi insegnati
	 * Cascade: default (non ritengo strettamente necessaria l'applicazione di eventi in cascata) */
	@OneToMany(mappedBy = "docente", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Corso> corsi;
	
	public Docente() {
		this.corsi = new ArrayList<Corso>();
	}

	public Docente(String nome, String cognome, Date dataDiNascita, String luogoDiNascita, String partitaIva, List<Corso> corsi) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
		this.partitaIva = partitaIva;
		this.corsi =  new ArrayList<Corso>();
		this.corsi = corsi;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}
	
	@Override
	public boolean equals(Object obj) {
		Docente that = (Docente) obj;
		if (this.getNome().equals(that.getNome()))
			if (this.getCognome().equals(that.getCognome()))
				if (this.getDataDiNascita().equals(that.getDataDiNascita()))
					if (this.getLuogoDiNascita().equals(that.getLuogoDiNascita()))
						if (this.getPartitaIva().equals(that.getPartitaIva()))
							if (this.getCorsi().equals(that.getCorsi()))
								return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 * this.getNome().hashCode()
				+ this.getCognome().hashCode() 
				+ this.getDataDiNascita().hashCode() 
				+ this.getLuogoDiNascita().hashCode() 
				+ this.getPartitaIva().hashCode() 
				+ this.getCorsi().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Docente [id=");
		builder.append(this.getId());
		builder.append(", nome=");
		builder.append(this.getNome());
		builder.append(", cognome=");
		builder.append(this.getCognome());
		builder.append(", dataDiNascita=");
		builder.append(this.getDataDiNascita());
		builder.append(", luogoDiNascita=");
		builder.append(this.getLuogoDiNascita());
		builder.append(", partitaIva=");
		builder.append(this.getPartitaIva());
		builder.append(", corsi=");
		builder.append(this.getCorsi());
		builder.append("]");
		return builder.toString();
	}
}
