package Grafos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BFS_Main2 
{

    public static void main(String[] args) 
    {
   int current=0;
      int numV=0;
      Graph theMaze=null;
      try
      {
          Scanner scan= new Scanner(new File("src/Grafos/in.txt"));
          theMaze=AbstractGraph.createGraph(scan, false, "List");
          numV=theMaze.getNumV();
      }
       catch(IOException ex)
       {
           System.err.println(" IO Error while reading graph");
           System.err.println(ex.toString());
           System.exit(1);
      }
    BreadthFirstSearch.breadthFirstSearch(theMaze, 1);
       
     
//        for (int i = 1; i < var.length; i++)
//        {
//            System.out.print("\n" + i);    
//        }
      
//      Stack thePath= new Stack();
//      int v= numV - 1;
//      while  (var[v]!= - 1)
//      {
//          thePath.push(new Integer(v));
//          v=var[v];
//       
//      }
//       
//        System.out.println("la secuencia es");
//       while(!thePath.empty())
//       {
//           System.out.println(thePath.pop());        
//            }
//        System.out.println("padre de los visitados");
       
    }
}
  
