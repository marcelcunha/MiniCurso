/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.ferramentas.IControleTela;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Marcel
 */
public class ControleTela extends StackPane{
    private Map<String, Node> telas = new HashMap<>();
    private Map<String, IControleTela> controle = new HashMap<>();
    
    public void carregarTela(String nome, String caminho){
        try{
            FXMLLoader loader = new FXMLLoader();
             loader.setLocation(getClass().getResource(caminho));
             
            System.out.println(getClass().getResource(caminho));
            Parent tela = (Parent) loader.load();
            IControleTela controlador = (IControleTela) loader.getController();
            controlador.setControleTela(this);
            telas.put(nome, tela);
            controle.put(nome, controlador);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void fixarTela(String nome){
        if(telas.get(nome)!=null){
            if(!this.getChildren().isEmpty()){
                this.getChildren().remove(0);
                this.getChildren().add(0, telas.get(nome));
            }else{
                this.getChildren().add(telas.get(nome));
            }            
        }
    }
    
    public IControleTela getControle(String nome){
        if(controle.get(nome)==null){
            System.out.println("Não existe uma tela com esse nome!");
        }
            
            
        return controle.get(nome);
    
  
    }
}
