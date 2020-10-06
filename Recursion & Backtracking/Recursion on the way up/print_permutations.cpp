#include<bits/stdc++.h>
using namespace std;

void print_permutations(string ques, string ans) {
	if (ques.size() == 0) {
		cout << ans << endl;
		return;
	}
	for (int i = 0; i < ques.size(); i++) {
		char c = ques[i];
		string q2 = ques;
		string rem = q2.erase(i, 1);
		print_permutations(rem, ans + c);
	}

}
int main()
{
	string s;
	cin >> s;

	print_permutations(s, "");
	return 0;
}