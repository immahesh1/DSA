#include<bits/stdc++.h>
using namespace std;
std::vector<string> dict = {"abc","def","ghi","jkl","nmo","pqr","stu","vwx","yz"};

vector<string> keypad_comb(string s){
	if(s.size() == 0){
		vector<string> v;
		v.push_back(" ");
		return v; 
	}
	int n = (s[0]-'0');
	string rem = s.substr(1,s.size()-1);
	vector<string> ret = keypad_comb(rem);
	string dict_val = dict[n];
	vector<string> out;
	for(auto e:ret){
		for(auto d:dict_val){
			out.push_back(d+e);
		}
	}
	return out;
}
int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif
	string s;	cin >> s;
	std::vector<string> ress = keypad_comb(s);
	for(auto re:ress){
		cout << re << endl;
	}

}