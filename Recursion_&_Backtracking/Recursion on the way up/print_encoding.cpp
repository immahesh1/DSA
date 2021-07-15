#include<bits/stdc++.h>
using namespace std;

void print_encoding(string ques, string asf) {
	if (ques.size() == 0) {
		return;
	} else if (ques.size() == 1) {
		char ch = ques[0];
		if (ch == '0') {
			return;
		} else {	// If char is non zero then get the value of char and print accordingly
			int chval = ch - '0';
			char code = (char)('a' + chval - 1);
			cout << asf + code << endl;
		}
	} else { // If size is greater than 2
		char frst = ques[0];
		string roq = ques.substr(1, ques.size() - 1);
		//for one character
		if (frst == '0') {
			return;
		} else {
			int chval = frst - '0';
			char code = (char)('a' + chval - 1);
			print_encoding(roq, asf + code);
		}
		//for more than one character
		string ch12 = ques.substr(0, 2);
		string roq2 = ques.substr(2, ques.size() - 1);
		int ch12val = stoi(ch12);
		if (ch12val <= 26) {
			char code = (char)('a' + ch12val - 1);
			print_encoding(roq2, asf + code);
		}
	}
}
int main()
{
	string s;
	cin >> s;

	print_encoding(s, "");

	return 0;
}