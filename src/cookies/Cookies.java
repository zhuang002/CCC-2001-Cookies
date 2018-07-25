/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cookies;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class Cookies {

    static double[][] coords;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        coords=new double[n][2];
        double minX=1000;
        double minY=1000;
        double maxX=0;
        double maxY=0;
        for (int i=0;i<n;i++) {
            double d=sc.nextDouble();
            coords[i][0]=d;
            if (minX>d) minX=d;
            if (maxX<d) maxX=d;
            d=sc.nextDouble();
            coords[i][1]=d;
            if (minY>d) minY=d;
            if (maxY<d) maxY=d;
        }
        
        double minR=2000;
        int steps=4;
        double stepX=2*(maxX-minX)/steps;
        double stepY=2*(maxY-minY)/steps;
        
        while (stepX>=0.0025 || stepY>=0.0025) {
            
            double oX=(minX+maxX)/2;
            double oY=(minY+maxY)/2;
            for (int i=-steps/2;i<=steps/2;i++) {
                for (int j=-steps/2;j<=steps/2;j++) {
                    double x=oX+i*stepX;
                    double y=oY+j*stepY;
                    double r=getMinR(x,y);
                    if (minR>r) {
                        minR=r;
                        oX=x;
                        oY=y;
                    }
                }
            }
            stepX*=0.9;
            stepY*=0.9;
        }
        
        
        System.out.printf("%.2f",2*minR);
        
    }

    private static double getMinR(double x, double y) {
        double maxR=0;
        for (int i=0;i<coords.length;i++) {
            double cx=coords[i][0];
            double cy=coords[i][1];
            double d=sqrt((cx-x)*(cx-x)+(cy-y)*(cy-y));
            if (maxR<d) maxR=d;
        }
        return maxR;
    }
    
}
