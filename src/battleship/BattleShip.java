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
        if (i>0) {
            if (j>0 && b[i-1][j-1]=='h') return false;
            for (int k=0;k<l;k++) {
                if (b[i-1][j+k]=='h') return false;
            }
            if (j+l<b.length && b[i-1][j+l]=='h') return false; 
        }
        if (j>0 && b[i][j-1]=='h') return false;
        if (j+l<b.length && b[i][j+l]=='h') return false;
        if (i<b.length-1) {
            if (j>0 && b[i+1][j-1]=='h') return false;
            for (int k=0;k<l;k++) {
                if (b[i+1][j+k]=='h') return false;
            }
            if (j+l<b.length && b[i+1][j+l]=='h') return false; 
        }
        for (int k=0;k<l;k++) {
            if (b[i][j+k]=='m') return false;
        }
        
        return true;
    }

    private static boolean testVertical(int i, int j, int l, char[][] b) {
        if (i+l>b.length) return false;
        if (j>0) {
            if (i>0 && b[i-1][j-1]=='h') return false;
            for (int k=0;k<l;k++) {
                if (b[i+k][j-1]=='h') return false;
            }
            if (i+l<b.length && b[i+l][j-1]=='h') return false; 
        }
        if (i>0 && b[i-1][j]=='h') return false;
        if (i+l<b.length && b[i+l][j]=='h') return false;
        if (j<b.length-1) {
            if (i>0 && b[i-1][j+1]=='h') return false;
            for (int k=0;k<l;k++) {
                if (b[i+k][j+1]=='h') return false;
            }
            if (i+l<b.length && b[i+l][j+1]=='h') return false; 
        }
        for (int k=0;k<l;k++) {
            if (b[i+k][j]=='m') return false;
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
