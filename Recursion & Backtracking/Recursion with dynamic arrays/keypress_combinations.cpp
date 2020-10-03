#include<bits/stdc++.h>
using namespace std;
std::vector<string> codes{".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

void print_arraylist_format(std::vector<string> v) {
	cout << "[";
	for (int i = 0; i < v.size() - 1; i++) {
		cout << v[i] << ", ";
	}
	cout << v[v.size() - 1] << "]";
}

std::vector<string> getKeyCombination(string s) {
	// Base case
	if (s.size() == 0) {
		std::vector<string> bres;
		bres.push_back("");
		return bres;
	}

	char first = s[0];
	string rem = s.substr(1, s.size() - 1);
	std::vector<string> rres = getKeyCombination(rem);
	std::vector<string> final_res;

	string codes_of_i = codes[first - '0'];
	for (int i = 0; i < codes_of_i.size(); i++) {
		for (auto e : rres) {
			final_res.push_back(codes_of_i[i] + e);
		}
	}
	return final_res;
}

int main()
{
	string s;
	cin >> s;

	std::vector<string> res = getKeyCombination(s);
	print_arraylist_format(res);

	return 0;
}