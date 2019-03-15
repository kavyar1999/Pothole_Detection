import java.io.*;

class Sensor
{
 public  int readinput() throws IOException
 { 
  File file = new File("C:\\Users\\Jishnu\\Desktop\\gps.txt"); 
  BufferedReader rdr = new BufferedReader(new FileReader(file)); 
  String st; 	
  PrintStream o = new PrintStream(new File("C:\\Users\\Jishnu\\Desktop\\pwd.txt"));
  System.setOut(o); 
  while ((st = rdr.readLine()) != null)    				 //read from input file
  {  
	String lat=st.substring(0,9);                       // value of latitude
	String lon=st.substring(10,19);  					//value of longitude
	String val=st.substring(20,21); 					 //value of pothole
	test obj2 = new test();
	obj2.upload_to_pwd(val,lat,lon);
  }
  return 1;
 } 
}

class To_pwd extends Sensor  //To send the required data to PWD Department
{
   void  upload_to_pwd(String aa,String lata,String lona) throws FileNotFoundException 
   { 		
	 int a=Integer.parseInt(aa);
	 if(a>8)
	 { 
	 	System.out.println("Need Immediate Maintainance at"+": "+aa+" "+lata+" "+lona);
	 }
	 else if(a>5)
	 {	
		System.out.println("Bad Condition at : "+aa+" "+lata+" "+lona);
			
	 }
		
   }	
}

public class Road        //Main Class
{
  public static void main(String[] args) throws Exception
  {
    Sensor obj =new Sensor();
    int s=obj.readinput();
  }
};
