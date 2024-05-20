package codice;

import java.util.ArrayList;

public class EsMetodi {
	
	public static <T> void swap(T [] array, int i, int j) {
		if (i>=array.length || j>=array.length) return;
		T temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}


	public static int miaSomma(int k, int... n) {
		int sum=0;
		if(n.length>k) {
			for(int i=0; i<k; i++) sum+=n[i]; 
		}
		else {
			for(int i=0; i<n.length; i++) sum+=n[i]; 
		}
		return sum;
	}
	
	
//	public static int media(int m,long n) {
//		return 0;
//	}

	
	public static long media(int n,long m) {
		return 0;
	}
	

	public static long media(long n,int m) {
		return 0;
	}


}
