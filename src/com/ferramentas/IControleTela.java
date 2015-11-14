/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferramentas;

import com.ControleTela;

/**
 *Essa interface deve ser implementada por todas as classe de controle do projeto
 * @author Marcel
 */
public interface IControleTela {
    /**
     * Método usado para receber uma instancia de uma classe que extende StackPane
     * @param c Instância da classe que extende StackPane
     */
    public void setControleTela(ControleTela c);
}
