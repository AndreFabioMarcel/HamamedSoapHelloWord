package br.com.cobrancas.resource;

import br.com.cobrancas.dto.UsuarioEntidadeDto;
import br.com.cobrancas.modelo.UsuariosEntidades;
import br.com.cobrancas.repository.UsuarioEntidadeRepository;
import br.com.cobrancas.service.UsuarioEntidadeService;
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

@Path("usuarioentidade")
@Stateless
@Produces("application/json")
public class UsuarioEntidadeResource {
    
    @Inject
    private UsuarioEntidadeDto.RepresentationBuilder usuarioEntidadeDtoBuilder;
    @Inject    
    private UsuarioEntidadeRepository usuarioEntidadeRepository;
    @Inject
    private UsuarioEntidadeService usuarioEntidadeService;
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") final Long id){
        
        final UsuariosEntidades usuarioEntidade = usuarioEntidadeRepository.find(id);        
             
        if(usuarioEntidade == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usuarioEntidadeDtoBuilder.toRepresentation(usuarioEntidade)).build();
    }
    
    @GET
    @Produces("application/json")
    public Response findAll(){
        final List<UsuarioEntidadeDto> usuarioEntidade = usuarioEntidadeDtoBuilder.toRepresentation(usuarioEntidadeRepository.findAll());        
        return Response.ok(usuarioEntidade).build();
    }
    
    @POST
    public Response create(final UsuarioEntidadeDto dto) {
        final UsuariosEntidades usuarioEntidade = usuarioEntidadeDtoBuilder.fromRepresentation(dto, UsuariosEntidades.Builder.create());
        usuarioEntidadeService.persist(usuarioEntidade);
        return Response.created(null).entity(usuarioEntidadeDtoBuilder.toRepresentation(usuarioEntidade)).build();
    }
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, final UsuarioEntidadeDto dto) {
        final UsuariosEntidades usuarioEntidade = usuarioEntidadeDtoBuilder.fromRepresentation(dto, UsuariosEntidades.Builder.from(
        usuarioEntidadeRepository.find(dto.getId())));
        return Response.created(null).entity(usuarioEntidadeDtoBuilder.toRepresentation(usuarioEntidadeService.merge(usuarioEntidade))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final Long id) {
        usuarioEntidadeService.remove(usuarioEntidadeRepository.find(id));
        return Response.noContent().build();
    }
}
