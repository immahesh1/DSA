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

int evaluation(int v1, int v2, char opr) {
	if (opr == '+') {
		return v1 + v2;
	} else if (opr == '-') {
		return v1 - v2;
	} else if (opr == '*') {
		return v1 * v2;
	} else if (opr == '/') {
		return v1 / v2;
	}
}
int main()
{
	string s;
	getline(cin, s);

	stack<int> oprnds;
	stack<char> oprtr;
	for (int i = 0; i < s.size(); i++) {
		if (isdigit(s[i])) {
			oprnds.push(s[i] - '0');
		} else if (s[i] == '(') {
			oprtr.push(s[i]);
		} else if (s[i] == ')') {
			while (oprtr.top() != '(') {
				int op1 = oprnds.top();
				oprnds.pop();
				int op2 = oprnds.top();
				oprnds.pop();
				int evl = evaluation(op2, op1, oprtr.top());
				oprtr.pop();
				oprnds.push(evl);
			}
			oprtr.pop();
		} else if (s[i] == '+' || s[i] == '-' || s[i] == '*' || s[i] == '/') {
			while (oprtr.size() > 0  && oprtr.top() != '(' && precedence(s[i]) <= precedence(oprtr.top())) {
				int op1 = oprnds.top();
				oprnds.pop();
				int op2 = oprnds.top();
				oprnds.pop();
				int evl = evaluation(op2, op1, oprtr.top());
				oprtr.pop();
				oprnds.push(evl);
			}
			oprtr.push(s[i]);
		}

	}
	while (oprtr.size() > 0) {
		int op1 = oprnds.top();
		oprnds.pop();
		int op2 = oprnds.top();
		oprnds.pop();
		int evl = evaluation(op2, op1, oprtr.top());
		oprtr.pop();
		oprnds.push(evl);
	}

	cout << oprnds.top();
	oprnds.pop();

	return 0;
}