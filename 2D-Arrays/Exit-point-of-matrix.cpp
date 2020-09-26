#include<bits/stdc++.h>
using namespace std;

int main()
{
    int n, m;
	cin >> n >> m;
	int ar[n][m];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> ar[i][j];
		}
	}

	int dir = 0;	// starting from east direction, considering east as 0
	int i = 0;
	int j = 0;

	//define directions
	// east -> 		i,j++
	// south -> 	i++,j
	// west ->		i,j--
	// north -> 	i--,j

	while (true) {
		dir = (dir + ar[i][j]) % 4;	//since we have 4 directions so mod by 4
		if (dir == 0) {	//east
			j++;
		} else if (dir == 1) { //south
			i++;
		} else if (dir == 2) { //west
			j--;
		} else if (dir == 3) { //north
			i--;
		}

		//Now get the exact co-ordinate
		//4 conds for pointers to not cross boundry
		if (i < 0) {
			i++;
			break;
		} else if (j < 0) {
			j++;
			break;
		} else if (i == sizeof(ar) / sizeof(ar[0])) {
			i--;
			break;
		} else if (j == sizeof(ar[0]) / sizeof(ar[0][0])) {
			j--;
			break;
		}
	}
	cout << i << "\n" << j;
	return 0;
}