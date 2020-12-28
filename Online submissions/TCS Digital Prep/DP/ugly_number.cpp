#include<bits/stdc++.h>
using namespace std;

int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif

	int n;	cin >> n;
	unsigned ugly[n];
	ugly[0] = 1;
	int i2 = 0, i3 = 0, i5 = 0;
	
	unsigned next_mult_of_2 = 2;
	unsigned next_mult_of_3 = 3;
	unsigned next_mult_of_5 = 5;
	unsigned next_ugly_no = 1;
	
	for(int i=1; i<n; i++){
		next_ugly_no = std::min(next_mult_of_2, std::min(next_mult_of_3, next_mult_of_5));
		ugly[i] = next_ugly_no;

		if(next_ugly_no == next_mult_of_2){
			i2 = i2 + 1;
			next_mult_of_2 = ugly[i2] * 2;
		}
		if(next_ugly_no == next_mult_of_3){
			i3 = i3 + 1;
			next_mult_of_3 = ugly[i3] * 3;
		}
		if(next_ugly_no == next_mult_of_5){
			i5 = i5 + 1;
			next_mult_of_5 = ugly[i5] * 5;
		}
	}
	cout << next_ugly_no;

}