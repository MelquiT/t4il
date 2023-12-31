package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

//GUI

public class Demo5 {
	// Listado de TODOS los Usuarios
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_Usuarios --> Lista
		String jpql = "select u from Usuario u";
		List<Usuario> lstUsuarios = em.createQuery(jpql, Usuario.class).getResultList();
		
		// mostrar el contenido del listado
		for(Usuario u : lstUsuarios) {
			System.out.println("Código....: "+u.getCod_usua());
			System.out.println("Nombre....: "+u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo......: "+u.getIdtipo());
			System.out.println("----------------------");
			
			
		}
		
		em.close();
		
	}
}
