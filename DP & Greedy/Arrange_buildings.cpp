#include<bits/stdc++.h>
using namespace std;

typedef long long int lli;

int main(){
	int n;
	cin >> n;

	lli obuilding = 1;
	lli ospace = 1;

	for(int i=2; i<=n; i++){
		lli nbuilding = ospace;
		lli nspace = ospace + obuilding;
		ospace = nspace;
		obuilding = nbuilding;
	}
	lli onesideways = obuilding+ospace;
	cout << onesideways * onesideways;
	return 0;
}