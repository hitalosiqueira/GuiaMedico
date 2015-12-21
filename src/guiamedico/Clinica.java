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
public class Clinica extends Instituicao {
    private String especialidade;

    public Clinica(String end, String cid, String reg, int tel, String mail, String name, int id, String especial) {
        super(end, cid, reg, tel, mail, name, id);
        especialidade = especial;
    }
    
    public String getEspecialidade(){
        return especialidade;
    }
}
