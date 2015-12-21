/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleBusca;

import guiamedico.Busca;
import guiamedico.Cliente;
import guiamedico.Medico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hitalo
 */
public class ControleBuscaMedico {

    private String nome;
    private String cidade;
    private String especialidade;
    private int codCliente;
    private int codPlano;
    private boolean rb1;
    private boolean rb2;
    private List<Medico> med;

    public ControleBuscaMedico(String nome, String cidade, String especialidade, int codCliente, int codPlano, boolean rb1, boolean rb2) {
        this.nome = nome;
        this.codCliente = codCliente;
        this.cidade = cidade;
        this.especialidade = especialidade;
        this.codPlano = codPlano;
        this.rb1 = rb1;
        this.rb2 = rb2;
    }

    public void runBuscaMedicoNaoCliente() throws SQLException {
        Busca b = new Busca();

        if (rb1 == true) {
            med = b.buscaMedicoContem(nome, cidade, codPlano);
        } else {
            if (rb2 == true) {
                if (!(especialidade.equals("<Selecione>"))) {
                    med = b.buscaMedicoEspPrimNome(especialidade, nome, cidade, codPlano);
                } else {
                    med = b.buscaMedicoPrimNome(nome, cidade, codPlano);
                }
            }
        }

    }

    public void runBuscaMedicoCliente() throws SQLException {
        Busca b = new Busca();
        Cliente c = b.getDadosCliente(codCliente);

        if (rb1 == true) {
            med = b.buscaMedicoContem(nome, cidade, c.getPlano());
        } else {
            if (rb2 == true) {
                if (!(especialidade.equals("<Selecione>"))) {
                    med = b.buscaMedicoEspPrimNome(especialidade, nome, cidade, c.getPlano());
                } else {
                    med = b.buscaMedicoPrimNome(nome, cidade, c.getPlano());
                }
            }
        }
    }

    public List getMed() {
        return med;
    }
}
