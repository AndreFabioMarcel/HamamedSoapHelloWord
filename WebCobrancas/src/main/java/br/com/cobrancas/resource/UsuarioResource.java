package br.com.cobrancas.resource;

import br.com.cobrancas.dto.UsuarioDto;
import br.com.cobrancas.modelo.Usuarios;
import br.com.cobrancas.repository.UsuarioRepository;
import br.com.cobrancas.service.UsuarioService;
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

@Path("usuario")
@Stateless
@Produces("application/json")
public class UsuarioResource {
    
    @Inject
    private UsuarioDto.RepresentationBuilder usuarioDtoBuilder;
    @Inject    
    private UsuarioRepository usuarioRepository;
    @Inject
    private UsuarioService usuarioService;
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") final Long id){
        
        final Usuarios usuario = usuarioRepository.find(id);        
             
        if(usuario == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usuarioDtoBuilder.toRepresentation(usuario)).build();
    }
    
    @GET
    public Response findAll(){
        final List<UsuarioDto> usuarios = usuarioDtoBuilder.toRepresentation(usuarioRepository.findAll());        
        return Response.ok(usuarios).build();
    }
    
    @POST
    public Response create(final UsuarioDto dto) {
        final Usuarios usuario = usuarioDtoBuilder.fromRepresentation(dto, Usuarios.Builder.create());
        usuarioService.persist(usuario);
        return Response.created(null).entity(usuarioDtoBuilder.toRepresentation(usuario)).build();
    }
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") final Long id, final UsuarioDto dto) {
        final Usuarios usuario = usuarioDtoBuilder.fromRepresentation(dto, Usuarios.Builder.from(
        usuarioRepository.find(dto.getId())));
        return Response.created(null).entity(usuarioDtoBuilder.toRepresentation(usuarioService.merge(usuario))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") final Long id) {
        usuarioService.remove(usuarioRepository.find(id));
        return Response.noContent().build();
    }
}
