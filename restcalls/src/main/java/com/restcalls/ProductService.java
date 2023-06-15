package com.restcalls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ChargesRepository chargesRepository;

	public ProductModel saveProduct(ProductModel product) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProId(product.getProId());
		productEntity.setProName(product.getProName());
		productEntity.setProCategory(product.getProCategory());
		productEntity.setProType(product.getProType());
		productEntity.setProPrice(product.getProPrice());
		ProductEntity dbProductEntity= productRepository.save(productEntity);
		ProductModel productModel= new ProductModel(dbProductEntity.getProId(), dbProductEntity.getProName(), dbProductEntity.getProType(), dbProductEntity.getProCategory(), dbProductEntity.getProPrice(), null, null, null);
		return productModel;
		
	}

	public List<ProductModel> getAll() {
		List<ProductEntity> productEntities= productRepository.findAll();
		List<ProductModel> productModels= new ArrayList<ProductModel>();
		productEntities.stream()
		               .forEach(dbProductEntity->{
		            	   ProductModel productModel= new ProductModel(dbProductEntity.getProId(), dbProductEntity.getProName(), dbProductEntity.getProType(), dbProductEntity.getProCategory(), dbProductEntity.getProPrice(), null, null, null);
		            	   productModels.add(productModel);
		               });
		return productModels;
	}
	public List<Charges> saveCharges(List<Charges> charges) {
		return chargesRepository.saveAll(charges);
	}

	public List<ProductModel> getProducts(List<ProductModel> products) {
		products.stream()
		        .forEach(product->{
		        	Charges charges=chargesRepository.findById(product.getProCategory()).get();
		        	Double discount=product.getProPrice()*charges.getDiscount()/100;
		        	product.setDiscount(discount);
		        	ProCharges proCharges= new ProCharges();
		        	double gst=product.getProPrice()*charges.getGst()/100;
		        	proCharges.setGst(gst);
		        	proCharges.setDelCharges(charges.getDelCharges());
		        	product.setCharges(proCharges);
		        	product.setFprice(product.getProPrice()-discount+gst+product.getCharges().getDelCharges());
		        });
		return products;
	}

	public String deleteProduct(Integer id) {
		productRepository.deleteById(id);
		if(productRepository.findById(id).orElse(null) == null)
		return "product deleted";
		else
			return "product not deleted";
	}

}
