package com.empresa.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Mergulho mergulho;
    
    private Long idMergulho;
    //Chekcboxes
    private Boolean resposta1_1; //1
    private Boolean resposta1_2; //2
    private Boolean resposta1_3; //3
    private Boolean resposta1_4; //4
    private Boolean resposta1_5; //5
    private Boolean resposta1_6; //6
    private Boolean resposta1_7; //7
    private Boolean resposta1_8; //8
    private Boolean resposta1_9; //9
    private Boolean resposta1_10; //10
    private Boolean resposta2_1; //11
    private Boolean resposta2_2; //12
    private Boolean resposta2_3; //13
    private Boolean resposta2_4; //14
    private Boolean resposta2_5; //15
    private Boolean resposta3_1; //16
    private Boolean resposta3_2; //17
    private Boolean resposta3_3; //18
    private Boolean resposta3_4; //19
    private Boolean resposta3_5; //20
    private Boolean resposta4_1; //21
    private Boolean resposta4_2; //22
    private Boolean resposta4_3; //23
    private Boolean resposta4_4; //24
    private Boolean resposta5_1; //25
    private Boolean resposta5_2; //26
    private Boolean resposta5_3; //27
    private Boolean resposta5_4; //28
    private Boolean resposta5_5; 
    private Boolean resposta5_6; //30
    private Boolean resposta5_7; //31
    private Boolean resposta5_8; //32
    private Boolean resposta5_9; //33
    private Boolean resposta5_10; //34
    private Boolean resposta5_11; //35
    private Boolean resposta5_12; //36
    private Boolean resposta5_13; //37
    private Boolean resposta5_14; //38
    private Boolean resposta5_15; 
    private Boolean resposta5_16_1; //40
    private Boolean resposta5_16_2; 
    private Boolean resposta5_16_3; 

    public CheckList(Boolean resposta1_1, Boolean resposta1_2, Boolean resposta1_3,
        Boolean resposta1_4, Boolean resposta1_5, Boolean resposta1_6, Boolean resposta1_7, Boolean resposta1_8,
        Boolean resposta1_9, Boolean resposta1_10, Boolean resposta2_1, Boolean resposta2_2, Boolean resposta2_3,
        Boolean resposta2_4, Boolean resposta2_5, Boolean resposta3_1, Boolean resposta3_2, Boolean resposta3_3,
        Boolean resposta3_4, Boolean resposta3_5, Boolean resposta4_1, Boolean resposta4_2, Boolean resposta4_3, Boolean resposta4_4,
        Boolean resposta5_1, Boolean resposta5_2, Boolean resposta5_3, Boolean resposta5_4, Boolean resposta5_6,
        Boolean resposta5_7, Boolean resposta5_8, Boolean resposta5_9, Boolean resposta5_10, Boolean resposta5_11,
        Boolean resposta5_12, Boolean resposta5_13, Boolean resposta5_14, Boolean resposta5_16_1, Long idMergulho) 
        {
        this.resposta1_1 = resposta1_1;  
        this.resposta1_2 = resposta1_2;
        this.resposta1_3 = resposta1_3;
        this.resposta1_4 = resposta1_4;
        this.resposta1_5 = resposta1_5;
        this.resposta1_6 = resposta1_6;
        this.resposta1_7 = resposta1_7;
        this.resposta1_8 = resposta1_8;
        this.resposta1_9 = resposta1_9;
        this.resposta1_10 = resposta1_10;
        this.resposta2_1 = resposta2_1;
        this.resposta2_2 = resposta2_2;
        this.resposta2_3 = resposta2_3;
        this.resposta2_4 = resposta2_4;
        this.resposta2_5 = resposta2_5;
        this.resposta3_1 = resposta3_1;
        this.resposta3_2 = resposta3_2;
        this.resposta3_3 = resposta3_3;
        this.resposta3_4 = resposta3_4;
        this.resposta3_5 = resposta3_5;
        this.resposta4_1 = resposta4_1;
        this.resposta4_2 = resposta4_2;
        this.resposta4_3 = resposta4_3;
        this.resposta4_4 = resposta4_4;
        this.resposta5_1 = resposta5_1;
        this.resposta5_2 = resposta5_2;
        this.resposta5_3 = resposta5_3;
        this.resposta5_4 = resposta5_4;
        this.resposta5_6 = resposta5_6;
        this.resposta5_7 = resposta5_7;
        this.resposta5_8 = resposta5_8;
        this.resposta5_9 = resposta5_9;
        this.resposta5_10 = resposta5_10;
        this.resposta5_11 = resposta5_11;
        this.resposta5_12 = resposta5_12;
        this.resposta5_13 = resposta5_13;
        this.resposta5_14 = resposta5_14;
        this.resposta5_16_1 = resposta5_16_1;

        this.idMergulho = idMergulho;

    } 

    
    @Override
    public String toString(){
        return "Mergulho: " + this.mergulho.getId()
        + "\nChecklist: " + id;
        
    }
}

    