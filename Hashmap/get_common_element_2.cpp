#include<bits/stdc++.h>
using namespace std;

int main(){
	int n1,n2,e; cin >> n1;
	map<int,int> mp;
	for(int i=0; i<n1; i++){
		cin >> e;
		mp[e]++;
	}
	cin >> n2;
	for(int i=0; i<n2; i++){
		cin >> e;
		if(mp.count(e) && mp.at(e) > 0){
			cout << e << endl;
			mp[e]--;
		}
	}
}