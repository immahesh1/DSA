#include<bits/stdc++.h>
using namespace std;
void charCount(string s){
	unordered_map<char,int> cct;
	for(int i=0; i<s.size(); i++){
		cct[s[i]]++;
	}
	for(unordered_map<char,int>::iterator it = cct.begin(); it != cct.end(); it++){
		cout << it->first << " " << it->second << endl;
	}
}
int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif
	string str;
	getline(cin,str);
	charCount(str);
}