package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.Bairros;
import br.com.cobrancas.modelo.Cidades;
import br.com.cobrancas.modelo.Contatos;
import br.com.cobrancas.modelo.Entidades;
import br.com.cobrancas.modelo.Estados;
import br.com.cobrancas.modelo.Logradouros;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EntidadeDto {

    @NotNull
    private Long id;

    @NotNull
    private String cnpj;

    private String inscricaoEstadual;

    private String razaoSocial;

    private String nomeFantasia;

    private String representanteLegal;

    private Contatos contato;

    private String urlLogo;
    
    @NotNull
    private String cep;
    
    @NotNull
    private Estados estado;
    
    @NotNull
    private Cidades cidade;
    
    @NotNull
    private Bairros bairro;
    
    @NotNull
    private Logradouros logradouro;

    public EntidadeDto() {
    }

    public EntidadeDto(final Long id, final String cnpj, final String inscricaoEstadual, final String razaoSocial, final String nomeFantasia, final String representanteLegal, final Contatos contato, final String urlLogo, final String cep, final Estados estado, final Cidades cidade, final Bairros bairro, final Logradouros logradouro) {
        this.id = id;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.representanteLegal = representanteLegal;
        this.contato = contato;
        this.urlLogo = urlLogo;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
    }

    public Long getId() {
        return id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public Contatos getContato() {
        return contato;
    }

    public String getUrlLogo() {
        return urlLogo;
    }

    public String getCep() {
        return cep;
    }

    public Estados getEstado() {
        return estado;
    }

    public Cidades getCidade() {
        return cidade;
    }

    public Bairros getBairro() {
        return bairro;
    }

    public Logradouros getLogradouro() {
        return logradouro;
    }
 
    public static class DevedorDtoBuilder {

        private Long id;
        private String cnpj;
        private String inscricaoEstadual;
        private String razaoSocial;
        private String nomeFantasia;
        private String representanteLegal;
        private Contatos contato;
        private String urlLogo;
        private String cep;
        private Estados estado;
        private Cidades cidade;
        private Bairros bairro;
        private Logradouros logradouro;
        
        private DevedorDtoBuilder() {
        }

        public DevedorDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DevedorDtoBuilder cnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }
        
        public DevedorDtoBuilder inscricaoEstadual(String inscricaoEstadual) {
            this.inscricaoEstadual = inscricaoEstadual;
            return this;
        }

        public DevedorDtoBuilder razaoSocial(String razaoSocial) {
            this.razaoSocial = razaoSocial;
            return this;
        }

        public DevedorDtoBuilder nomeFantasia(String nomeFantasia) {
            this.nomeFantasia = nomeFantasia;
            return this;
        }
        
        public DevedorDtoBuilder representanteLegal(String representanteLegal) {
            this.representanteLegal = representanteLegal;
            return this;
        }

        public DevedorDtoBuilder contato(Contatos contato) {
            this.contato = contato;
            return this;
        }
        
        public DevedorDtoBuilder urlLogo(String urlLogo) {
            this.urlLogo = urlLogo;
            return this;
        }

        public DevedorDtoBuilder cep(String cep) {
            this.cep = cep;
            return this;
        }
        
        public DevedorDtoBuilder estado(Estados estado) {
            this.estado = estado;
            return this;
        }
        
        public DevedorDtoBuilder cidade(Cidades cidade) {
            this.cidade = cidade;
            return this;
        }

        public DevedorDtoBuilder bairro(Bairros bairro) {
            this.bairro = bairro;
            return this;
        }
                
        public DevedorDtoBuilder logradouro(Logradouros logradouro) {
            this.logradouro = logradouro;
            return this;
        }

        public EntidadeDto Build() {
            return new EntidadeDto(this.id, this.cnpj, this.inscricaoEstadual, this.razaoSocial, this.nomeFantasia, this.representanteLegal, this.contato, this.urlLogo, this.cep, this.estado, this.cidade, this.bairro, this.logradouro);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Entidades, EntidadeDto, Entidades.Builder> {

        public static DevedorDtoBuilder builder() {
            return new DevedorDtoBuilder();
        }
  
        @Override
        public Entidades fromRepresentation(EntidadeDto dto, Entidades.Builder builder) {
            return builder
                    .id(dto.getId())
                    .cnpj(dto.getCnpj())
                    .inscricaoEstadual(dto.getInscricaoEstadual())
                    .razaoSocial(dto.getRazaoSocial())
                    .nomeFantasia(dto.getNomeFantasia())
                    .representanteLegal(dto.getRepresentanteLegal())
                    .contato(dto.getContato())
                    .urlLogo(dto.getUrlLogo())
                    .cep(dto.getCep())
                    .estado(dto.getEstado())
                    .cidade(dto.getCidade())
                    .bairro(dto.getBairro())
                    .logradouro(dto.getLogradouro())
                    .build();
        }

        @Override
        public EntidadeDto toRepresentation(Entidades t) {
            return builder()
                    .id(t.getId())
                    .cnpj(t.getCnpj())
                    .inscricaoEstadual(t.getInscricaoEstadual())
                    .razaoSocial(t.getRazaoSocial())
                    .nomeFantasia(t.getNomeFantasia())
                    .representanteLegal(t.getRepresentanteLegal())
                    .contato(t.getContato())
                    .urlLogo(t.getUrlLogo())
                    .cep(t.getCep())
                    .estado(t.getEstado())
                    .cidade(t.getCidade())
                    .bairro(t.getBairro())
                    .logradouro(t.getLogradouro())
                    .Build();
        }
    }
}