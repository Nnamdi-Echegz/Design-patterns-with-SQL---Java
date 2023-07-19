/**
 * Student Name:Nnamdi Echegini
 * Student Number: 041057562
 * Course & Section: 22_CST8288_013(lab section)
 * Assignment:Lab2 
 */
package businesslayer;

/**
 *
 * custom exception to be thrown when the data is not in valid format
 */
public class ValidationException extends Exception {
	
	public ValidationException(){
		super("Data not in valid format");
	}
	
	public ValidationException(String message){
		super(message);
	}
	
	public ValidationException(String message, Throwable throwable){
		super(message, throwable);
	}
	
	public ValidationException(Throwable throwable){
		super(throwable);
	}
    
}
