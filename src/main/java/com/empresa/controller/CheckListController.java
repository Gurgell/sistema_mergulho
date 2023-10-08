package com.empresa.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.empresa.diversos.MensagensJavaFx;
import com.empresa.entities.CheckList;
import com.empresa.entities.Mergulho;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;


public class CheckListController implements Initializable{

    //#region atributos
    public Mergulho mergulho;

    public CheckList checklist;

    private boolean incluindo;

    public void setIncluindo(Boolean incluindo){
        this.incluindo = incluindo;
    }

    @FXML
    private TextField txtNomeSupervisorCheckList;

    @FXML
    private CheckBox checkBox1;
    @FXML 
    private CheckBox checkBox2;
    @FXML
    private CheckBox checkBox3;
    @FXML
    private CheckBox checkBox4; 
    @FXML
    private CheckBox checkBox5; 
    @FXML
    private CheckBox checkBox6; 
    @FXML
    private CheckBox checkBox7; 
    @FXML
    private CheckBox checkBox8; 
    @FXML
    private CheckBox checkBox9; 
    @FXML
    private CheckBox checkBox10; 
    @FXML
    private CheckBox checkBox11; 
    @FXML
    private CheckBox checkBox12; 
    @FXML
    private CheckBox checkBox13; 
    @FXML
    private CheckBox checkBox14; 
    @FXML
    private CheckBox checkBox15; 
    @FXML
    private CheckBox checkBox16; 
    @FXML
    private CheckBox checkBox17; 
    @FXML
    private CheckBox checkBox18; 
    @FXML
    private CheckBox checkBox19;
    @FXML
    private CheckBox checkBox20; 
    @FXML
    private CheckBox checkBox21; 
    @FXML
    private CheckBox checkBox22; 
    @FXML
    private CheckBox checkBox23; 
    @FXML
    private CheckBox checkBox24; 
    @FXML
    private CheckBox checkBox25; 
    @FXML
    private CheckBox checkBox26; 
    @FXML
    private CheckBox checkBox27; 
    @FXML
    private CheckBox checkBox28; 
    @FXML
    private CheckBox checkBox29;
    @FXML 
    private CheckBox checkBox30;
    @FXML
    private CheckBox checkBox31; 
    @FXML
    private CheckBox checkBox32; 
    @FXML
    private CheckBox checkBox33; 
    @FXML
    private CheckBox checkBox34; 
    @FXML
    private CheckBox checkBox35; 
    @FXML
    private CheckBox checkBox36; 
    @FXML
    private CheckBox checkBox37; 
    @FXML
    private CheckBox checkBox38; 
    @FXML
    private CheckBox checkBox39; 
    @FXML
    private CheckBox checkBox40; 
    @FXML
    private CheckBox checkBox41; 
    @FXML
    private CheckBox checkBox42; 

    @FXML
    private Button btn_gravar_checklist;

    public void setMergulho(Mergulho mergulho){
        this.mergulho = mergulho;
    }

    public void setCheckList(CheckList checklist){
        this.checklist = checklist;
    }

    //#endregion


    public void mostrarDados(){
        if(this.checklist != null){
            
            checkBox1.setSelected(checklist.getResposta1_1()); checkBox2.setSelected(checklist.getResposta1_2());checkBox3.setSelected(checklist.getResposta1_3());
            checkBox4.setSelected(checklist.getResposta1_4()); checkBox5.setSelected(checklist.getResposta1_5());checkBox6.setSelected(checklist.getResposta1_6());
            checkBox7.setSelected(checklist.getResposta1_7()); checkBox8.setSelected(checklist.getResposta1_8());checkBox9.setSelected(checklist.getResposta1_9()); checkBox10.setSelected(checklist.getResposta1_10());

            checkBox11.setSelected(checklist.getResposta2_1()); checkBox12.setSelected(checklist.getResposta2_2());checkBox13.setSelected(checklist.getResposta2_3()); checkBox14.setSelected(checklist.getResposta2_4());
            checkBox15.setSelected(checklist.getResposta2_5()); checkBox16.setSelected(checklist.getResposta3_1());checkBox17.setSelected(checklist.getResposta3_2()); checkBox18.setSelected(checklist.getResposta3_3());

            checkBox19.setSelected(checklist.getResposta3_4()); checkBox20.setSelected(checklist.getResposta3_5());checkBox21.setSelected(checklist.getResposta4_1()); checkBox22.setSelected(checklist.getResposta4_2());
            checkBox23.setSelected(checklist.getResposta4_3());
            checkBox24.setSelected(checklist.getResposta4_4()); checkBox25.setSelected(checklist.getResposta5_1());checkBox26.setSelected(checklist.getResposta5_2()); checkBox27.setSelected(checklist.getResposta5_3());

            checkBox28.setSelected(checklist.getResposta5_4()); checkBox29.setSelected(checklist.getResposta5_5());checkBox30.setSelected(checklist.getResposta5_6()); checkBox31.setSelected(checklist.getResposta5_7());
            checkBox32.setSelected(checklist.getResposta5_8()); checkBox33.setSelected(checklist.getResposta5_9());checkBox34.setSelected(checklist.getResposta5_10()); checkBox35.setSelected(checklist.getResposta5_11());
            checkBox36.setSelected(checklist.getResposta5_12()); checkBox37.setSelected(checklist.getResposta5_13());checkBox38.setSelected(checklist.getResposta5_14()); checkBox39.setSelected(checklist.getResposta5_15());
            checkBox40.setSelected(checklist.getResposta5_16_1()); checkBox41.setSelected(checklist.getResposta5_16_2());checkBox42.setSelected(checklist.getResposta5_16_3()); 
 
        }
    }

