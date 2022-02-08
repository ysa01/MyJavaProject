package kodlamaio.northwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

//interface intarfacei extend eder
public interface ProductDao extends JpaRepository<Product,Integer>{
	
	Product getByProductName(String productName);
	
	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
	
	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);// jpa repository için Category demek default olarak categorynin primerykeyini al demek yani categoryId yi al demek
	
	List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> GetByNameAndCategory(String productName, int categoryId);
	
	@Query("select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) "
			+ "from Category c inner join c.products p") // bu sorguda sql de olduğu gibi ON yazıp iki nesnenin idlerini eşitlemedik kendi otomatik eşliyor.
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	
	//select * from Categor
}
