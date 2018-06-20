class Solution {
	public int peakIndexInMountainArray(int[] A) {
        return peakIndexInMountainArrayImpl(A, 0, A.length-1);
    }
	
	private int peakIndexInMountainArrayImpl(int[] arr, int start, int end) {
		if (start > end) return -1;
		
		int mid = (start + end)/2;
		
		if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
			return mid;
		}
		else if (arr[mid] < arr[mid-1]) {
			return peakIndexInMountainArrayImpl(arr, start, mid-1);
		}
		else {
			return peakIndexInMountainArrayImpl(arr, mid+1, end);
		}
	}
}
