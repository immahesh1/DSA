#include<bits/stdc++.h>
using namespace std;

class student{
public:
	string name;
	int age;

	student(string name,int age){
		this -> name = name;
		this -> age = age;
	}
};

class studentCompare{
public:
	bool operator()(const student& a,const student& b){
		if(a.age > b.age){
			return true;
		}
		return false;
	}
};

int main(){
	#ifndef ONLINE_JUDGE
		//for getting input from input1.txt
		freopen("input1.txt","r",stdin);
		//for writing output to output1.txt
		freopen("output.txt","w",stdout);
	#endif

	student s1("ABC", 2);
	student s2("Rupu", 16);
	student s3("Mahesh", 24);
	student s4("Rudra", 15);

	list<student> sl;
	sl.push_back(s1);
	sl.push_back(s2);
	sl.push_back(s3);
	sl.push_back(s4);

	studentCompare cmp;

	sl.sort(cmp);

	for(auto s:sl){
		cout << "Name: " << s.name << " Age: " << s.age << endl;
	}

}