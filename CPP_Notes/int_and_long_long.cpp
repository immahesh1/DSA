#include<bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#ifndef ONLINE_JUDGE
	freopen("input1.txt", "r", stdin);
	freopen("output1.txt", "w", stdout);
#endif
	int imax = INT_MAX;
	int imin = INT_MIN;
	long long llmin = LLONG_MIN;
	long long llmax = LLONG_MAX;

	cout << "Int Max: " << imax << endl;
	cout << "Int Min: " << imin << endl;
	cout << "Long Long Max: " << llmax << endl;
	cout << "Long Long Min: " << llmin << endl;
	cout << "Size of int max: " << sizeof(imax) << endl;
	cout << "Size of long long max: " << sizeof(llmax) << endl;

	// Int Max: 2147483647
	// Int Min: -2147483648
	// Long Long Max: 9223372036854775807
	// Long Long Min: -9223372036854775808
	// Size of int max: 4
	// Size of long long max: 8

	return 0;
}

// CHAR_BIT
// SCHAR_MIN
// SCHAR_MAX
// UCHAR_MAX
// CHAR_MIN
// CHAR_MAX
// MB_LEN_MAX
// SHRT_MIN
// SHRT_MAX
// USHRT_MAX
// INT_MIN
// INT_MAX
// UINT_MAX
// LONG_MIN
// LONG_MAX
// ULONG_MAX
// LLONG_MIN
// LLONG_MAX
// ULLONG_MAX
