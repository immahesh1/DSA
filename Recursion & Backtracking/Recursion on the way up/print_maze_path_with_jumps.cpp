#include<bits/stdc++.h>
using namespace std;

void print_maze_path(int sr, int sc, int dr, int dc, string s) {
    if(sr > dr || sc > dc){
        return;
    }
	if (sc == dc && sr == dr) {
		cout << s << endl;
		return;
	}
	// horizontal move
	for (int ms = 1; ms <= dc - sc; ms++) {
		print_maze_path(sr, sc + ms, dr, dc, s + "h" + to_string(ms));
	}

	// vertical move
	for (int ms = 1; ms <= dr - sr; ms++) {
		print_maze_path(sr + ms, sc, dr, dc, s + "v" + to_string(ms));
	}
	// diagonal move
	for (int ms = 1; ms <= dc - sc && ms <= dr - sr ; ms++) {
		print_maze_path(sr + ms, sc + ms, dr, dc, s + "d" + to_string(ms));
	}
}

int main()
{

	int n, m;
	cin >> n >> m;

	print_maze_path(1, 1, n, m, "");
	return 0;
}