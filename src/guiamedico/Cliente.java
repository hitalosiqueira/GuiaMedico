/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiamedico;


public class Cliente {
    private String nome;
    private String email;
    private int cpf;
    private int rg;
    private String endereco;
    private String cidade;
    private String regiao;
    private int telefone;
    private int codCartao;
    private int plano;
    
    public Cliente(String name, String mail, int cadPF, int regGeral, String end, String cid, String reg, int tel, int codC, int pln){
        nome = name;
        email = mail;
        cpf = cadPF;
        rg = regGeral;
        endereco = end;
        cidade = cid;
        regiao = reg;
        telefone = tel;
        codCartao = codC;
        plano = pln;
    }
    
    public String getCidade() {
	return cidade;
    }
    public String getRegiao() {
        return regiao;
    }

    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public int getCpf(){
        return cpf;
    }
    public int getRg(){
        return rg;
    }
    public String getEndereco(){
        return endereco;
    }
    public int getTelefone(){
        return telefone;
    }
    public int getCodCartao(){
        return codCartao;
    }
    public int getPlano() {
	return plano;
    }
}
