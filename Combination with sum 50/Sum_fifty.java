package collections_framework;

import java.util.Arrays;
import java.util.Scanner;

public class Sum_fifty {
	static void sum(int[] ar) {
		Arrays.sort(ar);
		int count=0;
		for(int j=ar.length-1;j>=0;j--){
			if(j-2<0){
				break;
			}
			if((ar[j]+ar[j-1]+ar[j-2])==50){
				System.out.println(ar[j]+" "+ar[j-1]+" "+ar[j-2]);
				count++;
			}
		}
		if(count==0){
			System.out.println("NO numbers");
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj_in = new Scanner(System.in);
	      System.out.println("Enter size of the array:");
	      int size = obj_in.nextInt();
	      int[] arr = new int[size];
	      System.out.print("Enter elements of the array:");
	      for(int i=0; i<size;i++){
	          arr[i]=obj_in.nextInt();
	      }
	      sum(arr);
	      obj_in.close();
	     
	}

}
