#include<bits/stdc++.h>
using namespace std;

class Bridge{
public:
	int n,s;
	Bridge(int n, int s){
		this -> n = n;
		this -> s = s;
	}
};

class compareDir{
public:
	bool operator()(const Bridge& b1, const Bridge& b2){
		if(b1.n < b2.n){
			return true;
		}else if(b1.n == b2.n){
			if(b1.s < b2.s){
				return true;
			}
		}
		return false;
	}
};

int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif
	int n,a,b;	cin >> n;
	std::list<Bridge> ar;
	for(int i=0; i<n; i++){
		cin >> a >> b;
		Bridge br(a,b);
		ar.push_back(br);
	}

	compareDir cmp;
	ar.sort(cmp);	

	int dp[n];
	int omax = 0;
	for(int i=0; i<n; i++){
		int max = 0;
		for(int j=0; j<i; j++){
			if(ar[i].s <= ar[i].s){
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
	cout << omax;

}