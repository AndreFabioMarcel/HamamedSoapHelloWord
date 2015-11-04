package br.com.cobrancas.aplication;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.cobrancas.resource.AgendaCompromissoResource.class);
        resources.add(br.com.cobrancas.resource.AgendaResource.class);
        resources.add(br.com.cobrancas.resource.BairroResource.class);
        resources.add(br.com.cobrancas.resource.CidadeResource.class);
        resources.add(br.com.cobrancas.resource.EntidadeResource.class);
        resources.add(br.com.cobrancas.resource.EstadoResource.class);
        resources.add(br.com.cobrancas.resource.LogradouroResource.class);
        resources.add(br.com.cobrancas.resource.UsuarioEntidadeResource.class);
        resources.add(br.com.cobrancas.resource.UsuarioResource.class);
    }
    
}
