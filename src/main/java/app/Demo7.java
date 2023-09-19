package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;
import model.Usuario;

//GUI

public class Demo7 {
	//Tareita XD 
	// Listado de TODOS los Usuarios, mostrando nombre del proveedor y nombre de categoria 
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_Usuarios --> Lista
		String jpql = "select p from Producto p";
		List<Producto> lstProductos = em.createQuery(jpql, Producto.class).getResultList();
		
		// mostrar el contenido del listado
		for(Producto p : lstProductos) {
			System.out.println("Código....: "+p.getId_prod());
			System.out.println("Nombre....: "+p.getDes_prod());
			System.out.println("CAtegoria.: "+p.getObjCategoria().getDescripcion());
			System.out.println("Proveedor.: "+p.getObjProveedor().getNombre_rs());
			System.out.println("----------------------");
			
			
		}
		
		em.close();
		
	}
}
