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

string check_prime(int);
int main()
{
//	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
//#ifndef ONLINE_JUDGE
//	freopen("input1.txt", "r", stdin);
//	freopen("output1.txt", "w", stdout);
//#endif

	int T;
	cin >> T;
	while (T--) {
		int N;
		cin >> N;
 		cout << check_prime(N) << endl;
	}
	return 0;
}

string check_prime(int n){
	int flag = 0; //prime
	for (int i=2; i*i<=n; i++){
		if(n%i==0){
			flag = 1; //not prime
			break;
		}
	}
	return((flag==1?"not prime":"prime"));
}
