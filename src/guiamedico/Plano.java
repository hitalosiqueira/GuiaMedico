/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiamedico;


/**
 *
 * @author Thales
 */
public class Plano {
    private String tipoPlano;
    private String carencia;
    private String cobertura;
    private double preco;
    private int codigo;
    
    public Plano(String tpPlano, String car, String cob, double valor, int cod){
        tipoPlano = tpPlano;
        carencia = car;
        cobertura = cob;
        preco = valor;
        codigo = cod;
    }
    
    public String getTipoPlano(){
        return tipoPlano;
    }
    
    public String getCarencia(){
        return carencia;
    }
    
    public String getCobertura(){
        return cobertura;
    }
    
    public double getPreco(){
        return preco;
    }
    
    public int getCod(){
        return codigo;
    }
}
