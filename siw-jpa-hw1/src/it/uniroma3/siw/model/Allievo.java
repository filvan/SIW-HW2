package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;

	@Column(nullable = false)
	private Date dataDiNascita;

	@Column(nullable = false)
	private String luogoDiNascita;

	@Column(nullable = false, unique = true)
	private String matricola;

	private String email;

	/* Fetch: default (eager)
	 * Cascade: default (non ritengo strettamente necessaria l'applicazione di eventi in cascata) */
	@ManyToOne
	@JoinColumn(name = "id_società")
	private Societa societa;

	/* Fetch: deafult (lazy load)
	 * Cascade: default (non ritengo strettamente necessaria l'applicazione di eventi in cascata) */
	@ManyToMany( /* mappedBy = "allievi" */ )
	private List<Corso> corsi;

	public Allievo() {

	}

	public Allievo(String nome, String cognome, Date dataDiNascita, String luogoDiNascita, String matricola, String email, Societa societa, List<Corso> corsi) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
		this.matricola = matricola;
		this.email = email;
		this.societa = societa;
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

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Societa getSocieta() {
		return societa;
	}

	public void setSocieta(Societa societa) {
		this.societa = societa;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	@Override
	public boolean equals(Object obj) {
		Allievo that = (Allievo) obj;
		if (this.getMatricola().equals(that.getMatricola()))
			return true;
		return false;
	}

	@Override
	public int hashCode() {
		return 31 * this.getMatricola().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Allievo [id=");
		builder.append(this.getId());
		builder.append(", nome=");
		builder.append(this.getNome());
		builder.append(", cognome=");
		builder.append(this.getCognome());
		builder.append(", dataDiNascita=");
		builder.append(this.getDataDiNascita());
		builder.append(", luogoDiNascita=");
		builder.append(this.getLuogoDiNascita());
		builder.append(", matricola=");
		builder.append(this.getMatricola());
		builder.append(", email=");
		builder.append(this.getEmail());
		builder.append(", societa=");
		builder.append(this.getSocieta());
		builder.append(", corsi=");
		builder.append(this.getCorsi());
		builder.append("]");
		return builder.toString();
	}
}
