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
	if (sr == dr && sc == dc) {
		vs bres;
		bres.push_back("");
		return bres;
	}
	vs hpaths;
	vs vpaths;
	//horizontal
	if (sc < dc) {
		hpaths = getMazePath(sr, sc + 1, dr, dc);
	}
	// Vertical
	if (sr < dr) {
		vpaths = getMazePath(sr + 1, sc, dr, dc);
	}

	vs out;
	for (auto path : hpaths) {
		out.push_back("h" + path);
	}
	for (auto path : vpaths) {
		out.push_back("v" + path);
	}
	return out;
}

int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif

	int dr, dc;
	cin >> dr >> dc;
	vs res = getMazePath(1, 1, dr, dc);
	// cout << res.size();
	print_arraylist_format(res);

	return 0;
}