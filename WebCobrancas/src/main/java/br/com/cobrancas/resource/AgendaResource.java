package br.com.cobrancas.resource;

import br.com.cobrancas.dto.AgendaDto;
import br.com.cobrancas.modelo.Agendas;
import br.com.cobrancas.repository.AgendaRepository;
import br.com.cobrancas.service.AgendaService;
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

@Path("agenda")
@Stateless
@Produces("application/json")
public class AgendaResource {
    
    @Inject
    private AgendaDto.RepresentationBuilder agendaDtoBuilder;
    @Inject    
    private AgendaRepository agendaRepository;
    @Inject
    private AgendaService agendaService;
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") final Long id){
        
        final Agendas agenda = agendaRepository.find(id);        
             
        if(agenda == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(agendaDtoBuilder.toRepresentation(agenda)).build();
    }
    
    @GET
    @Produces("application/json")
    public Response findAll(){
        final List<AgendaDto> agendas = agendaDtoBuilder.toRepresentation(agendaRepository.findAll());        
        return Response.ok(agendas).build();
    }
    
    @POST
    public Response create(final AgendaDto dto) {
        final Agendas agenda = agendaDtoBuilder.fromRepresentation(dto, Agendas.Builder.create());
        agendaService.persist(agenda);
        return Response.created(null).entity(agendaDtoBuilder.toRepresentation(agenda)).build();
    }
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, final AgendaDto dto) {
        final Agendas agenda = agendaDtoBuilder.fromRepresentation(dto, Agendas.Builder.from(
        agendaRepository.find(dto.getId())));
        return Response.created(null).entity(agendaDtoBuilder.toRepresentation(agendaService.merge(agenda))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final Long id) {
        agendaService.remove(agendaRepository.find(id));
        return Response.noContent().build();
    }
}
