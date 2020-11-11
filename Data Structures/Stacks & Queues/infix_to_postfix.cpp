#include<bits/stdc++.h>
using namespace std;

int precedence(char opr) {
	if (opr == '+') {
		return 1;
	} else if (opr == '-') {
		return 1;
	} else if (opr == '*') {
		return 2;
	} else if (opr == '/') {
		return 2;
	}
}
string postfix_conversion(string s) {
	stack<char> st;
	string postfix = "";
	for (int i = 0; i < s.size(); i++) {
		if (s[i] != '+' && s[i] != '-' && s[i] != '*' && s[i] != '/' && s[i] != '(' && s[i] != ')') {
			postfix += s[i];
		}
		else if (s[i] == '(') {
			st.push(s[i]);
		} else if (s[i] == ')') {
			while (st.top() != '(') {
				postfix += st.top();
				st.pop();
			}
			st.pop();
		} else if (s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/') {
			while (st.size() > 0 && st.top() != '(' && precedence(s[i]) <= precedence(st.top())) {
				postfix += st.top();
				st.pop();
			}
			st.push(s[i]);
		}
	}
	while (st.size() > 0) {
		postfix += st.top();
		st.pop();
	}

	return postfix;
}

int main()
{
	string s;
	getline(cin, s);
	cout << postfix_conversion(s);
	return 0;
}