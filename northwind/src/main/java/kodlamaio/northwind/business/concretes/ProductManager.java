package kodlamaio.northwind.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import net.bytebuddy.asm.Advice.This;

@Service
public class ProductManager implements ProductService{
	
	private ProductDao productDao;
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data Listelendi.");//burda jpa bize hazır repository methodlarını getiritor.
	}

	@Override
	public Result add(Product product) {
		
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklendi.");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		//business codes
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Data Listelendi.");

	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data Listelendi.");

	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data Listelendi.");//burda jpa bize hazır repository methodlarını getiritor.

	}

	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories), "Data Listelendi.");//burda jpa bize hazır repository methodlarını getiritor.

	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), "Data Listelendi.");//burda jpa bize hazır repository methodlarını getiritor.
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName), "Data Listelendi.");//burda jpa bize hazır repository methodlarını getiritor.
	}

	@Override
	public DataResult<List<Product>> GetByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.GetByNameAndCategory(productName, categoryId), "Data Listelendi.");//burda jpa bize hazır repository methodlarını getiritor.
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize); // çok önemli pageNodan -1 çıkarma sebebimiz db sayfalamayı 0 dan başlatmasıdır.yani sayfa numarasını 1 gönderirseniz 2 den başlar.
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());//Burda getContent kullanma sebebimiz Page<Product> dönmesi onun için get content metodu kullandık List<Product> döndürkdük
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "id"); // veritabanından veriyi çekerken hangi sıralamanın ASC/DSC mi olduğunu belirliyoruz.
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Sıralama Başarılı");
	}

}
