#include<bits/stdc++.h>
using namespace std;
typedef vector<string> vs;

void print_arraylist_format(vs v) {
	cout << "[";
	for (int i = 0; i < v.size() - 1; i++) {
		cout << v[i] << ", ";
	}
	cout << v[v.size() - 1] << "]";
}

vs getMazePath(int sr, int sc, int dr, int dc) {
	if (sr > dr || sc > dc) {
		vs bres;
		return bres;
	}
	if (sr == dr && sc == dc) {
		vs bres;
		bres.push_back("");
		return bres;
	}

	vs out_path;
	// Moving horizontally
	for (int ms = 1; ms <= dr - ms; ms++) {
		vs hpaths = getMazePath(sr, sc + ms, dr, dc);
		for (auto hpath : hpaths) {
			out_path.push_back("h" + to_string(ms) + hpath);
		}
	}
	// Moving vertically
	for (int ms = 1; ms <= dc - ms; ms++) {
		vs vpaths = getMazePath(sr + ms, sc, dr, dc);
		for (auto vpath : vpaths) {
			out_path.push_back("v" + to_string(ms) + vpath);
		}
	}
	// Moving Diagonally
	for (int ms = 1; ms <= dr - ms && ms < dc - sc; ms++) {
		vs dpaths = getMazePath(sr + ms, sc + ms, dr, dc);
		for (auto dpath : dpaths) {
			out_path.push_back("d" + to_string(ms) + dpath);
		}
	}
	return out_path;
}
int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif
	int n, m;
	cin >> n >> m;

	vs res = getMazePath(1, 1, n, m);
	print_arraylist_format(res);

	return 0;
}