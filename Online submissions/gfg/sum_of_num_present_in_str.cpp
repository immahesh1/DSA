#include<bits/stdc++.h>
using namespace std;

void string_sum(string s){
	string tmp ="";
	int sum = 0;
	for(char ch:s){
		if(isdigit(ch)){
			tmp += ch;
		}else{
			sum += atoi(tmp.c_str());
			tmp = "";
		}
	}
	cout << sum + atoi(tmp.c_str());
}
int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif
	string s;
	cin >> s;
	string_sum(s);
}