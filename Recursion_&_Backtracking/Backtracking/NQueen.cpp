#include<bits/stdc++.h>
using namespace std;

typedef vector<vector<int> > vvi;

bool isQueenSafeHere(vvi chess, int row, int col) {
	for (int i = row - 1, j = col; i >= 0; i--) {
		if (chess[i][j] == 1) {
			return false;
		}
	}

	for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
		if (chess[i][j] == 1) {
			return false;
		}
	}

	for (int i = row - 1, j = col + 1; i >= 0 && j < chess.size(); i--, j++) {
		if (chess[i][j] == 1) {
			return false;
		}
	}
	return true;
}
void printNQueens(vvi chess, string qsf, int row) {
	if (row == chess.size()) {
		cout << qsf << "." << endl;
		return;
	}
	for (int col = 0; col < chess.size(); col++) {
		if (isQueenSafeHere(chess, row, col) == true) {
			chess[row][col] = 1;
			printNQueens(chess, qsf + to_string(row) + "-" + to_string(col) + ", ", row + 1);
			chess[row][col] = 0;
		}
	}
}

int main()
{
	int n, e;
	cin >> n;
	vvi v(n, vector<int> (n));

	printNQueens(v, "", 0);
	return 0;
}