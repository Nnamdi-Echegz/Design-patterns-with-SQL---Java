/**
 * Student Name:Nnamdi Echegini
 * Student Number: 041057562
 * Course & Section: 22_CST8288_013(lab section)
 * Assignment:Lab2 
 * 
 */
package echegini.nnamdi.lab2;

import businesslayer.RecipientsBusinessLogic;
import businesslayer.ValidationException;
import transferobjects.RecipientsDTO;

import java.util.List;

/**
 *
 * @author ThinkPad
 */
public class SimpleDemo {
    
    public void demo(){
		try{
			RecipientsBusinessLogic logic = new RecipientsBusinessLogic();
			List<RecipientsDTO> list = null;
			RecipientsDTO recipient = null;
                        RecipientsDTO rep = null;
                        
                        
                       list = logic.getAllRecipients();
                       rep = logic.rep();
			 printColInfo(rep);
			System.out.println("Printing Recipients");
			
                        printColHeader(rep);
			printRecipients(list);
			
			System.out.println("Printing One Recipient");
			recipient = logic.getRecipients(1);
                        printColHeader(rep);
			printRecipients(recipient);
			System.out.println();
			
			System.out.println("Inserting One Recipient");
			recipient = new RecipientsDTO();
			recipient.setName("Nnamdi Echegini");
			recipient.setYear("2023");
                        recipient.setCity("Ottawa");
                        recipient.setCategory("Education");
			logic.addRecipients(recipient);
			list = logic.getAllRecipients();
                        printColHeader(rep);
			printRecipients(list);
			
			System.out.println("Updating last recipient");
			Integer updatePrimaryKey = list.get(list.size() - 1).getAwardID();
			recipient = new RecipientsDTO();
			recipient.setAwardID(updatePrimaryKey);
			recipient.setName("Ngozi Echegini");
			recipient.setYear("2023");
                        recipient.setCity("Toronto");
                        recipient.setCategory("Education");
			logic.updateRecipients(recipient);
			list = logic.getAllRecipients();
                        printColHeader(rep);
			printRecipients(list);
			
			System.out.println("Deleting last recipient");
			recipient = list.get(list.size() - 1);
			logic.deleteRecipients(recipient);
			list = logic.getAllRecipients();
                        printColHeader(rep);
			printRecipients(list);	
		}
		catch(ValidationException e){
			System.err.println(e.getMessage());
		}

	}
    /**
     * prints each recipient
     * 
     */
	
	private static void printRecipients(RecipientsDTO recipients){
	    	String output = String.format("%-8s %-20s %-8s %-12s %-30s",
	    			recipients.getAwardID().toString(),
	    			recipients.getName(),
	    			recipients.getYear(),
                                recipients.getCity(),
                                recipients.getCategory()
                );
	    	System.out.println(output);
	}
	
	private static void printRecipients(List<RecipientsDTO> recipients){
            
	    for(RecipientsDTO recipient : recipients){
	    	printRecipients(recipient);
	    }
	    System.out.println();
	}
	/**
         * ptrints formated string of column header above each data field
         * 
         */
private static void printColHeader(RecipientsDTO recipients){
    if(recipients == null) return;
    
    String output = String.format("%-8s %-20s %-8s %-12s %-30s", recipients.getName(0),recipients.getName(1),
            recipients.getName(2), recipients.getName(3), recipients.getName(4));
    System.out.println(output);
    
}
/**
 * 
 * prints information presented in each column
 */
    
private static void printColInfo(RecipientsDTO recipients){
    if (recipients ==null) return;
    
    System.out.println("column information");
    int count =recipients.getCount();
    System.out.println("=======================");
    System.out.println("Column count "+ count);
    
    for(int i=0; i< count; i++){
        System.out.println("Column Name: " + recipients.getName(i));
        System.out.println("Column Type (MYSQL): " + recipients.getType(i));
        System.out.println("Corresponding Java class: " + recipients.getJava(i));
        System.out.println();
    }
}
}
