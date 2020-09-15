#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
    int n; 
    cin >> n;
    vector<int> v;
    int ele;
    for(int i=0; i<n; i++){
        cin >> ele; 
        v.push_back(ele);
    }
    //sort
    sort(v.begin(),v.end());
    for(auto it:v){
        cout << it << " ";
    }
    return 0;
}
