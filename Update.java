import java.io.*;
public class Update 
{
    public static void updater() throws Exception
    {
            int rollno=0,at_s=0,at_e=0,i=0,choice=0,dash1=0,dash2=0;
            String name="",addr="",temp="",contents="",new_n="",new_addr="";
            StringBuffer now;
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
            //reading file
            FileReader fr=new FileReader("file_app_data.txt");	
	
            while((i=fr.read()) != -1)	
            {
                contents+=String.valueOf((char)i);	
            }
            fr.close();	
            contents+="\n&";
      //      System.out.println("----\n"+contents+"\n-------");
            
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
                    dash1=contents.indexOf('|',at_s);
                    dash2=contents.indexOf('|',dash1+1);
                    name=contents.substring(dash1+1,dash2);
                    addr=contents.substring(dash2+1,at_e-1);
                    
                    System.out.println("name:"+name+"\nAdd:"+addr);
                    
//                    System.out.print("\n1.Update Name\n2.Update Address\n3.Update BOTH");
                    
                    System.out.print("\n1.Update Name\n2.Update Address");
                    System.out.print("\nEnter Choice : ");
                    choice=Integer.parseInt(br.readLine());
                    
                    switch(choice)
                    {
                        case 1:
                            System.out.print("\nNew Name : ");
                            new_n=br.readLine();
                            new_n+="|";
                            
                            now=new StringBuffer(contents);
                            
                            now.delete(dash1,dash2);
                            now.insert(dash1+1, new_n);
                            
                            contents=now.toString();
                            break;
                        case 2:
                            System.out.print("\nNew Address : ");
                            new_addr="|"+br.readLine()+"\n";
                            now=new StringBuffer(contents);
                            now.delete(dash2,at_e);
                            now.insert(dash2, new_addr);
                            
                            contents=now.toString();
                            
                            break;
/*                        case 3:
                            System.out.print("\nNew Name : ");
                            new_n=br.readLine();
                            new_n+="|";
                            System.out.print("\nNew Address : ");
                            new_addr="|"+br.readLine()+"\n";
                            
                            now=new StringBuffer(contents);
                            
                            now.delete(dash1,dash2);
                            now.insert(dash1+1, new_n);
                            now.delete(dash2,at_e);
                            now.insert(dash2, new_addr);
                            
                            contents=now.toString();
*/                           
                        default:
                            System.out.print("\nINVALID CHOICE!");
                    }
        //            System.out.println("\n"+contents);
                    now=new StringBuffer(contents);
                    now.deleteCharAt(contents.lastIndexOf('&'));
                    contents=now.toString();
       //             System.out.println("\n"+contents);
                    
                    FileWriter fw=new FileWriter("file_app_data.txt");
                    fw.write(contents);
                    fw.close();
                }
            }
            
    }
}
