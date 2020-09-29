#include<bits/stdc++.h>
using namespace std;

long find_max(vector<long> ar, int ind) {
	if (ind == ar.size() - 1) {
		return ar[ind];
	}
	long misa = find_max(ar, ind + 1);
	if (misa > ar[ind]) {
		return misa;
	} else {
		return ar[ind];
	}
}

int main()
{
	int n;
	long el;
	cin >> n;

	std::vector<long> ar;
	for (int i = 0; i < n; i++) {
		cin >> el;
		ar.push_back(el);
	}

	cout << find_max(ar, 0);

	return 0;
}

// import java.io.*;
// import java.util.*;

// public class Main {

//     public static void main(String[] args) throws Exception {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int ar[] = new int[n];
//         for(int i=0; i<n; i++){
//             ar[i] = sc.nextInt();
//         }
        
//         System.out.println(maxOfArray(ar,0));
//     }

//     public static int maxOfArray(int[] arr, int idx){
//         if(idx == arr.length - 1){
//             return arr[idx];
//         }
        
//         int misa = maxOfArray(arr,idx+1);
//         if(misa>arr[idx]){
//             return misa;
//         }else{
//             return arr[idx];
//         }
//     }

// }