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


	for (int i = 0; i < v.size(); i++) {
		int svcol = 0;
		for (int c = 1; c < v[0].size(); c++) { // finding the smallest in row
			if (v[i][c] < v[i][svcol]) {
				svcol = c;
			}
		}
		bool flag = true;
		for (int j = 0; j < v[0].size(); j++) { //finding largest in column
			if (v[j][svcol] > v[i][svcol]) {
				flag = false;
				break;
			}
		}

		if (flag == true) {
			cout << v[i][svcol];
			return 0;
		}
	}
	cout << "Invalid input";
	return 0;
}