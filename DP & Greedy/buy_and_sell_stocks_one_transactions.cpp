#include<bits/stdc++.h>
using namespace std;

int main()
{
	int n; cin >> n;
	int prices[n];
	for (int i = 0; i < n; i++) {
		cin >> prices[i];
	}

	int least_price = INT_MAX;
	int profit_if_sold_today = 0;
	int overall_profit = INT_MIN;

	for (int i = 0; i < sizeof(prices) / sizeof(prices[0]); i++) {
		if (prices[i] < least_price) {
			least_price = prices[i];
		}
		profit_if_sold_today = prices[i] - least_price;
		if (profit_if_sold_today > overall_profit) {
			overall_profit = profit_if_sold_today;
		}
	}

	cout << overall_profit;
	return 0;
}