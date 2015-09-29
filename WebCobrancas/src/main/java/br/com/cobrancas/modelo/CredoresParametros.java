package br.com.cobrancas.modelo;

import br.com.cobrancas.util.AbstractBuilder;
import br.com.cobrancas.util.AbstractEntityId;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "CREDORES_PARAMETROS")
public class CredoresParametros implements AbstractEntityId{ 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @NotNull
    @Column(name = "DESPESAS_HONORARIOS")
    private Double despesasHonorarios;

    @NotNull
    @Column(name = "MULTA_ATRASO")
    private Double multaAtraso;
    
    @NotNull
    @Column(name = "TAXA_JUROS")
    private Double taxaJuros;
       
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO_COMISSAO")
    private TipoComissao tipoComissao;

    @OneToOne(optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "id", nullable = false)
    private Credores credor;

    @Override
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Double getDespesasHonorarios() {
        return despesasHonorarios;
    }

    private void setDespesasHonorarios(Double despesasHonorarios) {
        this.despesasHonorarios = despesasHonorarios;
    }

    public Double getMultaAtraso() {
        return multaAtraso;
    }

    private void setMultaAtraso(Double multaAtraso) {
        this.multaAtraso = multaAtraso;
    }

    public Double getTaxaJuros() {
        return taxaJuros;
    }

    private void setTaxaJuros(Double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public TipoComissao getTipoComissao() {
        return tipoComissao;
    }

    private void setTipoComissao(TipoComissao tipoComissao) {
        this.tipoComissao = tipoComissao;
    }

    public Credores getCredor() {
        return credor;
    }

    private void setCredor(Credores credor) {
        this.credor = credor;
    }
    
    public static class Builder extends AbstractBuilder<CredoresParametros, Builder> {

        private Builder(CredoresParametros credorParametro) {
            super(credorParametro);
        }

        public static Builder create() {
            return new Builder(new CredoresParametros());
        }

        public static Builder from(CredoresParametros credorParametro) {
            return new Builder(credorParametro);
        }

        public Builder id(Long id) {
            entity.setId(id);
            return this;
        }

        public Builder despesasHonorarios(double despesasHonorarios) {
            entity.setDespesasHonorarios(despesasHonorarios);
            return this;
        }
        
        public Builder multaAtraso(double multaAtraso) {
            entity.setMultaAtraso(multaAtraso);
            return this;
        }
        
        public Builder taxaJuros(double taxaJuros) {
            entity.setTaxaJuros(taxaJuros);
            return this;
        }
        
        public Builder tipoComissao(TipoComissao tipoComissao) {
            entity.setTipoComissao(tipoComissao);
            return this;
        }

        public Builder credor(Credores credor) {
            entity.setCredor(credor);
            return this;
        }
    }
}
