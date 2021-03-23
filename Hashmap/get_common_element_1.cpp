#include<bits/stdc++.h>
using namespace std;

int main(){
	int n1,n2;	cin >> n1;
	std::vector<int> a1,a2;
	int e;
	for(int i=0; i<n1; i++){
		cin >> e;
		a1.push_back(e);
	}
	cin >> n2;
	for(int i=0; i<n2; i++){
		cin >> e;
		a2.push_back(e); 
	}

	map<int,int> m;

	for(auto it:a1){
		m[it]++;
	}
	for(auto it:a2){
		if(m.count(it)){
			cout << it << endl;
			m.erase(it);
		}
	}
}