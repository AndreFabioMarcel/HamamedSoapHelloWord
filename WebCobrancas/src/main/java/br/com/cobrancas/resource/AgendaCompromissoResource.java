package br.com.cobrancas.resource;

import br.com.cobrancas.dto.AgendaCompromissoDto;
import br.com.cobrancas.modelo.AgendasCompromissos;
import br.com.cobrancas.repository.AgendaCompromissoRepository;
import br.com.cobrancas.service.AgendaCompromissoService;
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

@Path("agendaCompromisso")
@Stateless
@Produces("application/json")
public class AgendaCompromissoResource {
    
    @Inject
    private AgendaCompromissoDto.RepresentationBuilder agendaCompromissoDtoBuilder;
    @Inject    
    private AgendaCompromissoRepository agendaCompromissoRepository;
    @Inject
    private AgendaCompromissoService agendaCompromissoService;
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") final Long id){
        
        final AgendasCompromissos agendaCompromisso = agendaCompromissoRepository.find(id);        
             
        if(agendaCompromisso == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(agendaCompromissoDtoBuilder.toRepresentation(agendaCompromisso)).build();
    }
    
    @GET
    @Produces("application/json")
    public Response findAll(){
        final List<AgendaCompromissoDto> agendaCompromissos = agendaCompromissoDtoBuilder.toRepresentation(agendaCompromissoRepository.findAll());        
        return Response.ok(agendaCompromissos).build();
    }
    
    @POST
    public Response create(final AgendaCompromissoDto dto) {
        final AgendasCompromissos agendaCompromisso = agendaCompromissoDtoBuilder.fromRepresentation(dto, AgendasCompromissos.Builder.create());
        agendaCompromissoService.persist(agendaCompromisso);
        return Response.created(null).entity(agendaCompromissoDtoBuilder.toRepresentation(agendaCompromisso)).build();
    }
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, final AgendaCompromissoDto dto) {
        final AgendasCompromissos agendaCompromisso = agendaCompromissoDtoBuilder.fromRepresentation(dto, AgendasCompromissos.Builder.from(
        agendaCompromissoRepository.find(dto.getId())));
        return Response.created(null).entity(agendaCompromissoDtoBuilder.toRepresentation(agendaCompromissoService.merge(agendaCompromisso))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final Long id) {
        agendaCompromissoService.remove(agendaCompromissoRepository.find(id));
        return Response.noContent().build();
    }
}
