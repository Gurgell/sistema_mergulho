package com.empresa.controller;


import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

import com.empresa.dao.DaoCheckList;
import com.empresa.dao.DaoMergulho;
import com.empresa.dao.DaoRom;
import com.empresa.diversos.GeradorTooltip;
import com.empresa.diversos.MensagensJavaFx;
import com.empresa.entities.CheckList;
import com.empresa.entities.Mergulho;
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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MergulhoController implements Initializable {

    
    //#region Declaração de variáveis do sceneBuilder
    DaoMergulho dao = new DaoMergulho();

    public Boolean alterandoRom;

    public void setAlterandoRom(Boolean valor){
        this.alterandoRom = valor;
    }

    public Boolean getAlterandoRom(){
        return this.alterandoRom;
    }

    protected Rom rom;

    public void setRom(Rom rom){
        this.rom = rom;
    }

    protected Mergulho mergulho;

    protected CheckList checklist;

    public CheckList getCheckList(){
        return this.checklist;
    }
    public void setCheckList(CheckList checkList){
        this.checklist = checkList;
    }

    //Dados da ROM
    @FXML
    private DatePicker dpRom;

    @FXML
    private TextField txtEmbarcacao;

    @FXML
    private TextField txtLocalizacao;

    @FXML
    private TextField txtContratante;

    @FXML
    private TextField txtNomeResponsavel;

    @FXML
    private TextField txtSupervisorRom;

    @FXML
    private TextArea txtObservacoesRom;

    
    //Dados dos textos do pane, para que possa usar o tooltip.
    @FXML
    private Text textoDeixouSuperficie;

    @FXML
    private Text textoDeixouFundo;

    @FXML
    private Text textoChegouSuperficie;

    @FXML
    private Text textoTempoFundo;

    @FXML
    private Text textoProfundidade;

    @FXML
    private Text textoTab;

    @FXML
    private Text textoGr;
    
    @FXML
    private Text textoIs;

    @FXML
    private Text textoGra;

    @FXML
    private Text textoNgr;

    @FXML
    private Text textoTnr;

    @FXML
    private Text textoTemp;

    @FXML
    private Text textoPSI;

    @FXML
    private Text textoBAR;

    @FXML
    private Text textoKGFCM;

    @FXML
    private Text textoCorrenteza;

    @FXML
    private Text textoVento;

    @FXML
    private Text textoSwell;

    //Dados mergulhador 1
    @FXML
    private TextField txtNomeM1;

    @FXML
    private TextField txtidcap1;

    @FXML
    private TextField txtidneckdam1;

    @FXML
    private TextField txtTamanho1;

    //Dados mergulhador 2
    @FXML
    private TextField txtNomeM2;

    @FXML
    private TextField txtidcap2;

    @FXML
    private TextField txtidneckdam2;

    @FXML
    private TextField txtTamanho2;

    //Dados sobre o mergulho
    @FXML 
    private TextField txtDupla;

    @FXML
    private TextField txtNumeroMergulho;

    @FXML
    private TextField txtds;

    @FXML
    private TextField txtdf;

    @FXML
    private TextField txtcs;

    @FXML
    private TextField txttf;

    @FXML
    private TextField txtprof;

    @FXML
    private TextField txttab;

    //Dados sobre o mergulho linha 2
    @FXML
    private TextField txtgr;

    @FXML
    private TextField txtis;

    @FXML
    private TextField txtgra;

    @FXML
    private TextField txtngr;

    @FXML
    private TextField txttnr;

    @FXML
    private TextField txttemp;

    //dados sobre a condição do tempo, clima e mar
    @FXML
    private TextField txtcorrenteza;

    @FXML
    private TextField txtvento;

    @FXML
    private TextField txtswell;

    //dados sobre os outros funcionarios
    @FXML
    private TextField txtsupervisor;

    @FXML
    private TextField txtsupervisorassist;

    @FXML
    private TextField txtoperador;

    @FXML
    private TextField txtmergulhadorquadros;

    @FXML
    private TextField txtmergulhadoremergencia;

    @FXML
    private TextField txtoperadorcompressor;

    @FXML
    private TextField txtmergulhadoremed;

    //Dados sobre pressão, volume e autonomia
    //Bailout mergulhador 1
    @FXML
    private TextField txtvolumebm1;

    @FXML
    private TextField txtpressaobm1;

    @FXML
    private TextField txtautonomiabm1;

    //Bailout mergulhador 2
    @FXML
    private TextField txtvolumebm2;

    @FXML
    private TextField txtpressaobm2;

    @FXML
    private TextField txtautonomiabm2;

    //Bailout mergulhador 3
    @FXML
    private TextField txtvolumebm3;

    @FXML
    private TextField txtpressaobm3;

    @FXML
    private TextField txtautonomiabm3;

    //Cilindro Emerg. Merg.01 (C/S)
    @FXML
    private TextField txtvolumecilindro1;

    @FXML
    private TextField txtpressaocilindro1;

    @FXML
    private TextField txtautonomiacilindro1;

    //Cilindro Emerg. Merg.02 (C/S)
    @FXML
    private TextField txtvolumecilindro2;

    @FXML
    private TextField txtpressaocilindro2;

    @FXML
    private TextField txtautonomiacilindro2;

    //E. Painel / Suprimento  S. M3
    @FXML
    private TextField txtvolumesuprimento;

    @FXML
    private TextField txtpressaosuprimento;

    @FXML
    private TextField txtautonomiasuprimento;

    //Conversão para PSI/BAR
    @FXML
    private TextField txtpsi;

    @FXML
    private TextField txtbar;

    @FXML
    private TextField txtkgf;

    //Descrição
    @FXML
    private TextArea txtdescricao;

    @FXML
    private TextArea txtreferencia;

    @FXML
    private ListView<Mergulho> listaMergulhos;

    private boolean incluindo;

    @FXML
    private Button btn_alterar;

    @FXML
    private Button btn_incluir;

    @FXML
    private Button btn_excluir_mergulho;

    @FXML
    private Button btn_cancelar_acoes;

    @FXML
    private Button btn_gravar_mergulho;

    @FXML 
    private Button btn_checklist;

    @FXML 
    private Button btn_gravarRom;
    //#endregion

    //#region Botões do CRUD
    @FXML
    private void btn_gravar_mergulho(ActionEvent event){
        try {
            if (!(mergulho.getChecklist() == null)){
                mergulho.setDupla(txtDupla.getText()); mergulho.setMergulhadorUmNome(txtNomeM1.getText()); mergulho.setMergulhadorUmIdCapacete(txtidcap1.getText()); mergulho.setMergulhadorUmIdNeckDam(txtidneckdam1.getText()); mergulho.setMergulhadorUmTamanho(txtTamanho1.getText()); 
                mergulho.setMergulhadorDoisNome(txtNomeM2.getText()); mergulho.setMergulhadorDoisIdCapacete(txtidcap2.getText()); mergulho.setMergulhadorDoisIdNeckDam(txtidneckdam2.getText()); mergulho.setMergulhadorDoisTamanho(txtTamanho2.getText()); mergulho.setNumeroDoMergulho(Integer.parseInt(txtNumeroMergulho.getText())); mergulho.setDeixouSuperficie(txtds.getText()); 
                mergulho.setDeixouFundo(txtdf.getText()); mergulho.setChegouSuperficie(txtcs.getText()); mergulho.setTempoDeFundo(txttf.getText()); mergulho.setProfundidade(Double.parseDouble(txtprof.getText())); mergulho.setTab((txttab.getText())); mergulho.setGrupoRepetitivo(txtgr.getText()); mergulho.setIntervaloDeSuperficie(txtis.getText()); mergulho.setGrupoRepetitivoAnterior(txtgra.getText()); 
                mergulho.setNovoGrupoRepetitivo(txtngr.getText()); mergulho.setTempoNitrogenioResidual(txttnr.getText()); mergulho.setTemperaturaCelsius(Double.parseDouble(txttemp.getText())); mergulho.setCorrenteza(Double.parseDouble(txtcorrenteza.getText())); mergulho.setVento(Double.parseDouble(txtvento.getText())); mergulho.setSwell(Double.parseDouble(txtswell.getText())); mergulho.setSupervisor(txtsupervisor.getText()); mergulho.setSupervisorAssistente(txtsupervisorassist.getText()); mergulho.setOperadorGuincho(txtoperador.getText()); 
                mergulho.setMergulhadorQuadros(txtmergulhadorquadros.getText()); mergulho.setOperadorCompressor(txtoperadorcompressor.getText()); mergulho.setMergulhadorDeEmergencia(txtmergulhadoremergencia.getText()); mergulho.setMergulhadorDeEmed(txtmergulhadoremed.getText()); mergulho.setBailoutMergUmVolume(Double.parseDouble(txtvolumebm1.getText())); mergulho.setBailoutMergUmPressao(Double.parseDouble(txtpressaobm1.getText())); 
                mergulho.setBailoutMergUmAutonomia(Double.parseDouble(txtautonomiabm1.getText())); mergulho.setBailoutMergDoisVolume(Double.parseDouble(txtvolumebm2.getText())); mergulho.setBailoutMergDoisPressao(Double.parseDouble(txtpressaobm2.getText())); mergulho.setBailoutMergDoisAutonomia(Double.parseDouble(txtautonomiabm2.getText())); mergulho.setBailoutMergTresVolume(Double.parseDouble(txtvolumebm3.getText())); mergulho.setBailoutMergTresPressao(Double.parseDouble(txtpressaobm3.getText()));
                mergulho.setBailoutMergTresAutonomia(Double.parseDouble(txtautonomiabm3.getText())); mergulho.setCilindroEmergencialMergUmVolume(Double.parseDouble(txtvolumecilindro1.getText())); mergulho.setCilindroEmergencialMergUmPressao(Double.parseDouble(txtpressaocilindro1.getText())); mergulho.setCilindroEmergencialMergUmAutonomia(Double.parseDouble(txtautonomiacilindro1.getText())); 
                mergulho.setCilindroEmergencialMergDoisVolume(Double.parseDouble(txtvolumecilindro2.getText())); mergulho.setCilindroEmergencialMergDoisPressao(Double.parseDouble(txtpressaocilindro2.getText())); mergulho.setCilindroEmergencialMergDoisAutonomia(Double.parseDouble(txtautonomiacilindro2.getText())); mergulho.setEPainelOuSuprimentoVolume(Double.parseDouble(txtvolumesuprimento.getText())); 
                mergulho.setEPainelOuSuprimentoPressao(Double.parseDouble(txtpressaosuprimento.getText())); mergulho.setCePainelOuSuprimentoAutonomia(Double.parseDouble(txtautonomiasuprimento.getText())); mergulho.setDescricaoServicoOuNotas(txtdescricao.getText()); mergulho.setProcedimentosReferencia(txtreferencia.getText()); mergulho.setPsi(Double.parseDouble(txtpsi.getText())); mergulho.setValorBar(Double.parseDouble(txtbar.getText().replace(",", "."))); mergulho.setValorKgfPorCm(Double.parseDouble(txtkgf.getText().replace(",", ".")));
                
                if (incluindo == true){
                    dao.inserir(mergulho);

                    if(rom.getId() != null){
                        DaoMergulho.inserirIdRomMergulho(rom.getId());
                        DaoRom.inserirRom_idListaDeMergulhos_id(rom.getId(), mergulho.getId());
                    }
                        
                }
                else if (incluindo == false){
                    dao.alterar(mergulho);
                }
                DaoCheckList.inserirIdMergulho(mergulho.getId(), mergulho.checklist.getId());

                exibirDadosListaMergulhos();
                
                listaMergulhos.getSelectionModel().clearSelection();

                listaMergulhos.setDisable(false);
                
                btn_checklist.setDisable(true);
                btn_alterar.setDisable(false);
                btn_excluir_mergulho.setDisable(false);
                btn_gravar_mergulho.setDisable(true);
                btn_incluir.setDisable(false);
                incluindo = false;
                
                disableFields(true);
                return;
            }
            MensagensJavaFx.exibirMensagemAlerta("Você deve gravar o checklist primeiro!","Atenção!","Alerta");
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagemAlerta("Preencha todos os campos para gravar!","Atenção!","Alerta");
        }
        
    }

    @FXML
    private void btn_excluir_mergulho(ActionEvent event){
        if(MensagensJavaFx.exibirConfirmacao("Tem certeza que deseja excluir o mergulho?", "Exclusão de mergulho", "Confirmação")){
            if (listaMergulhos.getSelectionModel().getSelectedItem() != null){
                this.mergulho = listaMergulhos.getSelectionModel().getSelectedItem();

                if (!(rom.getId() == null)){
                    DaoMergulho.apagarId_rom_listademergulhos_id(rom.getId(), mergulho.getId());
                }
                dao.apagar(mergulho);
    
                zerarCampos();
                
                exibirDadosListaMergulhos();
            }
            else{
                MensagensJavaFx.exibirMensagemAlerta("Selecione um mergulho para excluir!", "Atenção!", "Alerta!");
            }
        }
    }

    @FXML
    private void btn_incluir(ActionEvent event){
        incluindo = true;

        if (txtds.isDisabled()){
            disableFields(false);
        }

        listaMergulhos.setDisable(true);

        btn_alterar.setDisable(true);
        btn_excluir_mergulho.setDisable(true);
        btn_gravar_mergulho.setDisable(false);
        btn_incluir.setDisable(true);
        btn_checklist.setDisable(false);

        mergulho = new Mergulho();

        zerarCampos();
    }

    @FXML
    private void btn_alterar(ActionEvent event){
        if (listaMergulhos.getSelectionModel().getSelectedItem() != null){
            this.mergulho = listaMergulhos.getSelectionModel().getSelectedItem();
            if (txtds.isDisabled()){
                disableFields(false);
            }
            
            listaMergulhos.setDisable(true);
        
            btn_alterar.setDisable(true);
            btn_excluir_mergulho.setDisable(true);
            btn_gravar_mergulho.setDisable(false);
            btn_incluir.setDisable(true);
            btn_checklist.setDisable(false);
            incluindo = false;
        }
        else{
            MensagensJavaFx.exibirMensagemAlerta("Selecione um mergulho para alterar!", "Atenção!", "Alerta!");
        }
        
    }
    
    @FXML private void btn_cancelar_acoes(ActionEvent event){
        disableFields(true);
        listaMergulhos.getSelectionModel().clearSelection();

        this.mergulho = null;
        listaMergulhos.setDisable(false);
        btn_alterar.setDisable(false);
        btn_excluir_mergulho.setDisable(false);
        btn_gravar_mergulho.setDisable(true);
        btn_incluir.setDisable(false);
        btn_checklist.setDisable(true);
        incluindo = false;

        zerarCampos();
    }
    //#endregion

    //#region Funções para calcular o tempo de fundo e a conversão de psi para kgf/bar
    @FXML
    private void calcular_tempo_fundo(){
        try {
            if (!btn_incluir.isDisabled()){
                return;
            }
            else if(!btn_alterar.isDisabled()){
                return;
            }
            if (!txtds.getText().isEmpty() && !txtdf.getText().isEmpty()) {
    
                // Verifica se os textos têm o tamanho correto (5 caracteres no formato HH:mm)
                if (txtds.getText().length() == 5 && txtdf.getText().length() == 5) {
                    LocalTime deixouSuperficie = LocalTime.parse(txtds.getText());
                    LocalTime deixouFundo = LocalTime.parse(txtdf.getText());
    
                    if (deixouFundo.compareTo(deixouSuperficie) >= 0) {
                        Duration diferenca = Duration.between(deixouSuperficie, deixouFundo);
    
                        String tempoFundo = String.format("%02d:%02d",
                                diferenca.toHours(),
                                diferenca.toMinutesPart());
    
                        txttf.setText(tempoFundo);
                    }
                    else{
                        MensagensJavaFx.exibirMensagem("O horário que o mergulhador deixou o fundo deve ser mais tarde que o horário em que ele deixou a superfície!","Atenção","Erro");
                    }

                }else if(txtds.getText().length() > 5 || txtdf.getText().length() > 5){
                    MensagensJavaFx.exibirMensagem("O horário digitado está incorreto!","Atenção","Erro");
                }
            }
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem("Este campo aceita apenas valores númericos no formato: 00:00","Atenção!","Erro!");
        }
        
    }

    public void verificarHorarioCs(){
        try {
        //     if (txtcs.getText().isEmpty()){
        //     txtcs.setText("00:00");
        //     MensagensJavaFx.exibirMensagem("O horário em que chegou a superfície não pode ser nulo!","Atenção","Erro");
        //     return;
        // }
        // else if(txtcs.getText().length() > 5){
        //     txtcs.setText("00:00");
        //     MensagensJavaFx.exibirMensagem("Formato de hora incorreto!","Atenção","Erro");
        //     return;
        // }
        // else{
        //     LocalTime chegouSuperficie = LocalTime.parse(txtcs.getText());
        //     LocalTime deixouFundo = LocalTime.parse(txtdf.getText());
        //     if (!(chegouSuperficie.compareTo(deixouFundo) >= 0)){
        //         MensagensJavaFx.exibirMensagem("O horário que o mergulhador deixou o fundo deve ser mais tarde que o horário em que ele deixou a superfície!","Atenção","Erro");
        //         txtcs.setText("00:00");
        //         return;
        //     }
        // }

            if (!txtcs.getText().isEmpty()) {
                // Verifica se os textos têm o tamanho correto (5 caracteres no formato HH:mm)
                if (txtcs.getText().length() == 5) {
                    LocalTime chegouSuperficie = LocalTime.parse(txtcs.getText());
                    LocalTime deixouFundo = LocalTime.parse(txtdf.getText());
    
                    if (!(chegouSuperficie.compareTo(deixouFundo) >= 0)) {
                        MensagensJavaFx.exibirMensagem("O horário que o mergulhador chegou na superfície não pode ser menor que o horário em que ele deixou o fundo!","Atenção","Erro");
                    }
                }else if(txtcs.getText().length() > 5){
                    MensagensJavaFx.exibirMensagem("O horário digitado está incorreto!","Atenção","Erro");
                }
            }
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem("Este campo aceita apenas valores númericos no formato: 00:00","Atenção!","Erro!");
        }
        
    }

    @FXML 
    private void calcular_conversao(){
        try {
            if (!txtpsi.getText().isEmpty()){
                Double valorBar = Double.parseDouble(txtpsi.getText())/14.5;
                Double valorKgf = valorBar * 1.019;
                DecimalFormat decimalFormat = new DecimalFormat("#.##");

                txtbar.setText(decimalFormat.format(valorBar));
                txtkgf.setText(decimalFormat.format(valorKgf));
            }
        } catch (Exception e) {
        MensagensJavaFx.exibirMensagem("Este campo deve ser preenchido com um número!", "Atenção!", "Erro!");
        }
    }
    //#endregion
    
    //#region Funções para lidar com dados nos campos (exibir dados, desabilitar os campos)

    private void disableFields(boolean choice){
        txtDupla.setDisable(choice);
        txtNomeM1.setDisable(choice);                     txtNomeM2.setDisable(choice);
        txtidcap1.setDisable(choice);                     txtidcap2.setDisable(choice);
        txtidneckdam1.setDisable(choice);                 txtidneckdam2.setDisable(choice);
        txtTamanho1.setDisable(choice);                   txtTamanho2.setDisable(choice);
        
        txtNumeroMergulho.setDisable(choice);

        txtds.setDisable(choice);
        txtdf.setDisable(choice);
        txtcs.setDisable(choice);
        txttf.setDisable(choice);
        txtprof.setDisable(choice);
        txttab.setDisable(choice);

        txtgr.setDisable(choice);
        txtis.setDisable(choice);
        txtgra.setDisable(choice);
        txtngr.setDisable(choice);
        txttnr.setDisable(choice);
        txttemp.setDisable(choice);

        txtcorrenteza.setDisable(choice);
        txtvento.setDisable(choice);
        txtswell.setDisable(choice);

        txtsupervisor.setDisable(choice);
        txtsupervisorassist.setDisable(choice);
        txtoperador.setDisable(choice); 
        txtmergulhadorquadros.setDisable(choice);
        txtoperadorcompressor.setDisable(choice);
        txtmergulhadoremergencia.setDisable(choice);
        txtmergulhadoremed.setDisable(choice);


        txtvolumebm1.setDisable(choice);
        txtpressaobm1.setDisable(choice);
        txtautonomiabm1.setDisable(choice);

        txtvolumebm2.setDisable(choice);
        txtpressaobm2.setDisable(choice);
        txtautonomiabm2.setDisable(choice);

        txtvolumebm3.setDisable(choice);
        txtpressaobm3.setDisable(choice);
        txtautonomiabm3.setDisable(choice);

        txtvolumecilindro1.setDisable(choice);
        txtpressaocilindro1.setDisable(choice);
        txtautonomiacilindro1.setDisable(choice);

        txtvolumecilindro2.setDisable(choice);
        txtpressaocilindro2.setDisable(choice);
        txtautonomiacilindro2.setDisable(choice);

        txtvolumesuprimento.setDisable(choice);
        txtpressaosuprimento.setDisable(choice);
        txtautonomiasuprimento.setDisable(choice); 

        txtdescricao.setDisable(choice);
        txtreferencia.setDisable(choice);

        txtpsi.setDisable(choice);
        txtbar.setDisable(choice);
        txtkgf.setDisable(choice);
    }

    public void zerarCampos(){
        txtDupla.setText("");
        txtNomeM1.setText("");                     txtNomeM2.setText("");
        txtidcap1.setText("");                     txtidcap2.setText("");
        txtidneckdam1.setText("");                 txtidneckdam2.setText("");
        txtTamanho1.setText("");                   txtTamanho2.setText("");
        
        txtNumeroMergulho.setText("");
        
        txtds.setText("");
        txtdf.setText("");
        txtcs.setText("");
        txttf.setText("");
        txtprof.setText("");
        txttab.setText("");

        txtgr.setText("");
        txtis.setText("");
        txtgra.setText("");
        txtngr.setText("");
        txttnr.setText("");
        txttemp.setText("");

        txtcorrenteza.setText("");
        txtvento.setText("");
        txtswell.setText("");

        txtsupervisor.setText("");
        txtsupervisorassist.setText("");
        txtoperador.setText(""); 
        txtmergulhadorquadros.setText("");
        txtoperadorcompressor.setText("");
        txtmergulhadoremergencia.setText("");
        txtmergulhadoremed.setText("");


        txtvolumebm1.setText("");
        txtpressaobm1.setText("");
        txtautonomiabm1.setText("");

        txtvolumebm2.setText("");
        txtpressaobm2.setText("");
        txtautonomiabm2.setText("");

        txtvolumebm3.setText("");
        txtpressaobm3.setText("");
        txtautonomiabm3.setText("");

        txtvolumecilindro1.setText("");
        txtpressaocilindro1.setText("");
        txtautonomiacilindro1.setText("");

        txtvolumecilindro2.setText("");
        txtpressaocilindro2.setText("");
        txtautonomiacilindro2.setText("");

        txtvolumesuprimento.setText("");
        txtpressaosuprimento.setText("");
        txtautonomiasuprimento.setText(""); 

        txtdescricao.setText("");
        txtreferencia.setText("");

        txtpsi.setText("");
        txtbar.setText("");
        txtkgf.setText("");
    }

    @FXML
    private void listaMergulhos_keyPressed(KeyEvent event){
        exibirDados();
    }
    
    @FXML
    private void listaMergulhos_mouseClicked(MouseEvent event){
        exibirDados();
    }

    protected void exibirDados(){
        mergulho = listaMergulhos.getSelectionModel().getSelectedItem();
        if (mergulho==null) return;

        txtDupla.setText(mergulho.getDupla());
        txtNomeM1.setText(mergulho.getMergulhadorUmNome());                     txtNomeM2.setText(mergulho.getMergulhadorDoisNome());
        txtidcap1.setText(mergulho.getMergulhadorUmIdCapacete().toString());    txtidcap2.setText(mergulho.getMergulhadorDoisIdCapacete().toString());
        txtidneckdam1.setText(mergulho.getMergulhadorUmIdNeckDam().toString()); txtidneckdam2.setText(mergulho.getMergulhadorDoisIdNeckDam().toString());
        txtTamanho1.setText(mergulho.getMergulhadorUmTamanho());                txtTamanho2.setText(mergulho.getMergulhadorDoisTamanho());
        
        txtNumeroMergulho.setText(mergulho.getNumeroDoMergulho().toString());
        
        txtds.setText(mergulho.getDeixouSuperficie().toString());
        txtdf.setText(mergulho.getDeixouFundo().toString());
        txtcs.setText(mergulho.getChegouSuperficie().toString());
        txttf.setText(mergulho.getTempoDeFundo().toString());
        txtprof.setText(mergulho.getProfundidade().toString());
        txttab.setText(mergulho.getTab());

        txtgr.setText(mergulho.getGrupoRepetitivo());
        txtis.setText(mergulho.getIntervaloDeSuperficie());
        txtgra.setText(mergulho.getGrupoRepetitivoAnterior());
        txtngr.setText(mergulho.getNovoGrupoRepetitivo());
        txttnr.setText(mergulho.getTempoNitrogenioResidual());
        txttemp.setText(mergulho.getTemperaturaCelsius().toString());

        txtcorrenteza.setText(mergulho.getCorrenteza().toString());
        txtvento.setText(mergulho.getVento().toString());
        txtswell.setText(mergulho.getSwell().toString());

        txtsupervisor.setText(mergulho.getSupervisor());
        txtsupervisorassist.setText(mergulho.getSupervisorAssistente());
        txtoperador.setText(mergulho.getOperadorGuincho()); 
        txtmergulhadorquadros.setText(mergulho.getMergulhadorQuadros());
        txtoperadorcompressor.setText(mergulho.getOperadorCompressor());
        txtmergulhadoremergencia.setText(mergulho.getMergulhadorDeEmergencia());
        txtmergulhadoremed.setText(mergulho.getMergulhadorDeEmed());


        txtvolumebm1.setText(mergulho.getBailoutMergUmVolume().toString());
        txtpressaobm1.setText(mergulho.getBailoutMergUmPressao().toString());
        txtautonomiabm1.setText(mergulho.getBailoutMergUmAutonomia().toString());

        txtvolumebm2.setText(mergulho.getBailoutMergDoisVolume().toString());
        txtpressaobm2.setText(mergulho.getBailoutMergDoisPressao().toString());
        txtautonomiabm2.setText(mergulho.getBailoutMergDoisAutonomia().toString());

        txtvolumebm3.setText(mergulho.getBailoutMergTresVolume().toString());
        txtpressaobm3.setText(mergulho.getBailoutMergTresPressao().toString());
        txtautonomiabm3.setText(mergulho.getBailoutMergTresAutonomia().toString());

        txtvolumecilindro1.setText(mergulho.getCilindroEmergencialMergUmVolume().toString());
        txtpressaocilindro1.setText(mergulho.getCilindroEmergencialMergUmPressao().toString());
        txtautonomiacilindro1.setText(mergulho.getCilindroEmergencialMergUmAutonomia().toString());

        txtvolumecilindro2.setText(mergulho.getCilindroEmergencialMergDoisVolume().toString());
        txtpressaocilindro2.setText(mergulho.getCilindroEmergencialMergDoisPressao().toString());
        txtautonomiacilindro2.setText(mergulho.getCilindroEmergencialMergDoisAutonomia().toString());

        txtvolumesuprimento.setText(mergulho.getEPainelOuSuprimentoVolume().toString());
        txtpressaosuprimento.setText(mergulho.getEPainelOuSuprimentoPressao().toString());
        txtautonomiasuprimento.setText(mergulho.getCePainelOuSuprimentoAutonomia().toString()); 

        txtdescricao.setText(mergulho.getDescricaoServicoOuNotas());
        txtreferencia.setText(mergulho.getProcedimentosReferencia());

        txtpsi.setText(mergulho.getPsi().toString());
        txtbar.setText(mergulho.getValorBar().toString());
        txtkgf.setText(mergulho.getValorKgfPorCm().toString());
    }

    protected void exibirDadosListaMergulhos(){
        try {
            if(rom.getId() == null){
                List<Mergulho> mergulhos = dao.buscarMergulhosSemId_Rom();
                ObservableList<Mergulho> data = FXCollections.observableArrayList(mergulhos);
                listaMergulhos.setItems(data);
                return;
            }
            //List<Mergulho> mergulhos = dao.buscarTodos();
            List<Mergulho> mergulhos = dao.buscaMergulhosPorRom(rom.getId());

            ObservableList<Mergulho> data = FXCollections.observableArrayList(mergulhos);
            listaMergulhos.setItems(data);
        } catch (Exception e) {
        }
        
    }

    protected void exibirDadosRom(){
        try {
            dpRom.setValue(rom.getData());
            txtEmbarcacao.setText(rom.getEmbarcacaoOuPlataforma());
            txtLocalizacao.setText(rom.getLocalizacao());
            txtContratante.setText(rom.getContratante());
            txtNomeResponsavel.setText(rom.getNomeResponsavel());
            txtSupervisorRom.setText(rom.getNomeSupervisor());
            txtObservacoesRom.setText(rom.getObservacoes());
        } catch (Exception e) {
        }
    }
    //#endregion

    //#region Funções para calcular automaticamente os valores de pressão
    public void calcularAutonomiaBm1(){
        try {
            if (!(txtvolumebm1.getText().isEmpty()) && !(txtpressaobm1.getText().isEmpty()) && !(txtprof.getText().isEmpty())){
                Double ata = (Double.parseDouble(txtprof.getText()) / 10) + 1;
                Double consumoMax = (ata * 62.5);
                Double volume = Double.parseDouble(txtvolumebm1.getText());
                Double pressao = Double.parseDouble(txtpressaobm1.getText());
                Double autonomiabm1 = ((volume * (pressao - (10.3 + ata)))/consumoMax);

                Integer aproxAutonomia = (int) Math.round(autonomiabm1);

                txtautonomiabm1.setText(aproxAutonomia.toString());
            }
            else if(txtvolumebm1.getText().isEmpty() || txtpressaobm1.getText().isEmpty() || txtprof.getText().isEmpty()){
                txtautonomiabm1.setText("");
            }
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem("Você deve inserir um número neste campo!","Atenção!","Erro!");
            txtautonomiabm1.setText("");
        }
        
    }

    public void calcularAutonomiaBm2(){
        try {
            if (!(txtvolumebm2.getText().isEmpty()) && !(txtpressaobm2.getText().isEmpty()) && !(txtprof.getText().isEmpty())){
                Double ata = (Double.parseDouble(txtprof.getText()) / 10) + 1;
                Double consumoMax = (ata * 62.5);
                Double volume = Double.parseDouble(txtvolumebm2.getText());
                Double pressao = Double.parseDouble(txtpressaobm2.getText());
                Double autonomiabm2 = ((volume * (pressao - (10.3 + ata)))/consumoMax);

                Integer aproxAutonomia = (int) Math.round(autonomiabm2);

                txtautonomiabm2.setText(aproxAutonomia.toString());
            }
            else if(txtvolumebm2.getText().isEmpty() || txtpressaobm2.getText().isEmpty() || txtprof.getText().isEmpty()){
                txtautonomiabm2.setText("");
            }
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem("Você deve inserir um número neste campo!","Atenção!","Erro!");
            txtautonomiabm2.setText("");
        }
        
    }

    public void calcularAutonomiaBm3(){
        try {
            if (!(txtvolumebm3.getText().isEmpty()) && !(txtpressaobm3.getText().isEmpty()) && !(txtprof.getText().isEmpty())){
                Double ata = (Double.parseDouble(txtprof.getText()) / 10) + 1;
                Double consumoMax = (ata * 62.5);
                Double volume = Double.parseDouble(txtvolumebm3.getText());
                Double pressao = Double.parseDouble(txtpressaobm3.getText());
                Double autonomiabm3 = ((volume * (pressao - (10.3 + ata)))/consumoMax);

                Integer aproxAutonomia = (int) Math.round(autonomiabm3);

                txtautonomiabm3.setText(aproxAutonomia.toString());
            }
            else if(txtvolumebm3.getText().isEmpty() || txtpressaobm3.getText().isEmpty() || txtprof.getText().isEmpty()){
                txtautonomiabm3.setText("");
            }
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem("Você deve inserir um número neste campo!","Atenção!","Erro!");
            txtautonomiabm3.setText("");
        }
        
    }

    public void calcularAutonomiaCilindroEmergencial1(){
        try {
            if (!(txtvolumecilindro1.getText().isEmpty()) && !(txtpressaocilindro1.getText().isEmpty()) && !(txtprof.getText().isEmpty())){
                Double ata = (Double.parseDouble(txtprof.getText()) / 10) + 1;
                Double consumoMax = (ata * 62.5);
                Double volume = Double.parseDouble(txtvolumecilindro1.getText());
                Double pressao = Double.parseDouble(txtpressaocilindro1.getText());
                Double autonomiaCilindroEmergencial1 = ((volume * (pressao - (10.3 + ata)))/consumoMax);

                Integer aproxAutonomia = (int) Math.round(autonomiaCilindroEmergencial1);

                txtautonomiacilindro1.setText(aproxAutonomia.toString());
            }
            else if(txtvolumecilindro1.getText().isEmpty() || txtpressaocilindro1.getText().isEmpty() || txtprof.getText().isEmpty()){
                txtautonomiacilindro1.setText("");
            }
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem("Você deve inserir um número neste campo!","Atenção!","Erro!");
            txtautonomiacilindro1.setText("");
        }
    }

    public void calcularAutonomiaCilindroEmergencial2(){
        try {
            if (!(txtvolumecilindro2.getText().isEmpty()) && !(txtpressaocilindro2.getText().isEmpty()) && !(txtprof.getText().isEmpty())){
                Double ata = (Double.parseDouble(txtprof.getText()) / 10) + 1;
                Double consumoMax = (ata * 62.5);
                Double volume = Double.parseDouble(txtvolumecilindro2.getText());
                Double pressao = Double.parseDouble(txtpressaocilindro2.getText());
                Double autonomiaCilindroEmergencial2 = ((volume * (pressao - (10.3 + ata)))/consumoMax);

                Integer aproxAutonomia = (int) Math.round(autonomiaCilindroEmergencial2);

                txtautonomiacilindro2.setText(aproxAutonomia.toString());
            }
            else if(txtvolumecilindro2.getText().isEmpty() || txtpressaocilindro2.getText().isEmpty() || txtprof.getText().isEmpty()){
                txtautonomiacilindro2.setText("");
            }
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem("Você deve inserir um número neste campo!","Atenção!","Erro!");
            txtautonomiacilindro2.setText("");
        }
    }

    public void calcularAutonomiaPainelSuprimento(){
        try {
            if (!(txtvolumesuprimento.getText().isEmpty()) && !(txtpressaosuprimento.getText().isEmpty()) && !(txtprof.getText().isEmpty())){
                Double ata = (Double.parseDouble(txtprof.getText()) / 10) + 1;
                Double consumoMax = (ata * 62.5);
                Double volume = Double.parseDouble(txtvolumesuprimento.getText());
                Double pressao = Double.parseDouble(txtpressaosuprimento.getText());
                Double autonomiaPainelSuprimento = (volume * (pressao-17.3)) / (consumoMax*2 + consumoMax); 


                Integer aproxAutonomia = (int) Math.round(autonomiaPainelSuprimento);

                txtautonomiasuprimento.setText(aproxAutonomia.toString());
            }
            else if(txtvolumesuprimento.getText().isEmpty() || txtpressaosuprimento.getText().isEmpty() || txtprof.getText().isEmpty()){
                txtautonomiasuprimento.setText("");
            }
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem("Você deve inserir um número neste campo!","Atenção!","Erro!");
            txtautonomiasuprimento.setText("");
        }
    }
    //#endregion
    
    //#region Funções para ir para a tela do checklist e pra ROM (Gravar rom)
    @FXML
    private void btn_checklist(ActionEvent event) throws IOException {
        try {
            DaoCheckList daoCheckList = new DaoCheckList();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CheckList.fxml")); 
            Parent root = loader.load();

            CheckListController checkListController = loader.getController();
            checkListController.setIncluindo(incluindo); 
            if (!incluindo){
                CheckList checklistPassar = daoCheckList.buscarCheckList(this.mergulho.getId());
                checkListController.setCheckList(checklistPassar);

            }
            checkListController.setMergulho(mergulho);

            checkListController.mostrarDados();

            Stage stage = new Stage();
            
            stage.setResizable(false);
            stage.setTitle("CheckList");
            
            stage.initModality(Modality.APPLICATION_MODAL);

            // Define a cena da nova janela
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
            // Exibe a nova janela como um diálogo modal
            stage.show();      
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem(e.toString(), "Atenção!", "Erro ao exibir o CheckList. Favor entrar em contato com o administrador!");
        }
        
    }

    @FXML
    public void btn_gravarRom(ActionEvent event) throws IOException{
        try {
            DaoMergulho daoMergulho = new DaoMergulho();
            System.out.println(daoMergulho.buscarMergulhosSemId_Rom());
            if (daoMergulho.buscarMergulhosSemId_Rom().isEmpty() && this.alterandoRom == false){
                MensagensJavaFx.exibirMensagemAlerta("Para gravar uma ROM, é necessário gravar pelo menos 1 (um) mergulho antes!", "Atenção!", "Aviso");
                return;
            }
            if (MensagensJavaFx.exibirConfirmacao("Tem certeza que deseja gravar uma ROM com os mergulhos que foram criados?", "Gravar ROM", "Confirmação")){
            DaoCheckList.inserirIdMergulhoWhereIsNull();
            DaoRom daoRom = new DaoRom();
            if(rom.getId() == null){
                rom.setEmbarcacaoOuPlataforma(txtEmbarcacao.getText());
                rom.setLocalizacao(txtLocalizacao.getText());
                rom.setData(dpRom.getValue());
                rom.setContratante(txtContratante.getText());
                rom.setNomeResponsavel(txtNomeResponsavel.getText());
                rom.setNomeSupervisor(txtSupervisorRom.getText());
                rom.setObservacoes(txtObservacoesRom.getText());

                daoRom.inserir(rom);

                rom.setListaDeMergulhos(listaMergulhos.getItems());

                daoRom.alterar(rom);

            }else{
                rom.setListaDeMergulhos(listaMergulhos.getItems());

                rom.setEmbarcacaoOuPlataforma(txtEmbarcacao.getText());
                rom.setLocalizacao(txtLocalizacao.getText());
                rom.setData(dpRom.getValue());
                rom.setContratante(txtContratante.getText());
                rom.setNomeResponsavel(txtNomeResponsavel.getText());
                rom.setNomeSupervisor(txtSupervisorRom.getText());
                rom.setObservacoes(txtObservacoesRom.getText());

                daoRom.alterar(rom);
            }
            DaoMergulho.inserirIdRomMergulho(rom.getId());
            
            this.alterandoRom = false;

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Rom.fxml"));
            Parent root = loader.load();

            RomController romController = loader.getController();
            romController.exibirDadosListaRoms();

            Stage stage = new Stage();
            
            stage.setTitle("Tela de cadastro - ROM");

            stage.setResizable(false);

            Scene scene = new Scene(root);
            stage.setScene(scene);

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
            

            stage.show();
        }
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem(e.toString(), "Atenção!", "Erro ao gravar a rom, favor entrar em contato com o administrador!");
        }
    }

    @FXML
    public void btn_voltarPaginaRom(ActionEvent event){
        try {
            if (MensagensJavaFx.exibirConfirmacao("Se sair dessa tela agora perderá os dados que estão preenchidos nos campos. Tem certeza?", "Tem certeza que deseja ir para a tela das ROM's?", "Confirmação")){
                btn_cancelar_acoes(event);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Rom.fxml"));
                Parent root = loader.load();

                RomController romController = loader.getController();
                romController.exibirDadosListaRoms();

                DaoCheckList.inserirIdMergulhoWhereIsNull();

                Stage stage = new Stage();
                
                stage.setTitle("Tela de cadastro - ROM");

                stage.setResizable(false);

                this.alterandoRom = false;

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
    //#endregion


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        disableFields(true);

        listaMergulhos.setDisable(false);
        btn_alterar.setDisable(false);
        btn_excluir_mergulho.setDisable(false);
        btn_gravar_mergulho.setDisable(true);
        btn_incluir.setDisable(false);
        btn_checklist.setDisable(true);

        incluindo = false;

        //#region Funcionalidades para mudar valores das caixas de pressão, volume, autonomia etc
        txtvolumebm1.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaBm1());
        txtpressaobm1.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaBm1());
        txtprof.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaBm1());
        

        txtvolumebm2.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaBm2());
        txtpressaobm2.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaBm2());
        txtprof.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaBm2());

        txtvolumebm3.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaBm3());
        txtpressaobm3.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaBm3());
        txtprof.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaBm3());

        txtvolumecilindro1.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaCilindroEmergencial1());
        txtpressaocilindro1.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaCilindroEmergencial1());
        txtprof.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaCilindroEmergencial1());

        txtvolumecilindro2.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaCilindroEmergencial2());
        txtpressaocilindro2.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaCilindroEmergencial2());
        txtprof.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaCilindroEmergencial2());

        txtvolumesuprimento.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaPainelSuprimento());
        txtpressaosuprimento.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaPainelSuprimento());
        txtprof.textProperty().addListener((observable, oldValue, newValue) -> calcularAutonomiaPainelSuprimento());

        //#endregion
        
        //#region Funcionalidades para mudar automaticamente valores do tempo de fundo e da conversão psi/bar/kgf

        txtds.textProperty().addListener((observable, oldValue, newValue) -> calcular_tempo_fundo());
        txtdf.textProperty().addListener((observable, oldValue, newValue) -> calcular_tempo_fundo());
        txtpsi.textProperty().addListener((Observable, oldValue, newValue) -> calcular_conversao());
        txtcs.textProperty().addListener((observable, oldValue, newValue) -> verificarHorarioCs());
        //#endregion
    
        //#region Utilização do tooltip para mostrar o que a sigla significa ao passar o mouse por cima do texto
        Tooltip.install(textoDeixouSuperficie, GeradorTooltip.gerarTooltip("Deixou a superfície"));
        Tooltip.install(textoDeixouFundo, GeradorTooltip.gerarTooltip("Deixou o fundo"));
        Tooltip.install(textoChegouSuperficie, GeradorTooltip.gerarTooltip("Chegou a superfície"));

        Tooltip.install(textoTempoFundo, GeradorTooltip.gerarTooltip("Tempo de fundo"));
        Tooltip.install(textoProfundidade, GeradorTooltip.gerarTooltip("Profundidade"));
        Tooltip.install(textoTab, GeradorTooltip.gerarTooltip("Abreviação de tabela"));

        Tooltip.install(textoGr, GeradorTooltip.gerarTooltip("Grupo repetitivo"));
        Tooltip.install(textoIs, GeradorTooltip.gerarTooltip("Intervalo de superfície"));
        Tooltip.install(textoGra, GeradorTooltip.gerarTooltip("Grupo repetitivo anterior"));

        Tooltip.install(textoNgr, GeradorTooltip.gerarTooltip("Novo grupo repetitivo"));
        Tooltip.install(textoTnr, GeradorTooltip.gerarTooltip("Tempo de nitrogênio residual"));
        Tooltip.install(textoTemp, GeradorTooltip.gerarTooltip("Temperatura")); 

        Tooltip.install(textoPSI, GeradorTooltip.gerarTooltip("Libra-força por polegada quadrada"));
        Tooltip.install(textoBAR, GeradorTooltip.gerarTooltip("BAR"));
        Tooltip.install(textoKGFCM, GeradorTooltip.gerarTooltip("Quilograma-força por centímetro quadrado"));
        //#endregion

    }

    
}
