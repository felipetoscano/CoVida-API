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
@Table(name = "bots")
public class BotModel {
	
	private int id;
	private String name;
	private String welcomeMessage;
	private String farewellMessage;
	private String defaultMessage;
	private int downtimeMinutes;
	
	public BotModel() {
		
	}
	
	public BotModel(String name, String welcomeMessage, String farewellMessage, String defaultMessage, int downtimeMinutes) {
		super();
		this.name = name;
		this.welcomeMessage = welcomeMessage;
		this.farewellMessage = farewellMessage;
		this.defaultMessage = defaultMessage;
		this.downtimeMinutes = downtimeMinutes;
	}

	@Id
	@Column(name = "id_bot")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bots")
	@SequenceGenerator(name = "seq_bots", sequenceName = "seq_bots", initialValue = 1, allocationSize = 1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotNull(message = "Nome deve ser obrigatório!")
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull(message = "Mensagem de boas vindas deve ser obrigatória!")
	@Column(name = "welcome_message")
	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	@NotNull(message = "Mensagem de despedida deve ser obrigatória!")
	@Column(name = "farewell_message")
	public String getFarewellMessage() {
		return farewellMessage;
	}

	public void setFarewellMessage(String farewellMessage) {
		this.farewellMessage = farewellMessage;
	}

	@NotNull(message = "Mensagem padrão deve ser obrigatória!")
	@Column(name = "default_message")
	public String getDefaultMessage() {
		return defaultMessage;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

	@Column(name = "downtime_minutes")
	public int getDowntimeMinutes() {
		return downtimeMinutes;
	}

	public void setDowntimeMinutes(int downtimeMinutes) {
		this.downtimeMinutes = downtimeMinutes;
	}	
}
