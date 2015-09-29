package br.com.cobrancas.resource;

import br.com.cobrancas.dto.BairroDto;
import br.com.cobrancas.modelo.Bairros;
import br.com.cobrancas.repository.BairroRepository;
import br.com.cobrancas.service.BairroService;
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

@Path("bairro")
@Stateless
@Produces("application/json")
@Consumes("application/json")
public class BairroResource {
    
    @Inject
    private BairroDto.RepresentationBuilder bairroDtoBuilder;
    @Inject    
    private BairroRepository bairroRepository;
    @Inject
    private BairroService bairroService;
        
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") final Long id){
        
        final Bairros bairro = bairroRepository.find(id);        
             
        if(bairro == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(bairroDtoBuilder.toRepresentation(bairro)).build();
    }
    
    @GET
    public Response findAll(final BairroDto dto){
        final List<BairroDto> bairros = bairroDtoBuilder.toRepresentation(bairroRepository.findAll());        
        return Response.ok(bairros).build();
    }
    
    @POST
    public Response create(final BairroDto dto) {
        final Bairros bairro = bairroDtoBuilder.fromRepresentation(dto, Bairros.Builder.create());
        bairroService.persist(bairro);
        return Response.created(null).entity(bairroDtoBuilder.toRepresentation(bairro)).build();
    }
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, final BairroDto dto) {
        final Bairros bairro = bairroDtoBuilder.fromRepresentation(dto, Bairros.Builder.from(
        bairroRepository.find(dto.getId())));
        return Response.created(null).entity(bairroDtoBuilder.toRepresentation(bairroService.merge(bairro))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final Long id) {
        bairroService.remove(bairroRepository.find(id));
        return Response.noContent().build();
    }
}
