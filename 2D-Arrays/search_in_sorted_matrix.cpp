#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n, inp;
	cin >> n;

	std::vector<std::vector<int> > v;
	for (int i = 0; i < n; i++) {
		std::vector<int> vaux;
		for (int j = 0; j < n; j++) {
			cin >> inp;
			vaux.push_back(inp);
		}
		v.push_back(vaux);
	}

	int s;
	cin >> s;

	for (int r = 0; r < n; r++) {
		if (s >= v[r][0] && s <= v[r][n - 1]) {
			for (int j = 0; j < n; j++) {
				if (v[r][j] == s) {
					cout << r << "\n" << j;
					return 0;
				}
			}
		}
	}
	cout << "Not Found";


	return 0;
}