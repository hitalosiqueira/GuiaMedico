/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleBusca;

import guiamedico.Busca;
import guiamedico.Cliente;
import guiamedico.Clinica;
import guiamedico.Hospital;
import guiamedico.Medico;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hitalo
 */
public class ControleBusca {

    private int codPlano;
    private int codCliente;
    private String tpAtendimento;
    private String tpEspecialidade;
    private String city;
    private String zona;
    private List<Hospital> hosp;
    private List<Clinica> clin;

    public ControleBusca(int codCliente, int codPlano, String tpAtendimento, String tpEspecialidade, String city, String zona) {
        this.codPlano = codPlano;
        this.codCliente = codCliente;
        this.tpAtendimento = tpAtendimento;
        this.tpEspecialidade = tpEspecialidade;
        this.city = city;
        this.zona = zona;
    }

    public void runBuscaInstituicaoCliente() throws SQLException {
        Busca b = new Busca();
        Cliente c = b.getDadosCliente(codCliente);
        if (tpAtendimento.equals("Hospital")) {
            if ((city.equals("<Selecione>")) && (zona.equals("<Selecione>"))) {
                hosp = b.buscaHospital(c.getPlano());
            } else {
                if ((zona.equals("<Selecione>"))) {
                    hosp = b.buscaHospitalCidade(city, c.getPlano());
                } else {
                    hosp = b.buscaHospitalCidadeRegiao(city, zona, c.getPlano());
                }
            }

        } else {
            if (tpAtendimento.equals("Clinica")) {
                if (tpEspecialidade.equals("<Selecione>") && (city.equals("<Selecione>")) && (zona.equals("<Selecione>"))) {
                    clin = b.buscaClinica(c.getPlano());
                } else {
                    if ((city.equals("<Selecione>")) && (zona.equals("<Selecione>"))) {
                        clin = b.buscaClinicaEsp(tpEspecialidade, c.getPlano());
                    } else {
                        if (tpEspecialidade.equals("<Selecione>") && (zona.equals("<Selecione>"))) {
                            clin = b.buscaClinicaCidade(city, c.getPlano());
                        } else {
                            if (tpEspecialidade.equals("<Selecione>")) {
                                clin = b.buscaClinicaCidadeRegiao(city, zona, c.getPlano());
                            } else {
                                if ((zona.equals("<Selecione>"))) {
                                    clin = b.buscaClinicaEspCidade(tpEspecialidade, city, c.getPlano());
                                } else {
                                    clin = b.buscaClinicaEspCidadeRegiao(tpEspecialidade, city, zona, c.getPlano());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void runBuscaInstituicaoNaoCliente() throws SQLException {
        Busca b = new Busca();

        if (tpAtendimento.equals("Hospital")) {
            if ((city.equals("<Selecione>")) && (zona.equals("<Selecione>"))) {
                hosp = b.buscaHospital(codPlano);
            } else {
                if ((zona.equals("<Selecione>"))) {
                    hosp = b.buscaHospitalCidade(city, codPlano);
                } else {
                    hosp = b.buscaHospitalCidadeRegiao(city, zona, codPlano);
                }
            }

        } else {
            if (tpAtendimento.equals("Clinica")) {
                if (tpEspecialidade.equals("<Selecione>") && (city.equals("<Selecione>")) && (zona.equals("<Selecione>"))) {
                    clin = b.buscaClinica(codPlano);
                } else {
                    if ((city.equals("<Selecione>")) && (zona.equals("<Selecione>"))) {
                        clin = b.buscaClinicaEsp(tpEspecialidade, codPlano);
                    } else {
                        if (tpEspecialidade.equals("<Selecione>") && (zona.equals("<Selecione>"))) {
                            clin = b.buscaClinicaCidade(city, codPlano);
                        } else {
                            if (tpEspecialidade.equals("<Selecione>")) {
                                clin = b.buscaClinicaCidadeRegiao(city, zona, codPlano);
                            } else {
                                if ((zona.equals("<Selecione>"))) {
                                    clin = b.buscaClinicaEspCidade(tpEspecialidade, city, codPlano);
                                } else {
                                    clin = b.buscaClinicaEspCidadeRegiao(tpEspecialidade, city, zona, codPlano);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public List<Hospital> getHosp() {
        return hosp;
    }

    public List<Clinica> getClin() {
        return clin;
    }
}
