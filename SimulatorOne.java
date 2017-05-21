/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs2001f_assignment4;

import static cs2001f_assignment4.Graph.processRequest;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author moegamat
 */
public class SimulatorOne {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        Graph g = new Graph();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of nodes:");
        int nodes = parseInt(in.nextLine());
        
        for (int i = 0; i < nodes; i++){
            
            System.out.println("Enter the details of edges from node"+(i+1));
            String nodeDetails = in.nextLine();
            String[] info = nodeDetails.split("\\s+");
            
            int counter = 1;
            
           for (int j = 0; j < (info.length-1)/2; j++){
                
                g.addEdge(info[0], info[counter],Double.parseDouble(info[counter+1]));
                
                counter += 2;
            }
        }
        
        System.out.println("Enter number of hospitals:");
        int hospitals = parseInt(in.nextLine());
        
        System.out.println("Enter hospital details:");
        String hospitalsDetails = in.nextLine();
        String[] hosInfo = hospitalsDetails.split("\\ ");
        
        System.out.println("Enter number of victims:");
        int victims = parseInt(in.nextLine());
        
        System.out.println("Enter victim details:");
        String victimsDetails = in.nextLine();
        String[] vicInfo = victimsDetails.split(" ");
        
        double[] totalCosts = new double[hospitals];
        
        
        for (int k = 0; k < victims; k++){
            
            // get all the shortest paths from each hospital
            for (int l = 0; l < hospitals; l++){
               
                g.dijkstra( hosInfo[l] );
                totalCosts[l] = g.getPathWeight(vicInfo[k]);
                //g.printPath(vicInfo[k]);
                
                //g.dijkstra( vicInfo[k]);
              //  g.printPath(hospitalInfo[])
            }
           /* for (int i = 0; i < totalCosts.length; i++){
                
                for (int j = 0; j < totalCosts.length; j++){
                    {
                    if totalCosts[]
                }
            }*/
            
        }
        //find out which hospital(s) were the cheapest
        int min = 0;
        ArrayList equals = new ArrayList();
        for (int i = 0; i<totalCosts.length; i++){
            if (i!=0){
                if (totalCosts[i]<totalCosts[min]){
                    min = i;
                    equals.clear();
                }
                else if (totalCosts[i]==totalCosts[min]){
                    equals.add(i);
                }
        }
        //print the path/ store the path
        //repeat the process from patients to hospital this time
        //print all
        
        /*Graph g = new Graph( ); 	
            // read files
        	FileReader fin = new FileReader("/home/moegamat/Documents/Assignment4_assisting/Graph1.txt");
            Scanner graphFile = new Scanner( fin );

            // Read the edges and insert
            String line;
            int marker = 0;
            int nodeNumber;
            String nodeName;
            int amountEdges;
            
            while( graphFile.hasNextLine( ) ){
                
                if (marker == 0){
                    line = graphFile.nextLine( );
                    nodeNumber = parseInt(line);  
                    
                    for (int i = 0;i < nodeNumber;i++){
                        nodeName = graphFile.nextLine();
                        String[] edgeInfo = line.split("\\ ");
                        amountEdges = edgeInfo.length/3;
                        int newcounter = 0;
                        
                        // add edges
                        for (int j = 0; j<amountEdges; j++){
                            
                            g.addEdge(edgeInfo[newcounter],edgeInfo[newcounter+1],Double.parseDouble(edgeInfo[newcounter+2]));
                            newcounter += 3;
                        }
                    }
                }*/
    }
        }}

