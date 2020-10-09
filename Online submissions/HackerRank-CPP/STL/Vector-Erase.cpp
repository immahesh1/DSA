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
    //query 1
    int x;
    cin >> x;
    v.erase(v.begin()+x-1);
    //query 2
    int a,b;
    cin >>a>>b;
    v.erase(v.begin()+a-1,v.begin()+b-1);
    cout << v.size()<< endl;
    for(vector<int>::iterator it = v.begin(); it != v.end(); it++){
    	cout << *(it) << " ";
	}
}