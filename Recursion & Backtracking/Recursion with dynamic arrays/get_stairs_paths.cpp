#include<bits/stdc++.h>
using namespace std;
typedef vector<string> vs;

void print_arraylist_format(vs v) {
	cout << "[";
	for (int i = 0; i < v.size() - 1; i++) {
		cout << v[i] << ", ";
	}
	cout << v[v.size() - 1] << "]";
}


vs getPath(int n) {
	if (n == 0) {
		vs bres;
		bres.push_back("");
		return bres;
	} else if (n < 0) {
		vs bres;
		return bres;
	}
	vs paths1 = getPath(n - 1);
	vs paths2 = getPath(n - 2);
	vs paths3 = getPath(n - 3);
	vs paths;

	for (auto p : paths1) {
		paths.push_back("1" + p);
	}
	for (auto p : paths2) {
		paths.push_back("2" + p);
	}
	for (auto p : paths3) {
		paths.push_back("3" + p);
	}
	return paths;
}

int main()
{
	int n;
	cin >> n;

	vs res = getPath(n);
	print_arraylist_format(res);
	return 0;
}