/**
 * 
 */
package mx.com.tutum.models.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.com.tutum.dto.ProductDto;
import mx.com.tutum.models.entity.Product;
import mx.com.tutum.models.repository.IProductRepository;

/**
 * @author EduSam
 *
 */
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepository;

	@Override
	@Transactional(readOnly = true)
	public List<ProductDto> findAll() {
		List<Product> listProducts = productRepository.findAll();
		List<ProductDto> listProductsDto = new ArrayList<>();
		for (Product product : listProducts) {
			ProductDto dto = new ProductDto();
			BeanUtils.copyProperties(product, dto);
			listProductsDto.add(dto);
		}
		return listProductsDto;
	}

	@Override
	public ProductDto findById(Long id) {
		return null;
	}

	@Override
	@Transactional
	public void save(ProductDto productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		product.setCreateAt(LocalDateTime.now());
		productRepository.save(product);
	}

	@Override
	public void deleteById(Long id) {

	}

}
