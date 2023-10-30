package cosc201.a1;

import cosc201.unionfind.UF1;
import cosc201.unionfind.UF2;
import cosc201.unionfind.UF3;
import cosc201.unionfind.UF4;
import cosc201.unionfind.UnionFind;
import cosc201.utilities.*;

/**
 * A simple demo to show how the Puddles class works. It just initializes a list
 * of 5 puddles (or n if given a command-line argument), prints their positions
 * (Point2D defaults to two decimal places) and then prints the list of pairs of
 * puddles in sorted order of distance.
 */
public class A1Demo {

  /**
   * Runs (versions of) the demo
   * 
   * @param args optional number of puddles
   */
  
  public static void main(String[] args) {
    
    /* 
    int points = 1000000000;
    for(int i = 0; i<=points;i+=100000){
    Timer t = new Timer();
    t.start();
    Puddles p = new Puddles(points);
    t.stop();
    double timeTaken = t.getTime();
    System.out.println(i + " points: " + timeTaken );
    }
    */


     
    
      double average = 0;
          for (int trial = 0; trial < 100; trial++) {
              Puddles puddles = new Puddles(2500);
              UnionFind uf = new UF4();
              PoolAnalyser pool = new PoolAnalyser(uf, puddles);
              //System.out.println(pool.firstSuperfluousMerge());
              System.out.println(pool.superfluousRatio());
              average+=pool.superfluousRatio();
              //average+=pool.firstSuperfluousMerge();
          }        
          System.out.println("average "+average/100);
         
      }
  
    /** 
   int n = 500;
     //int n = 5;
    if (args.length > 0) {
      n = Integer.parseInt(args[0]);
    }
       //for(n = 500; n<=5000; n+=500){
      for(n=100; n<=10000; n+=100){
    for(int trial = 0; trial < 3; trial++) {
      exp1(n);
    }
  }
  }
  */
/**
  public static void demo1(int n) {
    Puddles p = new Puddles(n);
    for (int i = 0; i < n; i++) {
      System.out.println(i + " " + p.getPoint(i));
    }
    System.out.println();
    for (int[] pair : p.mergeOrder()) {
      System.out.print(pair[0] + " " + pair[1] + " ");
      Point2D p0 = p.getPoint(pair[0]);
      Point2D p1 = p.getPoint(pair[1]);
      System.out.println(String.format("%.4f", p0.distance(p1)));
    }
  }

  public static void demo2(int n) {
    Puddles p = new Puddles(n);
    for (int i = 0; i < n; i++) {
      System.out.println(i + " " + p.getPoint(i));
    }
    System.out.println();
    UnionFind u = new UF3();
    u.make(n);
    int groups = u.groups();
    for (int[] pair : p.mergeOrder()) {
      System.out.print(pair[0] + " " + pair[1] + " ");
      Point2D p0 = p.getPoint(pair[0]);
      Point2D p1 = p.getPoint(pair[1]);
      System.out.print(String.format("%.4f", p0.distance(p1)));
      u.union(pair[0], pair[1]);
      if (u.groups() < groups) {
        System.out.println(" E");
        groups--;
      } else {
        System.out.println(" S");
        
      }
    }
  }
*/


   
  public static void exp1(int n) {
    Timer t = new Timer();
    Puddles p = new Puddles(n);
    //for (int i = 0; i < n; i++) {
    //  System.out.println(i + " " + p.getPoint(i));
    //}
    //System.out.println();
    UnionFind u = new UF4();
    u.make(n);
    int e = 0;
    int s = 0;
    int groups = u.groups();
    long timeUnion = 0;
    //t.start();
    for (int[] pair : p.mergeOrder()) {
      // System.out.print(pair[0] + " " + pair[1] + " ");
       Point2D p0 = p.getPoint(pair[0]);
       Point2D p1 = p.getPoint(pair[1]);
      // System.out.print(String.format("%.4f", p0.distance(p1)));
      t.start();
      u.union(pair[0], pair[1]);
      timeUnion += t.stop();
      if (u.groups() < groups) {
        // System.out.println(" E");
        e++;
        groups--;
      } else {
        // System.out.println(" S");
        s++;
      }
      if(u.groups() == 1) break;
     // timeUnion += t.stop();  

    } 

    //System.out.println(n + " " + e + " " + s);
    System.out.println(n+" "+timeUnion);
  }

} 

