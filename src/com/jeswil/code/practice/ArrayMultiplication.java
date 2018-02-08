/* (JAVA 8)
* Multiply two Matrices of the form
* (mxn) * (n*p)
* Resultant matrix is of order (m*p)
* */

package com.jeswil.code.practice;

import java.util.Scanner;

public class ArrayMultiplication {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String args[])
    {
        System.out.println("Enter the dimensions of the matrix A : (separated by a space)");
        int m = scan.nextInt();
        int n = scan.nextInt();
        System.out.println("Enter the dimensions of the matrix B: (separated by a space)");
        int o = scan.nextInt();
        int p = scan.nextInt();
        if(n != o)
        {
            System.out.println("Cannot multiply matrices.\nMatrices need to of the form (mxn) * (nxp)");
            return;
        }

        int[][] a = new int[m][n];
        int[][] b = new int[o][p];

        System.out.println("Enter the values of matrix A : (row wise) ");
        formMatrix(a,m,n);

        System.out.println("Enter the values of matrix B : (row wise) ");
        formMatrix(b,o,p);

        int[][] c = new int[m][p];

        //calculate multiplication array
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<p; j++)
            {
                c[i][j] = element(a[i],getColumnVector(b,j));
            }
        }

        System.out.println("Matrix A :");
        printMatrix(a,m,n);

        System.out.println("Matrix B :");
        printMatrix(b,m,p);

        System.out.println("Matrix C :");
        printMatrix(c,m,p);
    }

    //get element of multiplication result matrix
    public static int element(int[] a, int[] b)
    {
        int sum = 0;
        for(int k=0;k<a.length;k++)
        {
            sum += a[k]*b[k];
        }
        return sum;
    }

    //get column vector from matrix
    public static int[] getColumnVector(int[][] a, int n) {
        int[] vector = new int[a.length];
        for(int i=0; i<a.length; i++)
        {
            vector[i] = a[i][n];
        }
        return vector;
    }

    //form matrix from user input
    public static void formMatrix(int[][] a, int m,int n)
    {
        for(int i = 0; i<m; i++)
        {
            for(int j=0; j<n;j++)
            {
                a[i][j] = scan.nextInt();
            }
        }
    }

    /*
    public static void printVector(int[] vector){

        for(int i = 0; i< vector.length ; i++){
            System.out.format("%d ",vector[i]);
        }
    }
    */

    //display matrix on console
    public static void printMatrix(int[][] matrix,int m,int n){

        for(int i = 0; i<m; i++)
        {
            for(int j=0; j<n;j++)
            {
                System.out.format("%d ",matrix[i][j]);
            }
            System.out.println();
        }
    }
}

