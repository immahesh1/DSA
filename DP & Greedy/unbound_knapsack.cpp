#include<bits/stdc++.h>
using namespace std;

int main(){
	int n;
	cin >> n;

	int vals[n];
	int wht[n];
	for(int i=0; i<n; i++){
		cin >> vals[i];
	}
	for(int i=0; i<n; i++){
		cin >> wht[i];
	}
	int cap; cin >> cap;

	int dp[cap+1]{0};
	for(int bagc = 1; bagc <= cap; bagc++){
		int max = 0;
		for(int i=0; i<n; i++){
			if(wht[i] <= bagc){
				int rbagc = bagc - wht[i];
				int rbagv = dp[rbagc];
				int tbagv = rbagv + vals[i];
				
				if(tbagv > max){
					max = tbagv;
				}
			}
		}
		dp[bagc] = max;
	}

	cout << dp[cap];

	return 0;
}