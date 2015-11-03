package br.com.cobrancas.dto;

import br.com.cobrancas.modelo.Credores;
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
public class CredorDto {

    @NotNull
    private Long id;
    
    @NotNull
    private LocalDate dataCadastro;
    
    @NotNull
    private Pessoas pessoa;
    
    @NotNull
    private Entidades entidade;
    
    public CredorDto() {
    }

    public CredorDto(final Long id, final LocalDate dataCadastro, final Pessoas pessoa, final Entidades entidade) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.pessoa = pessoa;
        this.entidade = entidade;
    }

    public Long getId() {
        return id;
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

    public static class CredorDtoBuilder {

        private Long id;
        private LocalDate dataCadastro;
        private Pessoas pessoa;
        private Entidades entidade;
        
        private CredorDtoBuilder() {
        }

        public CredorDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public CredorDtoBuilder dataCadastro(LocalDate dataCadastro) {
            this.dataCadastro = dataCadastro;
            return this;
        }
        
        public CredorDtoBuilder pessoa(Pessoas pessoa) {
            this.pessoa = pessoa;
            return this;
        }
        
        public CredorDtoBuilder entidade(Entidades entidade) {
            this.entidade = entidade;
            return this;
        }

        public CredorDto Build() {
            return new CredorDto(this.id, this.dataCadastro, this.pessoa, this.entidade);
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Credores, CredorDto, Credores.Builder> {

        public static CredorDtoBuilder builder() {
            return new CredorDtoBuilder();
        }

        @Override
        public Credores fromRepresentation(CredorDto dto, Credores.Builder builder) {
            return builder
                    .id(dto.getId())
                    .dataCadastro(dto.getDataCadastro())
                    .pessoa(dto.getPessoa())
                    .entidade(dto.getEntidade())
                    .build();
        }

        @Override
        public CredorDto toRepresentation(Credores t) {
            return builder()
                    .id(t.getId())
                    .dataCadastro(t.getDataCadastro())
                    .pessoa(t.getPessoa())
                    .entidade(t.getEntidade())
                    .Build();
        }
    }
}