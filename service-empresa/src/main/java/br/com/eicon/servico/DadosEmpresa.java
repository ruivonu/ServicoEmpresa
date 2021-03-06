package br.com.eicon.servico;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.eicon.dao.Empresa;
import br.com.eicon.dao.dto.EmpresaDTO;

@Path("cadastro")
public class DadosEmpresa {
	
	@GET
    @Produces("text/plain")
	@Path("get")
    public String getDadosEmpresa() {
        return "Teste....";
    }
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("addempresa")
    public Response setNewEmpresa(@Valid EmpresaDTO empresaDTO){
		System.out.println(empresaDTO);
		return DadosEmpresa.inserirEmpresa(empresaDTO);
		//return Response.accepted().build();
    }
	
	public static Response inserirEmpresa(EmpresaDTO empresaDTO) {
	    try {
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("serviceEmpresa");
			EntityManager em  = emf.createEntityManager();
			
	    	Empresa empresa = Empresa.fromDTO(empresaDTO);
	    	
	    	System.out.println("persistencia");
	    	
	        em.getTransaction().begin();
			em.persist(empresa);
			em.getTransaction().commit();
			em.close();
			
			return Response.created(new URI("/cadastro/addempresa/" + empresa.getIm())).build();
	    } catch (Exception e) {
	    	return Response.serverError().entity("ERRO AO GRAVAR EMPRESA: " + e.getMessage()).build();
	    }
	}
}