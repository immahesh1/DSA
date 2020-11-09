#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n; cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}

	stack<int> st;
	st.push(0);
	int span[n];
	span[0] = 1;
	for (int i = 1; i < n; i++) {
		while (st.size() > 0 && ar[i] > ar[st.top()]) {
			st.pop();
		}

		if (st.size() == 0) {
			span[i] = i + 1;
		} else {
			span[i] = i - st.top();
		}
		st.push(i);
	}

	for (auto e : span) {
		cout << e << endl;
	}

	return 0;
}