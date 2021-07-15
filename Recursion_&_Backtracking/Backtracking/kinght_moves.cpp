#include<bits/stdc++.h>
using namespace std;

typedef std::vector<std::vector<int> > vvi;

void displayBoard(vvi chess) {
	for (int i = 0; i < chess.size(); i++) {
		for (int j = 0; j < chess[0].size(); j++) {
			cout << chess[i][j] << " ";
		} cout << endl;
	}
	cout << endl;
}

void knightMoves(vvi chess, int r, int c, int move) {
	if (r < 0 || c < 0 || r >= chess.size() || c >= chess.size() || chess[r][c] > 0) {
		return;
	} else if (move == chess.size() * chess.size()) {
		chess[r][c] = move;
		displayBoard(chess);
		chess[r][c] = 0;
		return;
	}
	chess[r][c] = move;
	knightMoves(chess, r - 2, c + 1, move + 1);
	knightMoves(chess, r - 1, c + 2, move + 1);
	knightMoves(chess, r + 1, c + 2, move + 1);
	knightMoves(chess, r + 2, c + 1, move + 1);
	knightMoves(chess, r + 2, c - 1, move + 1);
	knightMoves(chess, r + 1, c - 2, move + 1);
	knightMoves(chess, r - 1, c - 2, move + 1);
	knightMoves(chess, r - 2, c - 1, move + 1);
	chess[r][c] = 0;
}


int main()
{
	int n, r, c;
	cin >> n >> r >> c;
	vvi chess(n, std::vector<int> (n));
	knightMoves(chess, r, c, 1);
	return 0;
}