package step5;

public class Arrparm {
	float avg;
	int max = -10000;
	int sum = 0;
	
	int makeMax(int[] arr1) {
		for(int i=0; i<arr1.length; i++) {
			if(max < arr1[i]) {
				max = arr1[i];
			}
		}
		
		return max;
	}
	
	int makeSum(int[] arr1) {
		for(int i=0; i<arr1.length; i++) {
			sum += arr1[i];
		}
		
		return sum;
	}
	
	float makeAvg(int[] arr1) {
		for(int i=0; i<arr1.length; i++) {
			sum += arr1[i];
		}
		return sum / arr1.length;
	}
}
