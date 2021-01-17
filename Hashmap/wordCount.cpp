#include<bits/stdc++.h>
using namespace std;
void highest_freq_char(string &s){
	unordered_map<string, int> wf;
	stringstream ss(s);
	string word;
	while(ss >> word)
		wf[word]++;
	for(auto i:wf)
		cout << i.first << " " << i.second << endl;
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
	highest_freq_char(str);
}