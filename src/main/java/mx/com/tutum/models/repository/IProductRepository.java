/**
 * 
 */
package mx.com.tutum.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.tutum.models.entity.Product;

/**
 * @author EduSam
 *
 */
public interface IProductRepository extends JpaRepository<Product, Long> {

}
