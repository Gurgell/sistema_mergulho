package com.empresa.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import com.empresa.dao.DaoRom;
import com.empresa.diversos.MensagensJavaFx;
import com.empresa.entities.Rom;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class RomController implements Initializable {

    @FXML
    private ListView<Rom> listaRom;

    @FXML
    private DatePicker dataInicio;

    @FXML
    private DatePicker dataFim;

    private Rom rom = new Rom();

    DaoRom daoRom = new DaoRom();

    protected void exibirDadosListaRoms(){

        List<Rom> roms = daoRom.buscarTodos();
        ObservableList<Rom> data = FXCollections.observableArrayList(roms);

        listaRom.setItems(data);
    }

    @FXML
    public void btn_filtrarData(ActionEvent event){
        try {
            if (!(dataInicio.getValue().isAfter(dataFim.getValue()))){
                List<Rom> romsPorData = DaoRom.buscarPorData(dataInicio.getValue(), dataFim.getValue());
                listaRom.setItems(FXCollections.observableArrayList(romsPorData));
                return;
            }

            MensagensJavaFx.exibirMensagem("A data de ínicio deve ser anterior a data fim para filtrar!", "Atenção!", "Erro!");
        
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem("Selecione duas datas para filtrar adequadamente", "Atenção!", "Erro!");
        }
    }

    @FXML
    public void btn_desfazerFiltro(ActionEvent event){
        dataFim.setValue(null);
        dataInicio.setValue(null);
        exibirDadosListaRoms();
    }

    @FXML
    public void btn_iniciarRom(ActionEvent event){
        try {
            if (MensagensJavaFx.exibirConfirmacao("Tem certeza que deseja iniciar uma nova ROM?", "Iniciar nova ROM", "Confirmação")){

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Mergulho.fxml"));
                Parent root = loader.load();

                MergulhoController mergulhoController = loader.getController();
                
                Rom novaRom = new Rom();
                mergulhoController.setRom(novaRom);
                mergulhoController.exibirDadosListaMergulhos();
                mergulhoController.setAlterandoRom(false);

                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("Tela de cadastro - Mergulhos");

                // Define a cena da nova janela
                Scene scene = new Scene(root);
                stage.setScene(scene);

                //Fechando a janela atual
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();
                
                // Exibe a nova janela como um diálogo modal
                stage.show();
            }      

        } catch (Exception e) {
        }
    }

    @FXML
    public void btn_alterarRom(ActionEvent event) throws IOException{
        if (listaRom.getSelectionModel().getSelectedItem() != null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Mergulho.fxml")); 
            Parent root = loader.load();

            MergulhoController mergulhoController = loader.getController();

            mergulhoController.setRom(listaRom.getSelectionModel().getSelectedItem());

            mergulhoController.setAlterandoRom(true);

            mergulhoController.exibirDadosRom();
            mergulhoController.exibirDadosListaMergulhos();

            Stage stage = new Stage();
            
            stage.setResizable(false);
            stage.setTitle("Tela de cadastro - Mergulhos");

            Scene scene = new Scene(root);
            stage.setScene(scene);
            

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
            // Exibe a nova janela como um diálogo modal
            stage.show();  
        }
        else{
            MensagensJavaFx.exibirMensagemAlerta("Selecione uma ROM para alterar!", "Atenção!", "Alerta");
        }
    }

    @FXML
    public void btn_excluirRom(ActionEvent event) throws IOException{
        
        if (listaRom.getSelectionModel().getSelectedItem() != null){
            if(MensagensJavaFx.exibirConfirmacao("Tem certeza que deseja excluir a ROM selecionada?", "Exclusão de ROM", "Confirmação")){
                this.rom = listaRom.getSelectionModel().getSelectedItem();

                daoRom.apagar(rom);

                exibirDadosListaRoms();
            }
        }
        else{
            MensagensJavaFx.exibirMensagemAlerta("Selecione uma ROM para excluir!", "Atenção!", "Aviso");
        }
        
    }

    @FXML
    public void btn_limpar(ActionEvent event) throws IOException{
        listaRom.getSelectionModel().clearSelection();
        dataFim.setValue(null);
        dataInicio.setValue(null);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exibirDadosListaRoms();
    }
    
}
