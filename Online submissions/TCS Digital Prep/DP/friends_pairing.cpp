#include<bits/stdc++.h>
using namespace std;

#define modValue 1000000007
typedef long long int lli;

int countFriendsPairing(int n){
	lli dp[n+1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    for(int i=4; i<=n; i++){
        dp[i] = (dp[i-1] % modValue + (i-1) % modValue * (dp[i-2] % modValue)) % modValue;
    }
    return dp[n];
}
int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif
	int n; cin >> n;
	cout << countFriendsPairing(n);

}