package com.empresa.diversos;

import javafx.scene.control.Tooltip;
import javafx.util.Duration;

public class GeradorTooltip {
    public static Tooltip gerarTooltip(String mensagem){
        Tooltip tooltip = new Tooltip(mensagem);
        tooltip.setShowDelay(new Duration(50));
        return tooltip;
        
    }
}
