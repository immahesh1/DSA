#include<bits/stdc++.h>
using namespace std;

void flood_fill(int row, int col, vector<vector<int> > maze, string asf, std::vector<std::vector<bool> > visited) {
	if (row < 0 || col < 0 || row == maze.size() || col == maze[0].size() ||
	        maze[row][col] == 1 || visited[row][col] == true) {
		return;
	}
	if (row == maze.size() - 1 && col == maze[0].size() - 1) {
		cout << asf << endl;
		return;
	}

	visited[row][col] = true;
	flood_fill(row - 1, col, maze, asf + "t", visited); //top
	flood_fill(row, col - 1, maze, asf + "l", visited); //left
	flood_fill(row + 1, col, maze, asf + "d", visited); //down
	flood_fill(row, col + 1, maze, asf + "r", visited); //right
	visited[row][col] = false;
}

int main()
{
	int n, m;
	cin >> n >> m;

	vector<vector<int> > ar;
	for (int i = 0; i < n; i++) {
		std::vector<int> aux;
		for (int j = 0; j < m; j++) {
			int e;
			cin >> e;
			aux.push_back(e);
		}
		ar.push_back(aux);
	}
	std::vector<std::vector<bool> > visited(n, std::vector<bool> (m));
	flood_fill(0, 0, ar, "", visited);

	return 0;
}