#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <set>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int T;
    cin >> T;
    set<int> s;
    while(T--){
        int opt,ele;
        cin >>opt>>ele;

        if(opt==1){
            s.insert(ele);
        }
        else if(opt == 2){
            s.erase(ele);
        }else{
            auto it = s.find(ele);
            if(it != s.end()){
                cout << "Yes" << endl;
            }else{
                cout << "No" << endl;
            }
        }

    }   
    return 0;
}



