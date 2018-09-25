package jUnit;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Assert;
import org.junit.Test;

public class DadosEmpresa {
	@Test
    public void getDadosEmpresa() {
		Assert.assertEquals("OK", "Teste....", "Teste....");
    }
	@Test
    public void setNewEmpresa() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("serviceEmpresa");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 
		String[] array = new String[8];
		array[0] = "12345678000195";
		array[1] = "123456";
		array[2] = "TESTE SERVICO EMPRESA";
		array[3] = "01/01/2018";
		array[4] = "";
		array[5] = "Rua teste empresa, 1";
		array[6] = "1";
		array[7] = "1";
		@SuppressWarnings("deprecation")
		Date data = new Date(1,1,2018);
		try{
			Empresa empr = new Empresa();
			empr.setCnpj(array[0]);
			empr.setIm(array[1]);
			empr.setRazaosocial(array[2]);
			empr.setDtabertura((java.sql.Date) data);
			empr.setDtencerramento(null);
			empr.setEndereco(array[5]);
			empr.setSituacao(new Integer(array[6]));
			empr.setAtivo(new Integer(array[7]));
			
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
