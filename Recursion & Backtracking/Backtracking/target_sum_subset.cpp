#include<bits/stdc++.h>
using namespace std;

void get_sum(vector<int> ar, int idx, string ssf, int sum_so_far, int tar) {

	if (idx == ar.size()) {
		if (sum_so_far == tar) {
			cout << ssf << "." << endl;
		}
		return;
	}

	get_sum(ar, idx + 1, ssf + to_string(ar[idx]) + ", ", sum_so_far + ar[idx], tar);
	get_sum(ar, idx + 1, ssf, sum_so_far, tar);

}

int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif

	int n, tar;
	cin >> n;
	std::vector<int> v;
	for (int i = 0; i < n; i++) {
		int e;
		cin >> e;
		v.push_back(e);
	}
	cin >> tar;

	get_sum(v, 0, "", 0, tar);

	return 0;
}