    @FXML
    private void btn_gravar_checklist(ActionEvent event) throws IOException {
        try {
            if (incluindo){ //Caso seja um novo mergulho
                checklist = new CheckList(checkBox1.isSelected(), checkBox2.isSelected(), checkBox3.isSelected(),
                checkBox4.isSelected(), checkBox5.isSelected(), checkBox6.isSelected(),checkBox7.isSelected(),checkBox8.isSelected(),
                checkBox9.isSelected(),checkBox10.isSelected(),checkBox11.isSelected(),checkBox12.isSelected(), checkBox13.isSelected(),
                checkBox14.isSelected(),checkBox15.isSelected(),checkBox16.isSelected(),checkBox17.isSelected(),checkBox18.isSelected(),
                checkBox19.isSelected(),checkBox20.isSelected(),checkBox21.isSelected(),checkBox22.isSelected(),checkBox23.isSelected(),
                checkBox24.isSelected(),checkBox25.isSelected(),checkBox26.isSelected(),checkBox27.isSelected(),checkBox28.isSelected(),
                checkBox30.isSelected(),checkBox31.isSelected(),checkBox32.isSelected(),checkBox33.isSelected(),
                checkBox34.isSelected(),checkBox35.isSelected(),checkBox36.isSelected(),checkBox37.isSelected(),checkBox38.isSelected(), 
                checkBox40.isSelected(), mergulho.getId());

                
            }
            else{
                checklist.setResposta1_1(checkBox1.isSelected() ? true : false);
                checklist.setResposta1_2(checkBox2.isSelected() ? true : false);
                checklist.setResposta1_3(checkBox3.isSelected() ? true : false);
                checklist.setResposta1_4(checkBox4.isSelected() ? true : false);
                checklist.setResposta1_5(checkBox5.isSelected() ? true : false);
                checklist.setResposta1_6(checkBox6.isSelected() ? true : false);
                checklist.setResposta1_7(checkBox7.isSelected() ? true : false);
                checklist.setResposta1_8(checkBox8.isSelected() ? true : false);
                checklist.setResposta1_9(checkBox9.isSelected() ? true : false);
                checklist.setResposta1_10(checkBox10.isSelected() ? true : false);
                checklist.setResposta2_1(checkBox11.isSelected() ? true : false);
                checklist.setResposta2_2(checkBox12.isSelected() ? true : false);
                checklist.setResposta2_3(checkBox13.isSelected() ? true : false);
                checklist.setResposta2_4(checkBox14.isSelected() ? true : false);
                checklist.setResposta2_5(checkBox15.isSelected() ? true : false);
                checklist.setResposta3_1(checkBox16.isSelected() ? true : false);
                checklist.setResposta3_2(checkBox17.isSelected() ? true : false);
                checklist.setResposta3_3(checkBox18.isSelected() ? true : false);
                checklist.setResposta3_4(checkBox19.isSelected() ? true : false);
                checklist.setResposta3_5(checkBox20.isSelected() ? true : false);
                checklist.setResposta4_1(checkBox21.isSelected() ? true : false);
                checklist.setResposta4_2(checkBox22.isSelected() ? true : false);
                checklist.setResposta4_3(checkBox23.isSelected() ? true : false);
                checklist.setResposta4_4(checkBox24.isSelected() ? true : false);
                checklist.setResposta5_1(checkBox25.isSelected() ? true : false);
                checklist.setResposta5_2(checkBox26.isSelected() ? true : false);
                checklist.setResposta5_3(checkBox27.isSelected() ? true : false);
                checklist.setResposta5_4(checkBox28.isSelected() ? true : false);
                checklist.setResposta5_6(checkBox30.isSelected() ? true : false);
                checklist.setResposta5_7(checkBox31.isSelected() ? true : false);
                checklist.setResposta5_8(checkBox32.isSelected() ? true : false);
                checklist.setResposta5_9(checkBox33.isSelected() ? true : false);
                checklist.setResposta5_10(checkBox34.isSelected() ? true : false);
                checklist.setResposta5_11(checkBox35.isSelected() ? true : false);
                checklist.setResposta5_12(checkBox36.isSelected() ? true : false);
                checklist.setResposta5_13(checkBox37.isSelected() ? true : false);
                checklist.setResposta5_14(checkBox38.isSelected() ? true : false);
                checklist.setResposta5_16_1(checkBox40.isSelected() ? true : false);
            }
            checklist.setResposta5_5(checkBox29.isSelected() ? true : false);
            checklist.setResposta5_15(checkBox39.isSelected() ? true : false);
            checklist.setResposta5_16_2(checkBox41.isSelected() ? true : false);
            checklist.setResposta5_16_3(checkBox42.isSelected() ? true : false);

            mergulho.setChecklist(checklist);

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            MensagensJavaFx.exibirMensagemSucesso("CheckList gravado com sucesso!");

            
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem(e.toString(),"Atenção!", "Erro ao gravar o checklist, favor entrar em contato com o administrador!\"");
        }

        
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
