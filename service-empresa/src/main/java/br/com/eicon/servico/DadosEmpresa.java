package br.com.eicon.servico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.eicon.dao.Empresa;

@Path("cadastro")
public class DadosEmpresa {
	
	@GET
    @Produces("text/plain")
	@Path("get")
    public String getDadosEmpresa() {
        return "Teste....";
    }
	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	//@Consumes("application/json")
	@POST
	@Path("set")
    public void setNewEmpresa(Empresa[] array) {
		//String cnpj, String im, String razaosocial, Calendar dtabertura, Calendar dtencerramento, String endereco, int situacao, int ativo
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("serviceEmpresa");
		for(Empresa emprJson : array ){
			try{
				Empresa empr = new Empresa();
				empr.setCnpj(emprJson.getCnpj());
				empr.setIm(emprJson.getIm());
				empr.setRazaosocial(emprJson.getRazaosocial());
				empr.setDtabertura(emprJson.getDtabertura());
				empr.setDtencerramento(emprJson.getDtencerramento());
				empr.setEndereco(emprJson.getEndereco());
				empr.setSituacao(emprJson.getSituacao());
				empr.setAtivo(emprJson.getAtivo());
				
				EntityManager em  = emf.createEntityManager();
				em.getTransaction().begin();
				em.persist(empr);
				em.getTransaction().commit();
				em.close();
			}catch(Exception e){
				throw e;
			}
		}
    }
}
