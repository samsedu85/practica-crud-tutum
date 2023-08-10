/**
 * 
 */
package mx.com.tutum.models.service;

import java.util.List;

import mx.com.tutum.dto.ProductDto;

/**
 * @author EduSam
 *
 */
public interface IProductService {
	
	public List<ProductDto> findAll();
	
	public ProductDto findById(Long id);
	
	public void save(ProductDto productDto);
	
	public void deleteById(Long id);
	
	public List<ProductDto> findByNameContainingIgnoreCase(String keyword);

}
