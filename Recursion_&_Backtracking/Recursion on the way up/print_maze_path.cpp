#include<bits/stdc++.h>
using namespace std;

void print_maze_path(int sr, int sc, int dr, int dc, string s) {
	if (sc > dc || sr > dr) {
		return;
	}
	if (sc == dc && sr == dr) {
		cout << s << endl;
		return;
	}
	// horizontal move
	print_maze_path(sr, sc + 1, dr, dc, s + "h");

	// vertical move
	print_maze_path(sr + 1, sc, dr, dc, s + "v");
}

int main()
{
	int n, m;
	cin >> n >> m;

	print_maze_path(1, 1, n, m, "");
	return 0;
}