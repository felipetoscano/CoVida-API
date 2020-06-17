package br.com.fiap.covidaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "segments")
public class SegmentModel {
	
	private int id;
	private String name;
	private int idBot;
	
	public SegmentModel() {
		
	}
	
	public SegmentModel(String name) {
		super();
		this.name = name;
	}
	
	@Id
	@Column(name = "id_segment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_segments")
	@SequenceGenerator(name = "seq_segments", sequenceName = "seq_segments", initialValue = 1, allocationSize = 1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotNull(message = "O nome deve ser obrigatório!")
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "id_bot")
	public int getIdBot() {
		return idBot;
	}

	public void setIdBot(int idBot) {
		this.idBot = idBot;
	}
}
