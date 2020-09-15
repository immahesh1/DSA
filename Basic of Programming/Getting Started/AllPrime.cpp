
#include "bits/stdc++.h"
using namespace std;
#define max(a, b) (a < b? b : a)
#define min(a, b) ((a>b)?b:a)
#define mod 1e9+7
#define fo(a,c)   for ( int (a)=0; (a)<(c); (a)++)
#define fori(a,b,c)  for ( int (a)=(b); (a)<=(c); (a)++)
#define ford(a,b,c)  for (  int (a)=(b); (a)>=(c); (a)--)
#define INF 1000000000000000003
typedef long long int ll;
typedef vector<int> vi;
typedef pair<int, int> pi;
#define F first
#define S second
#define pb push_back
#define pob pop_back
#define mp make_pair

bool isPrime(int);
int main(){
	int low,high;
	cin >> low >> high;
	for(int i=low; i<=high; i++){
		if(isPrime(i)==true){
			cout << i <<"\t";
		}
	}
}

bool isPrime(int n){
	int flag = 0;  //Prime
	for(int i=2; i*i<=n; i++){
		if(n%i==0){
			flag = 1; //Not Prime
			break;
		}
	}
	return (flag==1?false:true);
}


