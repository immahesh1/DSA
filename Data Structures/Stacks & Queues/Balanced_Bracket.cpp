#include<bits/stdc++.h>
using namespace std;

int main()
{
	string s;
	getline(cin, s);

	stack<char> st;

	for (int i = 0; i < s.size(); i++) {
		if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
			st.push(s[i]);
		} else if (s[i] == ')') {
			if (st.size() != 0 && st.top() == '(') {
				st.pop();
			} else {
				cout << "false";
				return 0;
			}
		}
		else if (s[i] == '}') {
			if (st.size() != 0 && st.top() == '{') {
				st.pop();
			} else {
				cout << "false";
				return 0;
			}
		}
		else if (s[i] == ']') {
			if (st.size() != 0 && st.top() == '[') {
				st.pop();
			} else {
				cout << "false";
				return 0;
			}
		}
	}

	if (st.size() > 0) {
		cout << "false";
		return 0;
	}

	cout << "true";

	return 0;
}