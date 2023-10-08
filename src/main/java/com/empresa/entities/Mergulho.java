package com.empresa.entities;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Mergulho {
    //Informação do mergulho
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String dupla;

    @OneToOne(cascade = CascadeType.ALL)
    public CheckList checklist;

    @ManyToOne
    private Rom rom;

    //Informações mergulhador 1
    protected String mergulhadorUmNome;
    protected String mergulhadorUmIdCapacete;
    protected String mergulhadorUmIdNeckDam;
    protected String mergulhadorUmTamanho;

    //Informações mergulhador 2
    protected String mergulhadorDoisNome;
    protected String mergulhadorDoisIdCapacete;
    protected String mergulhadorDoisIdNeckDam;
    protected String mergulhadorDoisTamanho;

    protected Integer numeroDoMergulho; //Numero sequencial

    //Informações sobre o mergulho
    protected String deixouSuperficie; //Hora e minuto
    protected String deixouFundo; //Hora e minuto
    protected String chegouSuperficie; //Hora e minuto
    protected String tempoDeFundo; //Hora e minuto
    protected Double profundidade; //Em metros
    protected String tab; //Formato ##/##
    protected String grupoRepetitivo; // G.R
    protected String intervaloDeSuperficie; // I.R
    protected String grupoRepetitivoAnterior; // G.R.A
    protected String novoGrupoRepetitivo; // N.G.R
    protected String tempoNitrogenioResidual; // T.N.R
    protected Double temperaturaCelsius; 

    protected Double correnteza; //Em nós
    protected Double vento; //Em nós
    protected Double swell; //Em metros

    //Informações sobre os outros mergulhadores/supervisores. São 7 nomes
    protected String supervisor; 
    protected String supervisorAssistente; 
    protected String operadorGuincho; 
    protected String mergulhadorQuadros;
    protected String operadorCompressor;
    protected String mergulhadorDeEmergencia;
    protected String mergulhadorDeEmed;


    //Parte dos bailouts
    //Bailout Merg. 01	
    protected Double bailoutMergUmVolume;
    protected Double bailoutMergUmPressao;
    protected Double bailoutMergUmAutonomia;

    //Bailout Merg. 02
    protected Double bailoutMergDoisVolume;
    protected Double bailoutMergDoisPressao;
    protected Double bailoutMergDoisAutonomia;

    //Bailout Merg. 03
    protected Double bailoutMergTresVolume;
    protected Double bailoutMergTresPressao;
    protected Double bailoutMergTresAutonomia;

    //Cilindro Emerg. Merg.01 (C/S)	
    protected Double cilindroEmergencialMergUmVolume;
    protected Double cilindroEmergencialMergUmPressao;
    protected Double cilindroEmergencialMergUmAutonomia;

    //Cilindro Emerg. Merg.02 (C/S)	
    protected Double cilindroEmergencialMergDoisVolume;
    protected Double cilindroEmergencialMergDoisPressao;
    protected Double cilindroEmergencialMergDoisAutonomia;

    //E. Painel / Suprimento  S. M3	
    protected Double ePainelOuSuprimentoVolume;
    protected Double ePainelOuSuprimentoPressao;
    protected Double cePainelOuSuprimentoAutonomia;
    
    //Descrição do serviço/notas
    protected String descricaoServicoOuNotas;
    protected String procedimentosReferencia;
    
    //Conversão PSI/BAR
    protected Double psi;
    protected Double valorBar;
    protected Double valorKgfPorCm;

    public Mergulho(String dupla, String mergulhadorUmNome, String mergulhadorUmIdCapacete, String mergulhadorUmIdNeckDam,
            String mergulhadorUmTamanho, String mergulhadorDoisNome, String mergulhadorDoisIdCapacete,
            String mergulhadorDoisIdNeckDam, String mergulhadorDoisTamanho, Integer numeroDoMergulho,
            String deixouSuperficie, String deixouFundo, String chegouSuperficie, String tempoDeFundo,
            Double profundidade, String tab, String grupoRepetitivo, String intervaloDeSuperficie, String grupoRepetitivoAnterior,
            String novoGrupoRepetitivo, String tempoNitrogenioResidual, Double temperaturaCelsius, Double correnteza,
            Double vento, Double swell, String supervisor, String supervisorAssistente, String operadorGuincho,
            String mergulhadorQuadros, String operadorCompressor, String mergulhadorDeEmergencia,
            String mergulhadorDeEmed, Double bailoutMergUmVolume, Double bailoutMergUmPressao,
            Double bailoutMergUmAutonomia, Double bailoutMergDoisVolume, Double bailoutMergDoisPressao,
            Double bailoutMergDoisAutonomia, Double bailoutMergTresVolume, Double bailoutMergTresPressao,
            Double bailoutMergTresAutonomia, Double cilindroEmergencialMergUmVolume,
            Double cilindroEmergencialMergUmPressao, Double cilindroEmergencialMergUmAutonomia,
            Double cilindroEmergencialMergDoisVolume, Double cilindroEmergencialMergDoisPressao,
            Double cilindroEmergencialMergDoisAutonomia, Double ePainelOuSuprimentoVolume,
            Double ePainelOuSuprimentoPressao, Double cePainelOuSuprimentoAutonomia, String descricaoServicoOuNotas,
            String procedimentosReferencia, Double psi, Double valorBar, Double valorKgfPorCm) 
    {
        this.dupla = dupla;
        
        this.mergulhadorUmNome = mergulhadorUmNome;
        this.mergulhadorUmIdCapacete = mergulhadorUmIdCapacete;
        this.mergulhadorUmIdNeckDam = mergulhadorUmIdNeckDam;
        this.mergulhadorUmTamanho = mergulhadorUmTamanho;
        this.mergulhadorDoisNome = mergulhadorDoisNome;
        this.mergulhadorDoisIdCapacete = mergulhadorDoisIdCapacete;
        this.mergulhadorDoisIdNeckDam = mergulhadorDoisIdNeckDam;
        this.mergulhadorDoisTamanho = mergulhadorDoisTamanho;
        this.numeroDoMergulho = numeroDoMergulho;

        this.profundidade = profundidade;
        this.tab = tab;
        this.grupoRepetitivo = grupoRepetitivo;
        this.intervaloDeSuperficie = intervaloDeSuperficie;
        this.grupoRepetitivoAnterior = grupoRepetitivoAnterior;
        this.novoGrupoRepetitivo = novoGrupoRepetitivo;
        this.tempoNitrogenioResidual = tempoNitrogenioResidual;
        this.temperaturaCelsius = temperaturaCelsius;
        this.correnteza = correnteza;
        this.vento = vento;
        this.swell = swell;
        this.supervisor = supervisor;
        this.supervisorAssistente = supervisorAssistente;
        this.operadorGuincho = operadorGuincho;
        this.mergulhadorQuadros = mergulhadorQuadros;
        this.operadorCompressor = operadorCompressor;
        this.mergulhadorDeEmergencia = mergulhadorDeEmergencia;
        this.mergulhadorDeEmed = mergulhadorDeEmed;
        this.bailoutMergUmVolume = bailoutMergUmVolume;
        this.bailoutMergUmPressao = bailoutMergUmPressao;
        this.bailoutMergUmAutonomia = bailoutMergUmAutonomia;
        this.bailoutMergDoisVolume = bailoutMergDoisVolume;
        this.bailoutMergDoisPressao = bailoutMergDoisPressao;
        this.bailoutMergDoisAutonomia = bailoutMergDoisAutonomia;
        this.bailoutMergTresVolume = bailoutMergTresVolume;
        this.bailoutMergTresPressao = bailoutMergTresPressao;
        this.bailoutMergTresAutonomia = bailoutMergTresAutonomia;
        this.cilindroEmergencialMergUmVolume = cilindroEmergencialMergUmVolume;
        this.cilindroEmergencialMergUmPressao = cilindroEmergencialMergUmPressao;
        this.cilindroEmergencialMergUmAutonomia = cilindroEmergencialMergUmAutonomia;
        this.cilindroEmergencialMergDoisVolume = cilindroEmergencialMergDoisVolume;
        this.cilindroEmergencialMergDoisPressao = cilindroEmergencialMergDoisPressao;
        this.cilindroEmergencialMergDoisAutonomia = cilindroEmergencialMergDoisAutonomia;
        this.ePainelOuSuprimentoVolume = ePainelOuSuprimentoVolume;
        this.ePainelOuSuprimentoPressao = ePainelOuSuprimentoPressao;
        this.cePainelOuSuprimentoAutonomia = cePainelOuSuprimentoAutonomia;
        this.descricaoServicoOuNotas = descricaoServicoOuNotas;
        this.procedimentosReferencia = procedimentosReferencia;
        this.psi = psi;
        this.valorBar = valorBar;
        this.valorKgfPorCm = valorKgfPorCm;

        this.deixouSuperficie = deixouSuperficie;
        this.deixouFundo = deixouFundo;
        this.chegouSuperficie = chegouSuperficie;
        this.tempoDeFundo = tempoDeFundo;

    }

    public static LocalTime converterParaLocalTime(String hhMM){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime tempo = LocalTime.parse(hhMM, formatter);
        return tempo;
    }

    @Override
    public String toString(){
        return "Número do mergulho: " + this.numeroDoMergulho + 
        "\nMergulhador 1: " + this.mergulhadorUmNome + 
        "\nMergulhador 2: " + this.mergulhadorDoisNome +
        "\nDupla: " + this.dupla;
    }
    
}
