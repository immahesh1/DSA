#include<bits/stdc++.h>
using namespace std;

bool cmp(pair<char, int>& a, pair<char, int>& b){
	return a.second > b.second;
}
void sort(map<char,int> &m){
	std::vector<pair<char,int>> v;
	for(auto it:m){
		v.push_back(it);
	}
	sort(v.begin(),v.end(),cmp);
	cout << v[0].first;
}
int main(){
	string s;
	cin >> s;
	map<char,int> mp;
	for(int i=0; i<s.size(); i++){
		mp[s[i]]++;
	}
	sort(mp);
}