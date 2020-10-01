#include<iostream>
using namespace std;

bool isPalli(string s) {
	if (s.size() == 1) {
		return true;
	}
	for (int i = 0, j = s.size() - 1; i < s.size() / 2; i++, j--) {
		if (s[i] != s[j]) {
			return false;
			break;
		}
	}
	return true;
}

int main(){
	string s;
	cin >> s;
	int sz = 1;
	for(int sz=1; sz<=s.size();sz++){
		for(int i=0; i<=s.size() - sz; i++){
//			cout << s.substr(i,sz) << endl;
			string str = s.substr(i,sz);
			if(isPalli(str)==1){
				cout << str << endl;
			}
		}
	}

	
}