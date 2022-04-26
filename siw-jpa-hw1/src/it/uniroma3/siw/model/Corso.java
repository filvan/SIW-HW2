package it.uniroma3.siw.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Corso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column
	private Date dataInizio;

	@Column
	private Integer durataInMesi;

	/* Fetch: default (lazy load)
	 * Cascade: default (non ritengo strettamente necessaria l'applicazione di eventi in cascata) */
	// @ManyToMany
	// private List<Allievo> allievi;

	/* Fetch: default (eager)
	 * Cascade: c'è una forte dipendenza del corso dal docente. Inoltre, di solito, non possono esistere corsi con cattedra scoperta. 
	 * Perciò ha senso che le operazioni di persist di corso si propaghino anche sul suo docente. */
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Docente docente;

	public Corso() {

	}

	public Corso(String nome, Date dataInizio, Integer durataInMesi, List<Allievo> allievi, Docente docente) {
		this.nome = nome;
		this.dataInizio = dataInizio;
		this.durataInMesi = durataInMesi;
//		this.allievi = allievi;
		this.docente = docente;
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

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Integer getDurataInMesi() {
		return durataInMesi;
	}

	public void setDurataInMesi(Integer durataInMesi) {
		this.durataInMesi = durataInMesi;
	}

//	public List<Allievo> getAllievi() {
//		return allievi;
//	}
//
//	public void setAllievi(List<Allievo> allievi) {
//		this.allievi = allievi;
//	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	@Override
	public boolean equals(Object obj) {
		Corso that = (Corso) obj;
		if (this.getNome().equals(that.getNome()))
			if (this.getDataInizio().equals(that.getDataInizio()))
				if (this.getDurataInMesi().equals(that.getDurataInMesi()))
//					if (this.getAllievi().equals(that.getAllievi()))
						if (this.getDocente().equals(that.getDocente()))
							return true;
		return false;
	}

	@Override
	public int hashCode() {
		return 31 * this.getNome().hashCode() 
				+ this.getDataInizio().hashCode() 
				+ this.getDurataInMesi().hashCode() 
//				+ this.getAllievi().hashCode()
				+ this.getDocente().hashCode();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Corso [id=");
		builder.append(this.getId());
		builder.append(", nome=");
		builder.append(this.getNome());
		builder.append(", dataInizio=");
		builder.append(this.getDataInizio());
		builder.append(", durataInMesi=");
		builder.append(this.getDurataInMesi());
		builder.append(", allievi=");
//		builder.append(this.getAllievi());
		builder.append(", docente=");
		builder.append(this.getDocente());
		builder.append("]");
		return builder.toString();
	}
}
