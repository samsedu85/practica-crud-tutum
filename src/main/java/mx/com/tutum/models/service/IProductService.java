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
	
	public ProductDto save(ProductDto productDto, Integer update);
	
	public void deleteById(Long id);

}
