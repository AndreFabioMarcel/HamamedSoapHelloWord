package br.com.cobrancas.resource;

import br.com.cobrancas.dto.CidadeDto;
import br.com.cobrancas.modelo.Cidades;
import br.com.cobrancas.repository.CidadeRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("cidade")
@Stateless
@Produces("application/json")
public class CidadeResource {
    
    @Inject
    private CidadeDto.RepresentationBuilder cidadeDtoBuilder;
    @Inject    
    private CidadeRepository cidadeRepository;
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") final Long id){
        
        final Cidades cidade = cidadeRepository.find(id);        
             
        if(cidade == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(cidadeDtoBuilder.toRepresentation(cidade)).build();
    }
    
    @GET
    public Response findAll(final CidadeDto dto){
        final List<CidadeDto> cidades = cidadeDtoBuilder.toRepresentation(cidadeRepository.findAll());        
        return Response.ok(cidades).build();
    }
}
