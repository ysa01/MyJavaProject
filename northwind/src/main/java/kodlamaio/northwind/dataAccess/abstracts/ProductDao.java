package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Product;

//interface intarfacei extend eder
public interface ProductDao extends JpaRepository<Product,Integer>{
	
}
