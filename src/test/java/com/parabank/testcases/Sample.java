package com.parabank.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.parabank.utilities.RetryTest;

public class Sample {
	
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] arr={5,6,7,8,9,1,2,3};
		System.out.println(findIndex(arr,8));
	}
	
	
	
	static int findIndex(int[] arr,int target){
		int pickIndex=findPick(arr);
		
		int start=0;
		int end=arr.length-1;
		
		while(end<start){
			int mid=start+(end-start)/2;
			
			if(target<arr[pickIndex] && target>arr[start]){
				binSearch(arr,start,pickIndex,target);
			}else if(target<arr[pickIndex] && target<arr[start]){
				binSearch(arr,pickIndex+1,end,target);
			}
		}
		
		return -1;
	}
	
	
    static int findPick(int[] arr){
		int start=0;
		int end=arr.length-1;
		
		while(start<end){
			int mid=start+(end-start)/2;
			
			if(arr[mid]>arr[end]){
				start=mid+1;
			}else{
				end=mid;
			}
		}
		
		return start-1;
	}
	
	static int binSearch(int [] arr,int start,int end,int target){
		while(start<end){
			int mid=start+(end-start)/2;
			if(target<arr[mid]){
				end=mid-1;
			}else if(target>arr[mid]){
				start=mid+1;
			}else{
				return mid;
			}
		}
		return -1;
	}
	
	
}
