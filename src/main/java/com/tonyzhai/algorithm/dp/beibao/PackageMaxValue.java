package com.tonyzhai.algorithm.dp.beibao;

import java.lang.*;
import java.util.Arrays;
import java.util.List;

/**
 * Add some description
 *
 * @author Tony Zhai
 */
public class PackageMaxValue {
    public static int getMaxValue(Package p, List<Goods> goodsList){
        int[][] matrix = new int[goodsList.size() + 1][p.getCapacity() + 1];
        for(int i = 0 ; i < goodsList.size(); i++){
            Goods goods = goodsList.get(i);
            int weight = goods.getWeight();
            int value = goods.getValue();
            for(int j = 1; j < p.getCapacity() + 1; j++){
                matrix[i + 1][j] = matrix[i][j];
                if(weight <= j){
                    if(value + matrix[i][j - weight] > matrix[i][j]){
                        matrix[i + 1][j] = value + matrix[i][j - weight];
                        print(matrix);
                    }
                }
            }

        }
        return matrix[goodsList.size()][p.getCapacity()];
    }

    public static int getMaxValue1(Package pac, List<Goods> goodsList){
        int[][] m = new int[goodsList.size() + 1][pac.getCapacity() + 1];
        int[] w = new int[goodsList.size()];
        int[] v = new int[goodsList.size()];
        for(int i = 0; i < goodsList.size(); i++){
            w[i] = goodsList.get(i).getWeight();
            v[i] = goodsList.get(i).getValue();
        }

        for(int i = 1; i <= goodsList.size(); i++){
            System.out.println("current i = " + i);
            for(int j = 1; j <= pac.getCapacity(); j++){
                System.out.println("current j = " + j);
                System.out.println("m[" + i + "][" + j + "] = " + m[i][j]);
                System.out.println("m[" + (i - 1) + "][" + j + "] = " + m[i - 1][j]);
                m[i][j] = m[i - 1][j];
                System.out.println("w[" + (i - 1) + "] = " + w[i - 1]);
                if(w[i - 1] <= j){
                    if(v[i - 1] + m[i - 1][j - w[i - 1]] > m[i - 1][j]){
                        m[i][j] = v[i - 1] + m[i - 1][j - w[i - 1]];
                        print(m);
                    }
                }
            }
        }
        return m[goodsList.size()][pac.getCapacity()];
    }


    private static void print(int[][] m){
        for(int i = 1; i < m.length; i++){
            int[] line = m[i];
            for(int j = 0; j < line.length; j++){
                System.out.print(line[j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }
    public static void main(String[] args) {
        Goods goods1 = new Goods(3, 4);
        Goods goods2 = new Goods(4, 5);
        Goods goods3 = new Goods(5, 6);

        Package p = new Package(10);

        int maxValue = getMaxValue(p, Arrays.asList(goods1, goods2, goods3));
        System.out.println("max value is " + maxValue);
    }
}
