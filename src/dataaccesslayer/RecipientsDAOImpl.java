/**
 * Student Name:Nnamdi Echegini
 * Student Number: 041057562
 * Course & Section: 22_CST8288_013(lab section)
 * Assignment:Lab2 
 */
package dataaccesslayer;

import java.util.List;

import transferobjects.RecipientsDTO;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;


public class RecipientsDAOImpl implements RecipientsDao {
     
    RecipientsDTO recp = null;
    
    public RecipientsDTO getRep(){
    
        return recp;
    }
	@Override
	public List<RecipientsDTO> getAllRecipients() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
                ResultSetMetaData rsmt = null;
		ArrayList<RecipientsDTO> recipients = null;
		try{
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
					"SELECT AwardID, Name, Year, City, Category FROM Recipients ORDER BY AwardID");
			rs = pstmt.executeQuery();
			recipients = new ArrayList<RecipientsDTO>();
                        rsmt = rs.getMetaData();
                        
                       
			while(rs.next()){
				RecipientsDTO recipient = new RecipientsDTO();
				recipient.setAwardID(rs.getInt("AwardID"));
				recipient.setName(rs.getString("Name"));
				recipient.setYear(rs.getString("Year"));
                                recipient.setCity(rs.getString("City"));
                                recipient.setCategory(rs.getString("Category"));
				recipients.add(recipient);
                                
                                recp = recipient;
			}
                        
                        recp.SetCount(rsmt.getColumnCount());//
                        
                        
                        int Count = rsmt.getColumnCount();
                        for(int i=1; i< Count+1; i++)
                        {
                            recp.SetName(rsmt.getColumnName(i));
                            recp.SetJava(rsmt.getColumnClassName(i));
                            recp.SetType(rsmt.getColumnTypeName(i));
                           
                        }
         
                        
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return recipients;
	}
        
        /**
         * 
         * @param awardID key id for all recipients
         * @return RecipientsDTO object
         * This method retrieves RecipientsDTO field object from database by key id (awardID)
         */

	@Override
        
	public RecipientsDTO getRecipientsByAwardID(Integer awardID) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RecipientsDTO recipient = null;
                ResultSetMetaData rsmt = null;
		try{
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
					"SELECT AwardID, Name, Year, City, Category FROM Recipients WHERE AwardID = ?");
			pstmt.setInt(1, awardID.intValue());
			rs = pstmt.executeQuery();
                        rsmt = rs.getMetaData();
                        
			while(rs.next()){
				recipient = new RecipientsDTO();
				recipient.setAwardID(rs.getInt("AwardID"));
				recipient.setName(rs.getString("Name"));
				recipient.setYear(rs.getString("Year"));
                                recipient.setCity(rs.getString("City"));
                                recipient.setCategory(rs.getString("Category"));
                                
                                recp = recipient;
			}
                        recp.SetCount(rsmt.getColumnCount());//
                        
                        
                        int Count = rsmt.getColumnCount();
                        for(int i=1; i< Count+1; i++)
                        {
                            recp.SetName(rsmt.getColumnName(i));
                            recp.SetJava(rsmt.getColumnClassName(i));
                            recp.SetType(rsmt.getColumnTypeName(i));
                           
                        }
		}
                
                 
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(rs != null){ rs.close(); } }
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
		return recipient;
	}
        /**
         * This method adds recipients to the field
         * 
         */

	@Override
	public void addRecipients(RecipientsDTO recipients) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			DataSource ds = new DataSource();
			con = ds.createConnection();
			
			pstmt = con.prepareStatement(
					"INSERT INTO Recipients (Name, Year, City, Category) " +
			        "VALUES(?, ?, ?, ?)");
			pstmt.setString(1, recipients.getName());
			pstmt.setString(2, recipients.getYear());
                        pstmt.setString(3, recipients.getCity());
			pstmt.setString(4, recipients.getCategory());
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
	}
        /**
         * 
         * This method is used to update a recipients current information 
         */
	@Override
	public void updateRecipients(RecipientsDTO recipients) {
			Connection con = null;
			PreparedStatement pstmt = null;
			try{
				DataSource ds = new DataSource();
				con = ds.createConnection();
				pstmt = con.prepareStatement(
						"UPDATE Recipients SET Name = ?, " + 
				        "Year = ?,  City = ?, " + "Category = ? WHERE AwardID = ?" );
				pstmt.setString(1, recipients.getName());
				pstmt.setString(2, recipients.getYear());
                                pstmt.setString(3, recipients.getCity());
				pstmt.setString(4, recipients.getCategory());
				pstmt.setInt(5, recipients.getAwardID().intValue());
				pstmt.executeUpdate();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				try{ if(pstmt != null){ pstmt.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
				try{ if(con != null){ con.close(); }}
				catch(SQLException ex){System.out.println(ex.getMessage());}
			}
	}
            /**
             * this method is used to delete a recipient
             * 
             */
	@Override
	public void deleteRecipients(RecipientsDTO recipients) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			DataSource ds = new DataSource();
			con = ds.createConnection();
			pstmt = con.prepareStatement(
					"DELETE FROM Recipients WHERE AwardID = ?");	
			pstmt.setInt(1, recipients.getAwardID().intValue());
			pstmt.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{ if(pstmt != null){ pstmt.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
			try{ if(con != null){ con.close(); }}
			catch(SQLException ex){System.out.println(ex.getMessage());}
		}
	}
    
}
