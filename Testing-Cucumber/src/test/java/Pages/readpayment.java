package Pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class readpayment {
 
	static JSONObject obj;
	 
	 String cname;
	 String cnumber;
	 String cvNUM;
	 String exprmonth;
	  String expyear;
	 public readpayment() {
		 paymentdata(); 
	 }
		 
	 public static void paymentdata()  {
		 
		 JSONParser jp=new JSONParser();
		 
				try {
					try {
						obj=
						(JSONObject)jp.parse(new FileReader("json\\paymentdetails.json"));
					} catch (FileNotFoundException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
					
						e.printStackTrace();
					}
				}
		 catch(ParseException e) {
			 System.out.println("Exception occured");
			 
		 }}
		  
	 public String getcardname() {
		 
		cname= (String)obj.get("Cardname");
		 return cname;
	 }
	 
	 public String getcardnumebr() {
		 
			cnumber= (String)obj.get("cardNumner");
			 return cnumber;
		 }
	 
	 public String getcvcnum() {
		 
			cvNUM= (String)obj.get("cvCnumber");
			 return cnumber;
		 }
	 
	 public String getexpmonth(){
		 
			exprmonth= (String)obj.get("Expirationmonth");
			 return exprmonth;
		 }
	 public String getexpyear(){
		 
			expyear= (String)obj.get("ExpirationYear");
			 return expyear;
		 }
}
