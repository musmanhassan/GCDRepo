/**
 * 
 */
package au.com.unico.repositiry;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import au.com.unico.entity.SumValues;

/**
 * @author Usman
 *
 */
public interface SumValuesRespositiry extends PagingAndSortingRepository<SumValues, Long> {

	@Query("select sum(sumVal.inputValues) from SumValues sumVal")
	Integer getSumValues();

}
