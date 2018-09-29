package br.com.eicon.servico;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.eicon.dao.Empresa;

@Path("cadastro")
public class DadosEmpresa {
	
	@GET
    @Produces("text/plain")
	@Path("get")
    public String getDadosEmpresa() {
        return "Teste....";
    }
	
	@POST
	@Path("set")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response setNewEmpresa(@FormParam("cnpj") String cnpj
    						 ,@FormParam("im") String im
    						 ,@FormParam("razao") String razao
    						 ,@FormParam("dtAbertura") Date dtAbertura
    						 ,@FormParam("dtEncerramento") Date dtEncerramento
    						 ,@FormParam("endereco") String endereco 
    						 ,@FormParam("situacao") int situacao
    						 ,@FormParam("ativo") int ativo) {
		
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("serviceEmpresa");
			EntityManager em  = emf.createEntityManager();
			
			Empresa empr = new Empresa(cnpj,im,razao,dtAbertura,dtEncerramento,endereco,situacao,ativo);
			
			empr.setCnpj(cnpj);
			empr.setIm(im);
			empr.setRazaosocial(razao);
			empr.setDtabertura(dtAbertura);
			empr.setDtencerramento(dtEncerramento);
			empr.setEndereco(endereco);
			empr.setSituacao(situacao);
			empr.setAtivo(ativo);
			
			em.getTransaction().begin();
			em.persist(empr);
			em.getTransaction().commit();
			em.close();
			return Response.status(201).build();
		}catch(Exception e){
			return Response.status(500).build();
		}
    }
}
