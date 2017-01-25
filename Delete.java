import java.io.*;

public class Delete 
{
    public static void deleter() throws Exception
    {
        int rollno=0,at_s=0,at_e=0,i=0,choice=0,dash1=0,dash2=0;
            String name="",addr="",temp="",contents="";
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            StringBuffer now;
            //reading file
            FileReader fr=new FileReader("file_app_data.txt");	
	
            while((i=fr.read()) != -1)	
            {
                contents+=String.valueOf((char)i);	
            }
            fr.close();	
            contents+="\n&";
       //     System.out.println("----\n"+contents+"\n-------");
            
            System.out.print("\nEnter Roll No :");
            rollno=Integer.parseInt(br.readLine());
            
//            n_r=contents.charAt(contents.indexOf(String.valueOf(rollno)));
            
            
            if(contents.indexOf(String.valueOf(rollno)) == -1)
            {
                System.out.println("No DATA found !!!\n");
            }
            else
            {
                at_s=contents.indexOf(String.valueOf(rollno))-2;
                at_e=contents.indexOf('&',at_s+1);
                if(contents.charAt(at_s) == '&' && contents.charAt(at_e) == '&')
                {
                    now=new StringBuffer(contents);
                    now.delete(at_s,at_e);
                    contents=now.toString();
                    
         //           System.out.println("\n"+contents);
                    now=new StringBuffer(contents);
                    now.deleteCharAt(contents.lastIndexOf('&'));
                    contents=now.toString();
           //         System.out.println("\n"+contents);
                    
                    FileWriter fw=new FileWriter("file_app_data.txt");
                    fw.write(contents);
                    fw.close();
                }
            }
    }    
}
