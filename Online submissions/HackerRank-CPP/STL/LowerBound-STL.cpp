// lower_boudn() in cpp: function returns the index of the next smallest number just greater than or equal to that number.

#include<bits/stdc++.h>
using namespace std;


int main()
{
    int n;
    cin >> n;
    std::vector<int> v;
    int ele;
    for (int i = 0; i < n; ++i) {
        cin >> ele;
        v.push_back(ele);
    }

    //Q queries
    int q;
    cin >> q;
    while (q--) {
        int inp;
        cin >> inp;

        vector<int>::iterator low1 = lower_bound(v.begin(), v.end(), inp);
        if (v[(low1 - v.begin())] == inp)
            cout << "Yes " << (low1 - v.begin()) + 1 << endl;
        else
            cout << "No " << (low1 - v.begin()) + 1 << endl;

    }
    return 0;
}