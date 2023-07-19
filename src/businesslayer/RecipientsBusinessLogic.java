/**
 * Student Name:Nnamdi Echegini
 * Student Number: 041057562
 * Course & Section: 22_CST8288_013(lab section)
 * Assignment:Lab2 
 * description : this class handles the validation and cleaning of data fields
 */
package businesslayer;

import java.util.List;
import dataaccesslayer.RecipientsDao;
import dataaccesslayer.RecipientsDAOImpl;
import transferobjects.RecipientsDTO;

public class RecipientsBusinessLogic {
    
    private static final int NAME_MAX_LENGTH = 30;
	private static final int YEAR_MAX_LENGTH = 30;
        private static final int CITY_MAX_LENGTH = 30;
	private static final int CATEGORY_MAX_LENGTH = 30;
	
	private RecipientsDao recipientsDao = null;
	
	public RecipientsBusinessLogic(){
		recipientsDao = new RecipientsDAOImpl();
	}
	
	public List<RecipientsDTO> getAllRecipients(){
		return recipientsDao.getAllRecipients();
	}
	
	public RecipientsDTO getRecipients(Integer awardID){
		return recipientsDao.getRecipientsByAwardID(awardID);
	}
	
        public RecipientsDTO rep()
        {
            return recipientsDao.getRep();
        }
	public void addRecipients(RecipientsDTO recipients) throws ValidationException{
		cleanRecipients(recipients);
		validateRecipients(recipients);
		recipientsDao.addRecipients(recipients);
	}
	
	public void updateRecipients(RecipientsDTO recipients) throws ValidationException{
		cleanRecipients(recipients);
		validateRecipients(recipients);
		recipientsDao.updateRecipients(recipients);
	}
	
	public void deleteRecipients(RecipientsDTO recipients){
		recipientsDao.deleteRecipients(recipients);
	}
        /**
         * This method removes white spaces from each of the fields mentioned in it
         * 
         */
	
	private void cleanRecipients(RecipientsDTO recipients){
		if(recipients.getName() != null){ 
			recipients.setName(recipients.getName().trim());
		}
		if(recipients.getYear() != null){ 
			recipients.setYear(recipients.getYear().trim());
		}
                if(recipients.getCity() != null){ 
			recipients.setCity(recipients.getCity().trim());
		}
		if(recipients.getCategory() != null){ 
			recipients.setCategory(recipients.getCategory().trim());
		}
	}
	/**
         * 
         * @param recipients object throught which the RecipientsDTO validates field data 
         * @throws ValidationException for program exceptions / when any validation rules are not obeyed
         */
	private void validateRecipients(RecipientsDTO recipients) throws ValidationException{
		validateString(recipients.getName(), "Name", NAME_MAX_LENGTH, true);
		validateString(recipients.getYear(), "Year", YEAR_MAX_LENGTH, true);
                validateString(recipients.getCity(), "City", CITY_MAX_LENGTH, true);
		validateString(recipients.getCategory(), "Category", CATEGORY_MAX_LENGTH, true);
	}
        
	
	private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
	    throws ValidationException{
		if(value == null && isNullAllowed){
			// return; // null permitted, nothing to validate
		}
		else if(value == null && ! isNullAllowed){
		    throw new ValidationException(String.format("%s cannot be null", 
		    		fieldName));
		}
		else if(value.length() == 0){
			throw new ValidationException(String.format("%s cannot be empty or only whitespace", 
					fieldName));
		}
		else if(value.length() > maxLength){
			throw new ValidationException(String.format("%s cannot exceed %d characters", 
					fieldName, maxLength));
		}
	}
    
}
