package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.Bairros;
import br.com.cobrancas.modelo.Cidades;
import br.com.cobrancas.modelo.Enderecos;
import br.com.cobrancas.modelo.Estados;
import br.com.cobrancas.modelo.Logradouros;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EnderecoDto {

    @NotNull
    private Long id;
    
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

    public EnderecoDto() {
    }

    public EnderecoDto(final Long id, final String cep, final Estados estado, final Cidades cidade, final Bairros bairro, final Logradouros logradouro) {
        this.id = id;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
    }

    public Long getId() {
        return id;
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

        public EnderecoDto Build() {
            return new EnderecoDto(this.id, this.cep, this.estado, this.cidade, this.bairro, this.logradouro);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Enderecos, EnderecoDto, Enderecos.Builder> {

        public static DevedorDtoBuilder builder() {
            return new DevedorDtoBuilder();
        }

        @Override
        public Enderecos fromRepresentation(EnderecoDto dto, Enderecos.Builder builder) {
            return builder
                    .id(dto.getId())
                    .cep(dto.getCep())
                    .estado(dto.getEstado())
                    .cidade(dto.getCidade())
                    .bairro(dto.getBairro())
                    .logradouro(dto.getLogradouro())
                    .build();
        }

        @Override
        public EnderecoDto toRepresentation(Enderecos t) {
            return builder()
                    .id(t.getId())
                    .cep(t.getCep())
                    .estado(t.getEstado())
                    .cidade(t.getCidade())
                    .bairro(t.getBairro())
                    .logradouro(t.getLogradouro())
                    .Build();
        }
    }
}