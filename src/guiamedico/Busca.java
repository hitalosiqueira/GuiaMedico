/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiamedico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thales
 */
public class Busca {

    private char tipoBusca;
    private Connection conn;

    public Busca() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cliente getDadosCliente(int codCartao) throws SQLException {
        PreparedStatement p = conn.prepareStatement("select * from cliente where codcartao = ?");
        p.setInt(1, codCartao);
        ResultSet r = p.executeQuery();

        while (r.next()) {
            return new Cliente(
                    r.getString(1),
                    r.getString(2),
                    r.getInt(3),
                    r.getInt(4),
                    r.getString(5),
                    r.getString(6),
                    r.getString(7),
                    r.getInt(8),
                    r.getInt(9),
                    r.getInt(10));
        }

        return null;
    }

    public List<Plano> getPlanos() throws SQLException {
        List<Plano> ret = new ArrayList<>();
        ResultSet r = conn.createStatement().executeQuery("select * from plano");
        while (r.next()) {
            ret.add(new Plano(
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getDouble(4),
                    r.getInt(5)));
        }
        return ret;
    }

    public List<String> getCidades() throws SQLException {
        List<String> ret = new ArrayList<>();
        ResultSet r = conn.createStatement().executeQuery("select * from cidade");
        while (r.next()) {
            ret.add(r.getString(1));
        }
        return ret;
    }

    public List<String> getEspecialidades() throws SQLException {
        List<String> ret = new ArrayList<>();
        ResultSet r = conn.createStatement().executeQuery("select * from especialidade");
        while (r.next()) {
            ret.add(r.getString(1));
        }
        return ret;
    }

    public List<Medico> buscaMedicoPrimNome(String nome, String cidade, int plano) throws SQLException {
        List<Medico> ret = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(
                "select esp, crm, nome, rg, cpf, email, disp, cidade from "
                + "medico natural join medicoplano where "
                + "cod = ? and cidade = ? and nome like ?");
        p.setInt(1, plano);
        p.setString(2, cidade);
        p.setString(3, nome + "%");
        ResultSet r = p.executeQuery();
        while (r.next()) {
            ret.add(new Medico(
                    r.getString(1),
                    r.getInt(2),
                    r.getString(3),
                    r.getInt(4),
                    r.getInt(5),
                    r.getString(6),
                    r.getString(7),
                    r.getString(8)));
        }
        return ret;
    }

    public List<Medico> buscaMedicoContem(String nome, String cidade, int plano) throws SQLException {
        List<Medico> ret = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(
                "select esp, crm, nome, rg, cpf, email, disp, cidade from "
                + "medico natural join medicoplano where "
                + "cod = ? and cidade = ? and nome like ?");
        p.setInt(1, plano);
        p.setString(2, cidade);
        p.setString(3, "%" + nome + "%");
        ResultSet r = p.executeQuery();
        while (r.next()) {
            ret.add(new Medico(
                    r.getString(1),
                    r.getInt(2),
                    r.getString(3),
                    r.getInt(4),
                    r.getInt(5),
                    r.getString(6),
                    r.getString(7),
                    r.getString(8)));
        }
        return ret;
    }

