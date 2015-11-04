package br.com.cobrancas.resource;

import br.com.cobrancas.dto.EntidadeDto;
import br.com.cobrancas.modelo.Entidades;
import br.com.cobrancas.repository.EntidadeRepository;
import br.com.cobrancas.service.EntidadeService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("entidade")
@Stateless
@Produces("application/json")
public class EntidadeResource {
    
    @Inject
    private EntidadeDto.RepresentationBuilder entidadeDtoBuilder;
    @Inject    
    private EntidadeRepository entidadeRepository;
    @Inject
    private EntidadeService entidadeService;
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") final Long id){
        
        final Entidades entidade = entidadeRepository.find(id);        
             
        if(entidade == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(entidadeDtoBuilder.toRepresentation(entidade)).build();
    }
    
    @GET
    @Produces("application/json")
    public Response findAll(){
        final List<EntidadeDto> entidades = entidadeDtoBuilder.toRepresentation(entidadeRepository.findAll());        
        return Response.ok(entidades).build();
    }
    
    @POST
    public Response create(final EntidadeDto dto) {
        final Entidades entidade = entidadeDtoBuilder.fromRepresentation(dto, Entidades.Builder.create());
        entidadeService.persist(entidade);
        return Response.created(null).entity(entidadeDtoBuilder.toRepresentation(entidade)).build();
    }
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, final EntidadeDto dto) {
        final Entidades entidade = entidadeDtoBuilder.fromRepresentation(dto, Entidades.Builder.from(
        entidadeRepository.find(dto.getId())));
        return Response.created(null).entity(entidadeDtoBuilder.toRepresentation(entidadeService.merge(entidade))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final Long id) {
        entidadeService.remove(entidadeRepository.find(id));
        return Response.noContent().build();
    }
}
