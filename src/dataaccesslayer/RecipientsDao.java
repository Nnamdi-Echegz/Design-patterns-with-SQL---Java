/**
 * Student Name:Nnamdi Echegini
 * Student Number: 041057562
 * Course & Section: 22_CST8288_013(lab section)
 * Assignment:Lab2 
 * description: Interface class initializing methods to be implemented in the various classes
 */
package dataaccesslayer;
import java.util.List;

import transferobjects.RecipientsDTO;


public interface RecipientsDao {
 
    List<RecipientsDTO> getAllRecipients();
    public RecipientsDTO getRep();
	//List<Author> getAuthorsByFirstName(String firstName);
	RecipientsDTO getRecipientsByAwardID(Integer awardID);
	void addRecipients(RecipientsDTO recipients);
	void updateRecipients(RecipientsDTO recipients);
	void deleteRecipients(RecipientsDTO recipients);
}
