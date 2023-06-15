/**
 * 
 */
package poo.entities;

/**
 * Classe que contem o nome de um departamento
 * 
 * @author Matos - 11.06.2023
 *
 */
public class Department {

	private String name;

	public Department() {
		
	}
	
	public Department(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
