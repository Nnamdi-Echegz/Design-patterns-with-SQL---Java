/**
 * Student Name:Nnamdi Echegini
 * Student Number: 041057562
 * Course & Section: 22_CST8288_013(lab section)
 * Assignment:Lab2 
 * 
 */
package transferobjects;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * accessors and mutators for each field object on the data base
 */
public class RecipientsDTO {
    private Integer awardID;
    private String name;
    private String year;
    private String city;
    private String category;
    
    public Integer getAwardID(){
    	return awardID;
    }
    public void setAwardID(Integer awardID){
    	this.awardID = awardID;
    }
    
    public String getName(){
    	return name;
    }
    public void setName(String name){
    	this.name = name;
    }
    
    public String getYear(){
    	return year;
    }
    public void setYear(String year){
    	this.year = year;
    }
     public String getCity(){
    	return city;
    }
    public void setCity(String city){
    	this.city = city;
    }
     public String getCategory(){
    	return category;
    }
    public void setCategory(String category){
    	this.category = category;
    }
    
    private Integer ColCount;
    private List<String> ColName;
    private List<String> ColType;
    private List<String> ColJava;
    
    public RecipientsDTO(){
    ColCount = 0;
    ColName = new ArrayList<String>();
    ColType = new ArrayList<String>();
    ColJava = new ArrayList<String>();
    }
     
    public Integer getCount()
    {
        return ColCount;
    }
    
    public void SetCount(int ct)
    {
        ColCount =ct;
    }
    
    public String getName(int ip)
    {
      
        return ColName.get(ip);
    }
    
    public void SetName(String Sp)
    {
        ColName.add(Sp);
    }
    
   
     public String getType(int ip)
     {
         return ColType.get(ip);
     }
      
    public void SetType(String Sp)
    {
         ColType.add(Sp);
    }
    
       public String getJava(int ip)
    {
        return ColJava.get(ip);
    }
    
      public void SetJava(String sp)
    {
        ColJava.add(sp);
    }

    
}
