package br.com.cobrancas.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Contatos implements Serializable {
    
    @Column(name = "TELEFONE_1")
    private String telefone1;
    
    @Column(name = "TELEFONE_2")
    private String telefone2;
    
    @Column(name = "TELEFONE_3")
    private String telefone3;
    
    @Column(name = "TELEFONE_4")
    private String telefone4;
    
    @Column(name = "FAX")
    private String fax;
    
    @Column(name = "SITE")
    private String site;
    
    @Column(name = "EMAIL")
    private String email;

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }

    public String getTelefone4() {
        return telefone4;
    }

    public void setTelefone4(String telefone4) {
        this.telefone4 = telefone4;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
