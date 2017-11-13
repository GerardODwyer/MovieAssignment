package controllers;

import java.io.File;
import java.util.Collection;

import models.User;
import utils.Serializer;
import utils.XMLSerializer;

public class Main
{
	

    public static void main(String[] args) throws Exception {
    
    
    File  datastore = new File("datastore4.xml");
    Serializer serializer = new XMLSerializer(datastore);

    MovieAPI movieAPI = new MovieAPI(serializer);
    if (datastore.isFile())
    {
      movieAPI.load();
    }
	
    movieAPI.initalLoad();
    movieAPI. createUser("Ger", "O Dywer", "24", "Student", "M");
    

    Collection<User> users = movieAPI.getUsers();
    System.out.println(users);
    
    User homer = movieAPI.getUserByFirstName("Ger");
    System.out.println(homer);
    
    movieAPI.store();
    
    
    }
}











//do
//{
 //   System.out.println("-----------------------------");
   // System.out.println("which option would you like to perform");
   // System.out.println("1.add user");
   // System.out.println("2.remove user");
   // System.out.println("3.add movie");
   // System.out.println("4.remove movie");
   // System.out.println("5.exit");
   // System.out.println("-----------------------------");
   // System.out.println("Please select an option: ");     
   // choice = EasyScanner.nextInt();

   // switch (choice)
   // {

      //  case 1:
       // do
      //  {
          

        //    switch (choice2)
        //    {
//
        //        case 1:
              //  break;
              //  case 2:
              //  break;

              //  case 3:
              
             //   break;
                
            //    default:
              //  System.out.println("Invalid choice. Please choose again: ");
         //   }
      //  }while (choice2 != 5);

   
//}














