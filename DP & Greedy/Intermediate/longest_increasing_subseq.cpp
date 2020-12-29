#include<bits/stdc++.h>
using namespace std;

int countSubseq(int* ar, int n){
	int dp[n]{0};
	int omax = 0;
	for(int i=0; i<n; i++){
		int max = 0;
		for(int j=0; j<i; j++){
			if(ar[j] <= ar[i]){
				if(dp[j] > max){
					max = dp[j];
				}
			}
		}
		dp[i] = max + 1;
		if(dp[i] > omax){
			omax = dp[i];
		}
	}
	return omax;
}
int main(){
	int n; cin >> n;
	int ar[n];
	for(int i=0; i<n; i++)
		cin >> ar[i];

	cout << countSubseq(ar,n);
}