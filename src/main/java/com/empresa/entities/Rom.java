package com.empresa.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Rom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String embarcacaoOuPlataforma;
    private String localizacao;
    private LocalDate data;
    private String contratante;
    private String nomeResponsavel;

    private String observacoes;
    private String nomeSupervisor;

    @Transient
    private String dataFormatada;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Mergulho> listaDeMergulhos = new ArrayList<Mergulho>();

    public Rom(String embarcacaoOuPlataforma, String localizacao, LocalDate data, String contratante, String nomeResponsavel, String nomeSupervisor){
        this.embarcacaoOuPlataforma = embarcacaoOuPlataforma;
        this.localizacao = localizacao;
        this.data = data;
        this.contratante = contratante;
        this.nomeResponsavel = nomeResponsavel;
        this.nomeSupervisor = nomeSupervisor;
    }

    @PostLoad
    public void formatarData(){
        try {
            DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataFormatada = data.format(formatoSaida);
        } catch (Exception e) {
            
        }
    }

    @Override
    public String toString(){
        try {
            return "Embarcação ou plataforma: " + this.embarcacaoOuPlataforma
            + "\nData: " + dataFormatada
            + "\nContratante: " + this.contratante
            + "\nQuantidade de mergulhos: " + listaDeMergulhos.size();
        } catch (Exception e) {
            
        }
        return "";
        
    }
}
