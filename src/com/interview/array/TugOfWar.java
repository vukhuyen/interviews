package com.interview.array;

/*
 * http://www.geeksforgeeks.org/tug-of-war/
 */
public class TugOfWar {

    private int minFoundSoFar = 1000000;
    public int findMind(int arr[]){
        int total = 0;
        for(int i=0; i < arr.length; i++){
            total += arr[i];
        }
        combinationUtil(arr,arr.length/2,0,0,total,0);
        return minFoundSoFar;
    }

    private void combinationUtil(int arr[],int k, int start,int sum, int total,int pos){
        if(pos == k){
            if(Math.abs(sum - (total-sum)) < minFoundSoFar){
                minFoundSoFar = Math.abs(sum - (total-sum));
            }
            return;
        }
        for(int i=start; i < arr.length; i++){
            sum += arr[i];
            combinationUtil(arr,k,i+1,sum,total,pos+1);
            sum -= arr[i];
        }
    }

    public static void main(String args[]){
        TugOfWar tow = new TugOfWar();
        int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        int min = tow.findMind(arr);
        System.out.print(min);
    }
}
