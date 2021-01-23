#include<bits/stdc++.h>
using namespace std;

string validateIPAdd(string IP){
	regex v4("(([0-9]|[1-9][0-9]|[1][0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|[1][0-9][0-9]|2[0-4][0-9]|25[0-5])");
	if(regex_match(IP,v4))
		return "IPv4";
	regex v6("((([0-9a-fA-F]){1,4})\\:){7}([0-9a-fA-F]){1,4}");
	if(regex_match(IP,v6)){
		return "IPv6";
	}
	return "Neither";
}

int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif
	string str;
	cin >> str;
	cout << validateIPAdd(str) << endl;
}