    public List<Hospital> buscaHospitalCidadeRegiao(String cidade, String regiao, int plano) throws SQLException {
        List<Hospital> ret = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(
                "select rua, cid, reg, tel, email, nome, id from "
                + "instituicao natural join institplano where "
                + "esp=0 and cid = ? and reg = ? and cod = ?");
        p.setString(1, cidade);
        p.setString(2, regiao);
        p.setInt(3, plano);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            ret.add(new Hospital(
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getInt(4),
                    r.getString(5),
                    r.getString(6),
                    r.getInt(7)));
        }
        return ret;
    }

    public List<Hospital> buscaHospitalCidade(String cidade, int plano) throws SQLException {
        List<Hospital> ret = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(
                "select rua, cid, reg, tel, email, nome, id from "
                + "instituicao natural join institplano where "
                + "esp=0 and cid = ? and cod = ?");
        p.setString(1, cidade);
        p.setInt(2, plano);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            ret.add(new Hospital(
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getInt(4),
                    r.getString(5),
                    r.getString(6),
                    r.getInt(7)));
        }
        return ret;
    }

    public List<Hospital> buscaHospital(int plano) throws SQLException {
        List<Hospital> ret = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(
                "select rua, cid, reg, tel, email, nome, id from "
                + "instituicao natural join institplano where "
                + "esp=0 and cod = ?");
        p.setInt(1, plano);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            ret.add(new Hospital(
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getInt(4),
                    r.getString(5),
                    r.getString(6),
                    r.getInt(7)));
        }
        return ret;
    }

    public List<Clinica> buscaClinicaEspCidadeRegiao(String esp, String cidade, String regiao, int plano) throws SQLException {
        List<Clinica> ret = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(
                "select rua, cid, reg, tel, email, nome, id, esp from "
                + "instituicao natural join institplano where "
                + "cid = ? and reg = ? and cod = ? and esp = ?");
        p.setString(1, cidade);
        p.setString(2, regiao);
        p.setInt(3, plano);
        p.setString(4, esp);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            ret.add(new Clinica(
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getInt(4),
                    r.getString(5),
                    r.getString(6),
                    r.getInt(7),
                    r.getString(8)));
        }
        return ret;
    }

    public List<Clinica> buscaClinicaEspCidade(String esp, String cidade, int plano) throws SQLException {
        List<Clinica> ret = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(
                "select rua, cid, reg, tel, email, nome, id, esp from "
                + "instituicao natural join institplano where "
                + "cid = ? and cod = ? and esp = ?");
        p.setString(1, cidade);
        p.setInt(2, plano);
        p.setString(3, esp);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            ret.add(new Clinica(
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getInt(4),
                    r.getString(5),
                    r.getString(6),
                    r.getInt(7),
                    r.getString(8)));
        }
        return ret;
    }

    public List<Clinica> buscaClinicaEsp(String esp, int plano) throws SQLException {
        List<Clinica> ret = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(
                "select rua, cid, reg, tel, email, nome, id, esp from "
                + "instituicao natural join institplano where "
                + "cod = ? and esp = ?");
        p.setInt(1, plano);
        p.setString(2, esp);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            ret.add(new Clinica(
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getInt(4),
                    r.getString(5),
                    r.getString(6),
                    r.getInt(7),
                    r.getString(8)));
        }
        return ret;
    }

    public List<Clinica> buscaClinicaCidadeRegiao(String cidade, String regiao, int plano) throws SQLException {
        List<Clinica> ret = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(
                "select rua, cid, reg, tel, email, nome, id, esp from "
                + "instituicao natural join institplano where "
                + "cid = ? and reg = ? and cod = ? and esp <> 0");
        p.setString(1, cidade);
        p.setString(2, regiao);
        p.setInt(3, plano);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            ret.add(new Clinica(
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getInt(4),
                    r.getString(5),
                    r.getString(6),
                    r.getInt(7),
                    r.getString(8)));
        }
        return ret;
    }

    public List<Clinica> buscaClinicaCidade(String cidade, int plano) throws SQLException {
        List<Clinica> ret = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(
                "select rua, cid, reg, tel, email, nome, id, esp from "
                + "instituicao natural join institplano where "
                + "cid = ? and cod = ? and esp <> 0");
        p.setString(1, cidade);
        p.setInt(2, plano);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            ret.add(new Clinica(
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getInt(4),
                    r.getString(5),
                    r.getString(6),
                    r.getInt(7),
                    r.getString(8)));
        }
        return ret;
    }

    public List<Clinica> buscaClinica(int plano) throws SQLException {
        List<Clinica> ret = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(
                "select rua, cid, reg, tel, email, nome, id, esp from "
                + "instituicao natural join institplano where "
                + "cod = ? and esp <> 0");
        p.setInt(1, plano);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            ret.add(new Clinica(
                    r.getString(1),
                    r.getString(2),
                    r.getString(3),
                    r.getInt(4),
                    r.getString(5),
                    r.getString(6),
                    r.getInt(7),
                    r.getString(8)));
        }
        return ret;
    }

    public List<Medico> buscaMedicoEspPrimNome(String esp, String nome, String cidade, int plano) throws SQLException {
        List<Medico> ret = new ArrayList<>();
        PreparedStatement p = conn.prepareStatement(
                "select esp, crm, nome, rg, cpf, email, disp, cidade from "
                + "medico natural join medicoplano where "
                + "cod = ? and cidade = ? and nome like ? and esp = ?");
        p.setInt(1, plano);
        p.setString(2, cidade);
        p.setString(3, nome + "%");
        p.setString(4, esp);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            ret.add(new Medico(
                    r.getString(1),
                    r.getInt(2),
                    r.getString(3),
                    r.getInt(4),
                    r.getInt(5),
                    r.getString(6),
                    r.getString(7),
                    r.getString(8)));
        }
        return ret;
    }

    public List<String> getRegioes(String cidade) throws SQLException {
        List<String> ret = new ArrayList<>();
        ResultSet r = conn.createStatement().executeQuery("select regiao from cidaderegiao where nome = '" + cidade + "'");
        while (r.next()) {
            ret.add(r.getString(1));
        }
        return ret;
    }

   /* public void testar() throws SQLException {
        Busca b = new Busca();
        System.out.println(">>> Especialidades");
        for (String s : b.getEspecialidades()) {
            System.out.println(s);
        }
        System.out.println(">>> Cidades");
        for (String s : b.getCidades()) {
            System.out.println(s);
        }
        System.out.println(">>> Planos");
        for (Plano p : b.getPlanos()) {
            System.out.println(p.getTipoPlano());
        }
        System.out.println(">>> Hospital no Centro de Sorocaba");
        //for (Hospital h : b.buscaHospital("Sorocaba", "Centro", 1)) {
            //System.out.println(h.getNome());
        //}
        System.out.println(">>> Ortopedista em Sorocaba - Vila do Chaves");
        for (Clinica c : b.buscaClinica("Ortopedia", "Sorocaba", "Vila do Chaves", 2)) {
            System.out.println(c.getNome());
        }
        System.out.println(">>> Mesma busca, plano basico (sem resultados)");
        for (Clinica c : b.buscaClinica("Ortopedia", "Sorocaba", "Vila do Chaves", 1)) {
            System.out.println(c.getNome());
        }
        System.out.println(">>> Clientes");
        System.out.println(b.getDadosCliente(1234).getNome());
        System.out.println(b.getDadosCliente(2345).getNome());
        System.out.println(">>> Cirurgião no Centro de Sorocaba");
        for (Medico m : b.buscaMedico("Cirurgia", "Sorocaba", "Centro", 2)) {
            System.out.println(m.getNome());
        }
        System.out.println(">>> Geremildo em Sorocaba");
        for (Medico m : b.buscaMedicoPrimNome("Geremildo", "Sorocaba", 2)) {
            System.out.println(m.getNome());
        }
        System.out.println(">>> Medicos com 'er' no nome, em Votorantim");
        for (Medico m : b.buscaMedicoContem("er", "Votorantim", 2)) {
            System.out.println(m.getNome());
        }
        System.out.println(">>> Cidades e Regiões");
        for (String c : b.getCidades()) {
            System.out.println(c);
            for (String r : b.getRegioes(c)) {
                System.out.println("> " + r);
            }
        }
    }*/
}