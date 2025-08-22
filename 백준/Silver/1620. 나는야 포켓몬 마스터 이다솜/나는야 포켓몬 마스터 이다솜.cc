#include <iostream>
#include <vector>
#include <cctype>
#include <algorithm>
#include <map>

using namespace std;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int num, problems;
    string pocketmon;
    string t;


    cin >> num >> problems;
    unordered_map<string,int> nameToNum;
    unordered_map<int, string> NumToName;

    for(int i=1; i<=num; i++){
        cin >> t;
        nameToNum[t] = i;
        NumToName[i] = t; 
    }

    for(int i=0; i<problems; i++){
        cin >> t;
        
        if(isdigit(t[0])){ // 숫자 -> 문자
            cout << NumToName[stoi(t)] << '\n';
        }
        else{ //숫자
            cout << nameToNum[t] << '\n';
        }
        
    }

    return 0;
}