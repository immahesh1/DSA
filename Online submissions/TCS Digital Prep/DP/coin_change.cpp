#include<bits/stdc++.h>
using namespace std;

class Solution{
public:
	long long int count(int *ar, int m, int n){
		long long int dp[n+1]{0};
		dp[0] = 1;
		for(int i=0; i<m; i++){
	        for(int j=ar[i]; j<=sizeof(dp)/sizeof(dp[0]); j++){
	            dp[j] = dp[j] + dp[j-ar[i]];
	        }
	    }
	    return dp[n];
	}
};

int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif
	int n; cin >> n;
	int m; cin >> m;
	int ar[m];
	for(int i=0; i<n; i++){
		cin >> ar[i];
	}
	Solution ob;
	cout << ob.count(ar,m,n);
}