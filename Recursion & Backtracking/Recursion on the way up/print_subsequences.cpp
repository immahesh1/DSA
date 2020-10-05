#include<bits/stdc++.h>
using namespace std;

void print_subseq(string ques, string ans) {
	if (ques.size() == 0) {
		cout << ans << endl;
		return;
	}
	char f = ques[0];
	string rem = ques.substr(1, ques.size() - 1);
	
	print_subseq(rem, ans + f);
	print_subseq(rem, ans + "");
}

int main()
{
	string s;
	cin >> s;

	print_subseq(s, "");
	return 0;
}