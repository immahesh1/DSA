#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n; cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	int oar[n];
	oar[n - 1] = -1;

	stack<int> st;
	st.push(ar[n - 1]);

	for (int i = n - 2; i >= 0; i--) {
		while (st.size() > 0 && st.top() <= ar[i]) {
			st.pop();
		}
		if (st.size() == 0) {
			oar[i] = -1;
		} else {
			oar[i] = st.top();
		}
		st.push(ar[i]);
	}

	for (auto a : oar) {
		cout << a << endl;
	}

	return 0;
}