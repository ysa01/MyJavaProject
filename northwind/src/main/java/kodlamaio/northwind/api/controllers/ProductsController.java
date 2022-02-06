package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	
	private ProductService productService;
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")///api/products/getall aslında url bu bunla gelirsen bu methodu tetiklersin
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
	};
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {//paremetre alırken @RequestBody annotasyonu koyarız gelen isteğin bir body si var demek yani bir json formatında product var demek bizim veri tabanımızdaki produk nesnesinin alanları ile ilişkilendiriyor 
		return this.productService.add(product);
	}
	
}
