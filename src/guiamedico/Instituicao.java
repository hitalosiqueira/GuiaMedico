/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiamedico;

public class Instituicao {
    private String endereco;
    private String cidade;
    private String regiao;
    private int telefone;
    private String email;
    private String nome;
    private int id;
    
    public Instituicao(String end, String cid, String reg, int tel, String mail, String name, int idi){
        endereco = end;
        cidade = cid;
        regiao = reg;
        telefone = tel;
        email = mail;
        nome = name;
        id = idi;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public int getTelefone(){
        return telefone;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getNome(){
        return nome;
    }

	public int getId() {
		return id;
	}

	public String getCidade() {
		return cidade;
	}

	public String getRegiao() {
		return regiao;
	} 
}
