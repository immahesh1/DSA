#include<bits/stdc++.h>
using namespace std;

int main(){
	int n;
	cin >> n;

	int oczeroes = 1;
	int ocones = 1;

	for(int i=2; i<=n; i++){
		int nczeroes = ocones;
		int ncones = ocones + oczeroes;
		oczeroes = nczeroes;
		ocones = ncones;
	}
	cout << ocones + oczeroes;

	return 0;
}