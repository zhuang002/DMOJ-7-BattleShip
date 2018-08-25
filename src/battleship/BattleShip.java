/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class BattleShip {

    static Scanner sc=new Scanner(System.in);
    static int n;
    static int length;
    static char[][] board;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i=0;i<1;i++) {
            doTestCase();
        }
        
    }

    private static boolean testHorizontal(int i, int j, int l, char[][] b) {
        if (j+l>b.length) return false;
        int x,y,z;
        
        y=j-1;
        z=l+2;
        if (y<0) {
            y=0;
            z--;
        }
        if (y+z>b.length-1) {
            z--;
        }
        x=i-1;
        if (x>=0)  {
            for (int k=0;k<z;k++) {
                if (b[x][y+k]=='h') return false;
            }
        }
        x++;
        if (x>=0)  {
            for (int k=0;k<z;k++) {
                char c=b[x][y+k];
                if (k>0 && k<z-1 ) 
                {
                    if (c=='m')
                        return false;
                }
                else if (c=='h') 
                    return false;
            }
        }
        x++;
        if (x<b.length)  {
            for (int k=0;k<z;k++) {
                if (b[x][y+k]=='h') return false;
            }
        }
        
        return true;
    }

    private static boolean testVertical(int i, int j, int l, char[][] b) {
        if (i+l>b.length) return false;
        int x,y,z;
        
        x=i-1;
        z=l+2;
        if (x<0) {
            x=0;
            z--;
        }
        if (x+z>b.length-1) {
            z--;
        }
        
        y=j-1;
        if (y>=0)  {
            for (int k=0;k<z;k++) {
                if (b[x+k][y]=='h') return false;
            }
        }
        y++;
        if (y>=0)  {
            for (int k=0;k<z;k++) {
                char c=b[x+k][y];
                if (k>0 && k<z-1) {
                    if (c=='m')
                        return false;
                }
                else if (c=='h') 
                    return false;
            }
        }
        y++;
        if (y<b.length)  {
            for (int k=0;k<z;k++) {
                if (b[x+k][y]=='h') return false;
            }
        }
        return true;
    }

    private static void doTestCase() {
        n=sc.nextInt();
        length=sc.nextInt();
        sc.nextLine();
        board=new char[n][n];
        for (int i=0;i<n;i++) {
            String s=sc.nextLine();
            for (int j=0;j<n;j++) {
                board[i][j]=s.charAt(j);
            }
        }
        int count=0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (testHorizontal(i,j,length,board)) count++;
                if (testVertical(i,j,length,board)) count++;
            }
        }
        System.out.println(count);
    }
}
