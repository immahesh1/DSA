#include<bits/stdc++.h>
using namespace std;

void print_arraylist_format(std::vector<int> v) {
	cout << "[";
	for (int i = 0; i < v.size() - 1; i++) {
		cout << v[i] << ", ";
	}
	cout << v[v.size() - 1] << "]";
}

bool isPrime(int n) {
	for (int i = 2; i * i <= n; i++) {
		if (n % i == 0) {
			return false;
			break;
		}
	}
	return true;
}
void filter_prime(std::vector<int> &v) {
	std::vector<int> er(v);
	for (auto i = er.begin(); i != er.end(); i++) {
		if (isPrime(*i) == 1) {
			auto index_to_be_deleted = find(v.begin(), v.end(), *i);
			v.erase(index_to_be_deleted);
		}
	}
}

int main()
{
	int n;
	cin >> n;
	std::vector<int> v;
	for (int i = 0; i < n; i++) {
		int e;
		cin >> e;
		v.push_back(e);
	}
	filter_prime(v);

	print_arraylist_format(v);
	return 0;
}