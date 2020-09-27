#include<bits/stdc++.h>
using namespace std;

std::vector<int> fill_1d_from_2d(std::vector<std::vector<int> > a2d, int s) {
	int minr = s - 1;
	int minc = s - 1;
	int maxr = a2d.size() - s;
	int maxc = a2d[0].size() - s;
	int k = 0;
	int sz = 2 * (maxr - minr + maxc - minc);

	std::vector<int> a1d(sz);
	//left wall
	for (int i = minr, j = minc; i <= maxr; i++) {
		a1d[k++] = a2d[i][j];
	}
	minc++;
	//bottom wall
	for (int i = maxr, j = minc; j <= maxc; j++) {
		a1d[k++] = a2d[i][j];
	} maxr--;

	//right
	for (int i = maxr, j = maxc; i >= minr; i--) {
		a1d[k++] = a2d[i][j];
	} maxc--;

	//top
	for (int i = minr, j = maxc; j >= minc; j--) {
		a1d[k++] = a2d[i][j];
	} minr++;
	return a1d;
}
void fill_2d_from_1d(std::vector<std::vector<int> > &a2d, std::vector<int> &a1d, int s) {
	int minr = s - 1;
	int minc = s - 1;
	int maxr = a2d.size() - s;
	int maxc = a2d[0].size() - s;
	int k = 0;

	//left wall
	for (int i = minr, j = minc; i <= maxr; i++) {
		a2d[i][j] = a1d[k++];
	}
	minc++;
	//bottom wall
	for (int i = maxr, j = minc; j <= maxc; j++) {
		a2d[i][j] = a1d[k++];
	} maxr--;

	//right
	for (int i = maxr, j = maxc; i >= minr; i--) {
		a2d[i][j] = a1d[k++];
	} maxc--;

	//top
	for (int i = minr, j = maxc; j >= minc; j--) {
		a2d[i][j] = a1d[k++];
	} minr++;
}
void reverse_array(std::vector<int> &ar , int first, int last) {
	while (first < last) {
		int tmp = ar[first];
		ar[first] = ar[last];
		ar[last] = tmp;
		first++;
		last--;
	}
}
void rotate_array(std::vector<int> &ar, int rot) {
	int n = ar.size();
	//reverse 1:
	reverse_array(ar, 0, n - rot - 1);

	//reverse 2:
	reverse_array(ar, n - rot, n - 1);

	//reverse 3:
	reverse_array(ar, 0, n - 1);
}


int main()
{

	int n, m, inp;
	cin >> n >> m;
	vector<vector<int> > a2d;

	for (int i = 0; i < n; i++) {
		vector<int> v;
		for (int j = 0; j < m; j++) {
			cin >> inp;
			v.push_back(inp);
		}
		a2d.push_back(v);
	}

	int s, rot;
	cin >> s >> rot;

	std::vector<int> a1d;

	// std::vector<int> a1d;
	//fill 1d from 2d
	a1d = fill_1d_from_2d(a2d, s);

	//rotate array
	rot = rot % a1d.size();
	if (rot < 0) {
		rot = rot + a1d.size();
	}
	rotate_array(a1d, rot);

	//fill 2d from 1d
	fill_2d_from_1d(a2d, a1d, s);


	//display
	for (int i = 0; i < a2d.size(); i++) {
		for (int j = 0; j < a2d[0].size(); j++) {
			cout << a2d[i][j] << " ";
		}
		cout << endl;
	}

	return 0;
}