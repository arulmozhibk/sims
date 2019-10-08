package com.sims.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.sims.bean.PaymentBean;


public class PaymentDao {
	
	
public int createPayment(PaymentBean pb) throws SQLException
	{	
		Connection conn=ConnectionDao.getConnect();
	PreparedStatement ps=conn.prepareStatement("insert into payment(user_id,payment_date,paid_amount) values(?,?,?);");
	ps.setInt(1,pb.getUser_id());
 
	/*java.util.Date date = Calendar.getInstance().getTime();
	java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 	//ps.setDate(2, pb.getPayment_date());
	*/	
	
	/* DateFormat dateFormatMDY = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
     Date now = new Date();
     String curDate =dateFormatMDY.format(now);
*/     
	 /*ps.setTimestamp(2, java.sql.Timestamp.valueOf(curDate)); 
	  * */
    // ps.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));

ps.setTimestamp(2,(Timestamp) pb.getPayment_date());
	ps.setDouble(3,pb.getPaid_amount());
	int CountOfInsertedRows=ps.executeUpdate();
			return CountOfInsertedRows;
	
	}
	
public int editPayment(PaymentBean pb) throws SQLException
{ 
	Connection conn=ConnectionDao.getConnect();
	PreparedStatement ps=conn.prepareStatement("update payment set user_id=?,paid_amount=?,payment_date=? where payment_id=?;");
	
	ps.setInt(1,pb.getUser_id());
	ps.setDouble(2,pb.getPaid_amount());
	ps.setDate(3,(java.sql.Date) pb.getPayment_date());
	ps.setInt(4,pb.getPayment_id());
	
	int CountOfInsertedRows=ps.executeUpdate();
			return CountOfInsertedRows;
	}

 public int deletePayment(int payment_id) throws SQLException
 {
	 Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("delete from payment where payment_id=?;");
		ps.setInt(1,payment_id);
		int CountOfDeletedRows=ps.executeUpdate();
			return CountOfDeletedRows;
 }
 
 public ResultSet getPaymentOfUser(int user_id) throws SQLException{
	 Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from payment where user_id=?;");
		ps.setInt(1,user_id);
		ResultSet rs =ps.executeQuery();
		/*while(rs.next())
		{
		System.out.println("Payment_id: "+rs.getInt(1)+"Payment Date:"+rs.getDate(2)+"paid amount: "+rs.getDouble(3)+"User ID"+rs.getInt(4));
		}*/
		return rs;
 } 
 
 public ResultSet getPayment(int payment_id) throws SQLException{
	 Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select * from payment where payment_id=?;");
		ps.setInt(1,payment_id);
		ResultSet rs =ps.executeQuery();
		/*while(rs.next())
		{
		System.out.println("Payment_id: "+rs.getInt(1)+"Payment Date:"+rs.getDate(2)+"paid amount: "+rs.getDouble(3)+"User ID"+rs.getInt(4));
		}*/
		return rs;
 }
 public ResultSet getPaymentOfCourse(int course_id,String fromDate,String toDate) throws SQLException{
	 Connection conn=ConnectionDao.getConnect();
		PreparedStatement ps=conn.prepareStatement("select u.username,c.course_name,p.paid_amount,p.payment_date from usermaster u inner join course c on u.course_id=c.course_id inner join payment p on p.user_id=u.user_id where payment_date between str_to_date(?,'%m/%d/%Y') and str_to_date(?,'%m/%d/%Y') and c.course_id=?;");
		ps.setString(1,fromDate);
		ps.setString(2,toDate);
		ps.setInt(3,course_id);
		ResultSet rs =ps.executeQuery();
		/*while(rs.next())
		{
		System.out.println("User name: "+rs.getString(1)+"Course name: "+rs.getString(2)+"paid amount: "+rs.getDouble(3)+"Payment Date:"+rs.getDate(4));
		}*/
		return rs;
 } 
  public List<Object> getPaymentList() throws SQLException{
	 	Connection conn=ConnectionDao.getConnect();
	 	List<Object> al=new ArrayList<Object>();
		PreparedStatement ps=conn.prepareStatement("select * from payment;");
		ResultSet rs =ps.executeQuery();
		while(rs.next())
		{
			al.add(rs.getInt(1));
			al.add(rs.getDate(2));
			al.add(rs.getDouble(3));
			al.add(rs.getInt(4));
		//System.out.println("Payment_id: "+rs.getInt(1)+"Payment Date:"+rs.getDate(2)+"paid amount: "+rs.getDouble(3)+"User ID"+rs.getInt(4));
		}
		
		return al;
 }
}

