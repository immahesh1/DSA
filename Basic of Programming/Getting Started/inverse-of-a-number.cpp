#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n;
	cin >> n;

	int n2 = n;
	int asize = 0;
	while (n2 != 0) {
		n2 = n2 / 10;
		asize++;
	}

	pair<int, int> p[asize];
	int pos = 1;
	for (int i = 0; i < asize; i++) {
		p[i].first = pos;
		p[i].second = n % 10;
		n = n / 10;
		pos++;

		//step 2. in between swap
		swap(p[i].first, p[i].second);
	}

	//step 3. sort
	sort(p, p + asize);

	for (int i = asize - 1; i >= 0; i--) {
		cout << p[i].second;
	}


	return 0;
}