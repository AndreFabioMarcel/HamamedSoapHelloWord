package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.Devedores;
import br.com.cobrancas.modelo.Entidades;
import br.com.cobrancas.modelo.Pessoas;
import br.com.cobrancas.util.AbstractRepresentationBuilder;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class DevedorDto {

    @NotNull
    private Long id;
    
    private String observacao;
    
    @NotNull
    private LocalDate dataCadastro;
    
    @NotNull
    private Pessoas pessoa;
    
    @NotNull
    private Entidades entidade;
    
    public DevedorDto() {
    }

    public DevedorDto(final Long id, final String observacao, final LocalDate dataCadastro, final Pessoas pessoa, final Entidades entidade) {
        this.id = id;
        this.observacao = observacao;
        this.dataCadastro = dataCadastro;
        this.pessoa = pessoa;
        this.entidade = entidade;
    }

    public Long getId() {
        return id;
    }

    public String getObservacao() {
        return observacao;
    }
    
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Pessoas getPessoa() {
        return pessoa;
    }

    public Entidades getEntidade() {
        return entidade;
    }

    public static class DevedorDtoBuilder {

        private Long id;
        private String observacao;
        private LocalDate dataCadastro;
        private Pessoas pessoa;
        private Entidades entidade;
        
        private DevedorDtoBuilder() {
        }

        public DevedorDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DevedorDtoBuilder observacao(String observacao) {
            this.observacao = observacao;
            return this;
        }
        
        public DevedorDtoBuilder dataCadastro(LocalDate dataCadastro) {
            this.dataCadastro = dataCadastro;
            return this;
        }
        
        public DevedorDtoBuilder pessoa(Pessoas pessoa) {
            this.pessoa = pessoa;
            return this;
        }
        
        public DevedorDtoBuilder entidade(Entidades entidade) {
            this.entidade = entidade;
            return this;
        }

        public DevedorDto Build() {
            return new DevedorDto(this.id, this.observacao, this.dataCadastro, this.pessoa, this.entidade);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Devedores, DevedorDto, Devedores.Builder> {

        public static DevedorDtoBuilder builder() {
            return new DevedorDtoBuilder();
        }

        @Override
        public Devedores fromRepresentation(DevedorDto dto, Devedores.Builder builder) {
            return builder
                    .id(dto.getId())
                    .observacao(dto.getObservacao())
                    .dataCadastro(dto.getDataCadastro())
                    .pessoa(dto.getPessoa())
                    .entidade(dto.getEntidade())
                    .build();
        }

        @Override
        public DevedorDto toRepresentation(Devedores t) {
            return builder()
                    .id(t.getId())
                    .observacao(t.getObservacao())
                    .dataCadastro(t.getDataCadastro())
                    .pessoa(t.getPessoa())
                    .entidade(t.getEntidade())
                    .Build();
        }
    }
}