/* public static void main(String[] args) throws SQLException, ParseException {
	 PaymentDao pd=new PaymentDao();
	 int course_id=2;
	// SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
	 String strDate="04/01/2015";
	 String strdate1="04/30/2015";

	 Date date1=sdf.parse(strdate1);
	 String toDate=sdf.format(date1);
	 
	 Date date=sdf.parse(strDate);
	String fromDate=sdf.format(date);
	ResultSet rs=pd.getPaymentOfCourse(course_id, strDate, strdate1);
	 while(rs.next())
	 {
		 System.out.println("User name: "+rs.getString(1)+"Course name: "+rs.getString(2)+"paid amount: "+rs.getDouble(3)+"Payment Date:"+rs.getDate(4));	
	}
	 
   }
*/

	/*System.out.println("fromdate"+fromDate);
	 System.out.println("Date is:"+date);
	 System.out.println("Formatter :"+sdf.format(date));
*/
	/* Date fromDate;SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateInString = "07/06/2013";
		 
		try {
	 
			Date date = formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter.format(date));
	 
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
	// System.out.println("fromDate to Dte:"+fromDate);
	 
	 /*java.sql.Date toDate =java.sql.Date.valueOf(date1);
	 System.out.println("fromDate to Dte:"+fromDate);
	 ResultSet rs=pd.getPaymentOfCourse(course_id, fromDate, toDate);
	 while(rs.next())
	 {
		 System.out.println("User name: "+rs.getString(1)+"Course name: "+rs.getString(2)+"paid amount: "+rs.getDouble(3)+"Payment Date:"+rs.getDate(4));	 }
	 
 	}*/	 
	/* PaymentBean pb=new PaymentBean();
	 PaymentDao pd=new PaymentDao();
	 pb.setUser_id(1003);
	 pb.setPaid_amount(50000.0d);
	 pb.setPayment_date(new java.sql.Timestamp(System.currentTimeMillis()));
	 int count=pd.createPayment(pb);
	 System.out.println("count : "+count);
	 System.out.println("Payment Done for User : "+pb.getUser_id()+"Paid Amount is : "+pb.getPaid_amount()+"Date is :"+pb.getPayment_date());*/
	 
	/* DateFormat dateFormatMDY = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
     Date now = new Date();
     String curDate =dateFormatMDY.format(now);
	 setTimestamp(2, java.sql.Timestamp.valueOf(curDate));
*/
		/*java.util.Date date = Calendar.getInstance().getTime();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 	//ps.setDate(2, pb.getPayment_date());
		*/
		
	// pb.setPayment_date(setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis())));
	 
	 
	



	/* PaymentDao pd=new PaymentDao();
	 List<Object> l=pd.getPaymentList();
	 Iterator<Object> i=l.iterator();
		int count=l.size();
		System.out.println(count);
		while(i.hasNext())
		{							
			System.out.print(i.next()+" ");
		}*/
		
	 
/*
 			deletePayment()
 			int del=pd.deletePayment(3);
 			 System.out.println(del);
 			 
 			 getPaymentOfUser()
 			 	 pd.getPaymentOfUser(1001);
 			 	 
 			 getPayment()
 			 	 pd.getPayment(1);
 			 	 
 			 getPaymentList();
 			 	 pd.getPaymentList();



*/
 			 
 

	
