#include<bits/stdc++.h>
using namespace std;
long long int _fibonacci_(long long int n, long long int* dp){
	if(n == 1 || n == 0){
		return n;
	}
	if(dp[n] != 0){
		return dp[n] % 1000000007;
	}
	long long int fbn = _fibonacci_(n-1,dp) + _fibonacci_(n-2,dp);
	dp[n] = fbn;
	return fbn % 1000000007;
}

long long int fibonacci(long long int n){
	long long int dp[n+1]{0};
	return _fibonacci_(n,dp);
}

int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif

	long long int n;	cin >> n;
	cout << fibonacci(n);

}