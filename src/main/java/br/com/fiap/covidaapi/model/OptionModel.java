package br.com.fiap.covidaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class OptionModel {

    private int idOption;
    private String nameOption;
    private String message;
    private int idSegment;

    public OptionModel(){

    }

    @Id
    @Column(name = "id_option")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_options")
    @SequenceGenerator(name = "seq_options", sequenceName = "seq_options", initialValue = 1, allocationSize = 1)
    public int getIdOption() {
        return idOption;
    }

    public void setIdOption(int idOption) {
        this.idOption = idOption;
    }

    @Column(name = "name_option")
    public String getNameOption() {
        return nameOption;
    }

    public void setNameOption(String nameOption) {
        this.nameOption = nameOption;
    }

    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name = "id_segment")
    public int getIdSegment() {
        return idSegment;
    }

    public void setIdSegment(int idSegment) {
        this.idSegment = idSegment;
    }
}
