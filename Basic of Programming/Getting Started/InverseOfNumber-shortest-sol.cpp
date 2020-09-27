#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main(){
	int n;
	cin >> n;
	int sum = 0;
	int pos = 1;
	while(n != 0){
		int d = n % 10;
		sum = sum + pos * pow(10,d); 
		n = n / 10;
		pos++;
	}
	sum = sum / 10;
	cout << sum << endl;
	return 0;
}