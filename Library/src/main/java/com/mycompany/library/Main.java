/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author mariam_youssef
 */
public class Main implements Serializable {
     public static void main(String[] args) throws IOException, ClassNotFoundException {
        Library library = new Library("My Library");
 
        Scanner s = new Scanner(System.in);
        
        //library = loadLibrary();
      
        library.addBook(new Book("123", "Java Programming", "Author A", 5));
        library.addBook(new Book("456", "Python Basics", "Author B", 3));

        library.addMember(new Student("M001", "John Doe", "123456789"));
        library.addMember(new FacultyMember("M002", "Jane Smith", "987654321"));

         OUTER://label for the loop
         while (true) {
             System.out.println("\nPlease enter:\n1 to borrow  \n2 to return \n3 to display all books \n4 to display all members \n5 to check member activity \n0 to exit");
             int ch = s.nextInt();
             switch (ch) {
                 case 1:
                     {
                         System.out.println("Please enter book ISBN & member ID: ");
                         String isbn=s.next();
                         String id=s.next();
                         library.Borrow(isbn, id);
                         break;
                     }
                 case 2:
                     {
                         System.out.println("Please enter book ISBN & member ID: ");
                         String isbn=s.next();
                         String id=s.next();
                         library.Return(isbn,id);
                         break;
                     }
                 case 3:
                     library.displayBooks();
                     break;
                 case 4:
                     library.displayMembers();
                     break;
                 case 5:
                     {
                         System.out.println("Please enter member ID: ");
                         String id=s.next();
                         if(library.searchbyID(id).isActive(id)){
                          System.out.println("Member: "+id+" is active.");
                         }
                         else{
                          System.out.println("Member: "+id+" is inactive.");
                         }
                         break;
                     }
                 case 0:
                     break OUTER;
                 default:
                     break;
             }
         }
        saveLibrary(library);
        Library deserializedLibrary=loadLibrary();
        if (deserializedLibrary != null) {
            System.out.println("Deserialized Library object:");
            deserializedLibrary.displayBooks();
        }
    }

    private static void saveLibrary(Library library){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.data"))) {
            oos.writeObject(library);
           System.out.println("Library data saved successfully.");
    } catch (IOException e) {
        System.out.println("Error saving library data: ");
        e.printStackTrace();
    }
    }

    private static Library loadLibrary() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save.data"))) {
            return (Library) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
             e.printStackTrace();
            return null;
        }
    }
}

