#include<bits/stdc++.h>
using namespace std;

void print_arraylist_format(std::vector<string> v) {
	cout << "[";
	for (int i = 0; i < v.size() - 1; i++) {
		cout << v[i] << ", ";
	}
	cout << v[v.size() - 1] << "]";
}

std::vector<string> subsequence(string s) {
	if (s.size() == 0) {
		std::vector<string> bres;
		bres.push_back("");
		return bres;
	}
	char frst = s[0];
	string rem = s.substr(1, s.size() - 1);

	std::vector<string> rres = subsequence(rem);

	std::vector<string> fres;
	for (auto el : rres) {
		fres.push_back("" + el);
	}
	for (auto el : rres) {
		fres.push_back(frst + el);
	}
	return fres;
}

int main()
{
	string s;
	cin >> s;

	std::vector<string> result = subsequence(s);
	print_arraylist_format(result);

	return 0;
}