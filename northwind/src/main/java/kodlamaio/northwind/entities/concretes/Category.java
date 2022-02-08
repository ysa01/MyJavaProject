package kodlamaio.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})// buna tembel yükleme denir çünkü bir ürün arattığında içinde kategory olduğu için category nesnesine geliyor categorinin altındada properties olarak liste şkelin de produclar olduğu için tekrar ürün getiriyor ve sonsuz döngü recusive döngü oluşuyor onun için sade ce istediğimiz produc ve kataegory data şeklinde getiren yapıyı kullanıyoruz
public class Category {
	@Id
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="category_name")
	private String categoryName;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
}
