import java.util.*;
import java.io.*;

public class Add
{
	public static void adder() throws Exception
	{
            int rollno=0,i=0;
            String name="",addr="",temp="",contents="";
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
            //reading file
            FileReader fr=new FileReader("file_app_data.txt");	
	
            while((i=fr.read()) != -1)	
            {
                contents+=String.valueOf((char)i);	
            }
            fr.close();	
            
      //      System.out.println("----\n"+contents+"\n-------");
		
            System.out.println("\nAdding new Record\n---");

            if(contents.lastIndexOf('&') == -1)
            {
                rollno=1;
            }
            else
            {
                temp=String.valueOf(contents.charAt(contents.lastIndexOf('&')+2));
                rollno=Integer.parseInt(temp)+1;
            }
    
      /*      System.out.print("\nEnter Roll no :");
            rollno=Integer.parseInt(br.readLine());    */
            System.out.print("\nEnter Name :");	
            name=br.readLine();
            System.out.print("\nEnter Address :");		
            addr=br.readLine();
            
            contents+="\n&\n";//delimeter
            contents+=rollno+"|"+name+"|"+addr;					
            
            
            FileWriter fw=new FileWriter("file_app_data.txt");
            fw.write(contents);
            fw.close();
	}
}
					
					
					
	