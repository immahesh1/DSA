#include<bits/stdc++.h>
using namespace std;

int main()
{
	string s;
	getline(cin, s);

	stack<char> st;

	for (int i = 0; i < s.size(); i++) {
		if (s[i] == ')') {
			if (st.top() == '(') {
				cout << "true";
				return 0;
			} else {
				while (st.top() != '(') {
					st.pop();
				}
				st.pop();
			}

		} else {
			st.push(s[i]);
		}
	}

	cout << "false";
	return 0;
}