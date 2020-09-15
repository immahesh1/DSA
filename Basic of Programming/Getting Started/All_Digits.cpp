#include "bits/stdc++.h"
using namespace std;

int main(){
	int n;
	cin >> n;
	int count_digits = 0;
	int copy_n = n;
	while(n>0){
		count_digits++;
		n = n/10;
	}
	int divisor = pow(10,count_digits-1);
	
	while(divisor != 0){
		cout << copy_n / divisor <<endl; //5623 100
		copy_n = copy_n % divisor;
		divisor = divisor / 10;
		
	}
}
