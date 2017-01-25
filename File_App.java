import java.io.*;
import java.util.*;

public class File_App
{
	public static void main(String args[]) throws Exception
	{	
            int choice=0;
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            while(true)
            {		
                System.out.println("--------------------------");
		System.out.println("\n1.Add a Record\n2.Update Record\n3.Delete Record\n4.Search\n5.Show All Records\n6.Exit");
		System.out.print("\nEnter Choice : ");
		choice=Integer.parseInt(br.readLine());
			
		switch(choice)
		{
			case 1:	
                                try
                                {
                                Add.adder();
                                }
                                catch(Exception e)
                                {
                                    System.out.print("\nBro check your input caused Exception");
                                }
				break;
			case 2:
                                try
                                {
                                Update.updater();
                                }
                                catch(Exception e)
                                {
                                    System.out.print("\nBro check your input caused Exception");
                                }
				break;
			case 4:
                                try
                                {
                                Search.searcher();
                                }
                                catch(Exception e)
                                {
                                    System.out.print("\nBro check your input caused Exception");
                                }
				break;
			case 3:
                                try
                                {
                                Delete.deleter();
                                }
                                catch(Exception e)
                                {
                                    System.out.print("\nBro check your input caused Exception");
                                }
				break;
                        case 5:
                                try
                                {
                                    System.out.print("--------------------------");
                                Show.shower();
                                }
                                catch(Exception e)
                                {
                                    System.out.print("\nBro check your input caused Exception");
                                }
				break;
			case 6:
				System.exit(0);
				break;
			default:
				System.out.println("--------------------------");
				System.out.println("INVALID CHOICE!!!");
				System.out.println("--------------------------");
		}
            }
		
    }
}