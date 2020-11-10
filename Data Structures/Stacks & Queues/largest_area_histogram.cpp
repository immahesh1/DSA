#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n; cin >> n;
	int ar[n];
	for (int i = 0; i < n; i++) {
		cin >> ar[i];
	}

	//right boundary
	//next lesser element on the right
	//we are dealing with index not with elements
	int arsize = sizeof(ar) / sizeof(ar[0]);
	int rb[arsize];
	stack<int> st;

	rb[arsize - 1] = arsize; // element having no next lesser elemnt on the right
	//assuming as last element contains smallest element
	st.push(arsize - 1);
	for (int i = arsize - 2; i >= 0; i--) {
		while (st.size() > 0 && ar[i] <= ar[st.top()] ) {
			st.pop();
		}

		if (st.size() == 0) {
			rb[i] = arsize;
		} else {
			rb[i] = st.top();
		}
		st.push(i);
	}


	//left boundary
	int lb[arsize];
	lb[0] = -1;
	stack<int> st1;
	st.push(0); //pushing index
	for (int i = 1; i < n; i++) {
		while (st1.size() > 0 && ar[i] <= ar[st1.top()]) {// pop
			st1.pop();
		}
		if (st1.size() == 0) { // ans
			lb[i] = -1;
		} else {
			lb[i] = st1.top();
		}
		st1.push(i);
	}

	int max_area = 0;
	for (int i = 0; i < n; i++) {
		int width = rb[i] - lb[i] - 1;
		int area = width * ar[i];
		if (area > max_area) {
			max_area = area;
		}
	}

	cout << max_area;

	return 0;
}