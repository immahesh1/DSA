#include<bits/stdc++.h>
using namespace std;

long long countSubseq(int* ar, int n){
	long long dp[n]{0};
	long long sum_overall = INT_MIN;
	for(int i=0; i<n; i++){
		int max = -1;
		for(int j=0; j<i; j++){
			if(ar[j] <= ar[i]){
				if(max == -1){
					max = dp[j];
				}
				else if(dp[j] > max){
					max = dp[j];
				}
			}
		}
		if(max == -1){
			dp[i] = ar[i];
		}else{
			dp[i] = max + ar[i];
		}
		if(dp[i] > sum_overall){
			sum_overall = dp[i];
		}
	}
	return sum_overall;
}
int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif
	int n; cin >> n;
	int ar[n];
	for(int i=0; i<n; i++)
		cin >> ar[i];

	cout << countSubseq(ar,n);
}