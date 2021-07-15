#include<bits/stdc++.h>
using namespace std;

void print_stair_paths(int n, string s) {
	if (n < 0) {
		return;
	}
	if (n == 0) {
		cout << s << endl;
	}
	for (int i = 1; i <= 3; i++) {
		print_stair_paths(n - i, s + to_string(i));
	}
}

int main()
{
	int n;
	cin >> n;
	print_stair_paths(n, "");

	return 0;
}