package phase1;

import java.awt.Desktop;
import java.io.*;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class phase1 {

	 public void findFile(String name,File file1)throws IOException
	    {      
	        File[] list = file1.listFiles();       
	        if(list!=null)  
	     {                          
	        for(File file2 : list)
	        {            
	            if (file2.isDirectory())
	            {
	                findFile(name,file2);             
	            }
	            else if (name.equalsIgnoreCase(file2.getName()))
	            {                                                              
	                System.out.println("Found");                
	                System.out.println("File found at : "+file2.getParentFile());
	                                               
	            }  
	            else
	            {
	               
	                System.out.println("File not found at : "+file2.getParentFile());


	            }
	            
}
	        
	        }   
	       
	      
	    
    
	
}
	    
	
	
	
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int option;
		
		System.out.println("***************************************");
		System.out.println("Welcome to lockedme.com");
		System.out.println("Application Developer : Manoj Hegde");
		System.out.println("File Menu Related Application");
		System.out.println("***************************************");
		
		do
		{ 
		
			System.out.println("*****Main Menu*****");

			System.out.println("Choose your option");
			System.out.println("1 - List Files in ascending order");
			System.out.println("2 - Display the user interface");
			System.out.println("3 - Exit");
			option=sc.nextInt();
			
				
			switch(option)
			{
			case 1:
				//Code to list the files in ascending order
				
				try {
					File dirpath=new File(System.getProperty("user.dir"));
					File[] contents=dirpath.listFiles();
									if(contents.length==0) {
										System.out.println("No files Exists");
									}
									else {
										System.out.println("The files names are given below in assending order: ---");
										for(File each: contents) {
											System.out.println(each.getName());
										}
									}
					
				}
				catch(NullPointerException e) {
					System.out.println("Please Enter a valid directory" + "Format should be c:\\");
				}catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}

			
				
				break;
			case 2: //Menu for performing file tasks
				
				System.out.println("*****Perform File Operations*****");
				System.out.println("11 - Add File");
				System.out.println("12 - Delete File");
				System.out.println("13 - Search File");
				System.out.println("14 - Back to Main Menu");
				int suboption=sc.nextInt();
				switch(suboption)
				{
				case 11:
					Scanner sc1=new Scanner(System.in);
					System.out.println("Enter a file name to be created");
					String fname=sc1.nextLine();
				    File addfile = new File(fname);
				    try {

				        // create a new file with name specified
				        // by the file object
				        boolean value = addfile.createNewFile();
				        if (value) {
				          System.out.println("New  File is created.");
				        }
				        else {
				          System.out.println("The file already exists.");
				        }
				      }
				      catch(Exception e) {
				        e.getStackTrace();
				      }
				    System.out.println();
break ;
				// you need to write a logic to add a file
				case 12:
					// you need to write a logic to delete a file
					
					Scanner sc2=new Scanner(System.in);
					System.out.println("Enter a file name to be deleted");
					String fname1=sc2.nextLine();
				    File delfile = new File(fname1);
					try {
				        boolean value = delfile.delete();
				        if (value) {
					          System.out.println(fname1 + " File is deleted");
					        }
					        else {
					          System.out.println(fname1 + " File does not exist");
					        }
			           
			        }
			        catch (Exception e) {
			        	e.getStackTrace();
			        }
			       
			 
			    break;
				case 13: 
					phase1 fs = new phase1();
			        Scanner scan = new Scanner(System.in);
			        System.out.println("Enter the file to be searched.. " );
			        String name = scan.next();
			       
					File directory=new File(System.getProperty("user.dir"));

			        fs.findFile(name,directory);
			        
					
					// you need to write a logic to search a file
				case 14:
					// you need to write a logic to return to main menu
					break;
					default:
						System.out.println("Please Enter a Valid option");
				}
				break;
			case 3: 
				System.out.println("\n Are you sure you want to exit ? ");
				System.out.println("  (Y) ==> Yes    (N) ==> No        ");
				Scanner scan=new Scanner(System.in);
				char decision =  scan.nextLine().toUpperCase().charAt(0);
				if(decision == 'Y') {
					System.out.println("\n");
					System.out.println("Exiting the programme");

					System.exit(1);
				}else if(decision == 'N') {
					System.out.println("\n");
					return;
				}else {
					System.out.println("\nInvalid Input \nValid Inputs :(Y/N)\n");
					return;
				}
				//System.exit();
				return;
				default:
					System.out.println("Please Enter a Valid option");

			
			}
			
		}
		
		while(true);
	}
	

}
