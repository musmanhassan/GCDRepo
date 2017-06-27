/**
 * 
 */
package au.com.unico.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Usman
 *
 */
@Entity
@Table(name = "recieved_values")
public class RecievedValues {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "input_values")
	private Integer inputValues;

	public Integer getInputValues() {
		return inputValues;
	}

	public void setInputValues(Integer inputValues) {
		this.inputValues = inputValues;
	}

}
