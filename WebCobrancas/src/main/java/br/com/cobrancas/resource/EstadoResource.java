package br.com.cobrancas.resource;

import br.com.cobrancas.dto.EstadoDto;
import br.com.cobrancas.modelo.Estados;
import br.com.cobrancas.repository.EstadoRepository;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("estado")
@Stateless
@Produces("application/json")
public class EstadoResource {
    
    @Inject
    private EstadoDto.RepresentationBuilder estadoDtoBuilder;
    @Inject    
    private EstadoRepository estadoRepository;
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") final Long id){
        
        final Estados estado = estadoRepository.find(id);        
             
        if(estado == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(estadoDtoBuilder.toRepresentation(estado)).build();
    }
    
    @GET
    public Response findAll(final EstadoDto dto){
        final List<EstadoDto> estados = estadoDtoBuilder.toRepresentation(estadoRepository.findAll());        
        return Response.ok(estados).build();
    }
}
