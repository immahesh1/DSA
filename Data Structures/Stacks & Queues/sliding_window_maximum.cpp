#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n; cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}
	int k; cin >> k;

	int nge[n];
	nge[n - 1] = n; //storing the index not the actual element
	stack<int> st;
	st.push(n - 1);

	for (int i = n - 2; i >= 0; i--) {
		while (st.size() > 0 && ar[i] >= ar[st.top()]) {
			st.pop();
		}

		if (st.size() == 0) {
			nge[i] = n;
		} else {
			nge[i] = st.top();
		}
		st.push(i);
	}

	int j = 0;
	for (int i = 0; i <= n - k; i++) {
		if (j < i) {
			j = i;
		}
		while (nge[j] < i + k) { //neg[j] provides index of next greater element of jth element
			j = nge[j];
		}
		cout << ar[j] << endl;
	}

	return 0;
}