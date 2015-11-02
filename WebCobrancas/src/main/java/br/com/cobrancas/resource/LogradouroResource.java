package br.com.cobrancas.resource;

import br.com.cobrancas.dto.LogradouroDto;
import br.com.cobrancas.modelo.Logradouros;
import br.com.cobrancas.repository.LogradouroRepository;
import br.com.cobrancas.service.LogradouroService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("logradouro")
@Stateless
@Produces("application/json")
@Consumes("application/json")
public class LogradouroResource {
    
    @Inject
    private LogradouroDto.RepresentationBuilder logradouroDtoBuilder;
    @Inject    
    private LogradouroRepository logradouroRepository;
    @Inject
    private LogradouroService logradouroService;
        
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") final Long id){
        
        final Logradouros logradouro = logradouroRepository.find(id);        
             
        if(logradouro == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(logradouroDtoBuilder.toRepresentation(logradouro)).build();
    }
    
    @GET
    @Produces("application/json")
    public Response findAll(){
        final List<LogradouroDto> logradouros = logradouroDtoBuilder.toRepresentation(logradouroRepository.findAll());        
        return Response.ok(logradouros).build();
    }
    
    @POST
    public Response create(final LogradouroDto dto) {
        final Logradouros logradouro = logradouroDtoBuilder.fromRepresentation(dto, Logradouros.Builder.create());
        logradouroService.persist(logradouro);
        return Response.created(null).entity(logradouroDtoBuilder.toRepresentation(logradouro)).build();
    }
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, final LogradouroDto dto) {
        final Logradouros logradouro = logradouroDtoBuilder.fromRepresentation(dto, Logradouros.Builder.from(
        logradouroRepository.find(dto.getId())));
        return Response.created(null).entity(logradouroDtoBuilder.toRepresentation(logradouroService.merge(logradouro))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final Long id) {
        logradouroService.remove(logradouroRepository.find(id));
        return Response.noContent().build();
    }
}
