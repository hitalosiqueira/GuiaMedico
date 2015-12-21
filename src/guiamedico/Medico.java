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
public class Medico {
    private String especialidade;
    private int crm;
    private String nome;
    private int rg;
    private int cpf;
    private String email;
    private String disponibilidade;
    private String cidade;

    public Medico(String especial, int medReg, String name, int regGeral, int cadPF, String mail, String disp, String c){
        especialidade = especial;
        crm = medReg;
        nome = name;
        rg = regGeral;
        cpf = cadPF;
        email = mail;
        disponibilidade = disp;
        cidade = c;
    }
    
    public String getEspecialidae(){
        return especialidade;
    }
    
    public int getCrm(){
        return crm;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getRg(){
        return rg;
    }
    
    public int getCpf(){
        return cpf;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getDisponibilidade(){
        return disponibilidade;
    }

	public String getCidade() {
		return cidade;
	}
}

