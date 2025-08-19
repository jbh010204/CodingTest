//백준 14888번(연산자 끼워넣기)

#include <iostream>
#include <algorithm>
#include <iterator>
#include <vector>
#include <string>
#include <cstring>
#include <queue>
#include <list>
#include <set>
#include <stack>
#include <deque>
#include <tuple>
#include <sstream>
#include <cmath>
#define DEBUG 0 //제출 시 0
#define endl    '\n'
#define INF 987654321
#define SHARING 100001

using namespace std;

int dirY[] = { -1, 0, 1, 0 };
int dirX[] = { 0, 1, 0, -1 };
int n, num, allcase;
int ct = 0; int aa=0;
int maxn = -1000000001; int minn = 1000000001;
int sum = 0;
vector<int> v1; //숫자 저장하는 벡터
vector<int> oper; //+ - * %
vector<int> temp; //연산자순열 저장하는 벡터
//main function

int factorial(int num) {
    if (num <= 1) {
        return 1;
    }
    return num* factorial(num - 1);
}

void cal_oper(int index) {
  
 
        if (ct == n - 1) {
            for (int i = 0; i < temp.size(); i++) {
                if (!i) {
                    sum = v1[i];
                }

                if (temp[i] == 0) {
                    sum += v1[i + 1];
                }
                else if (temp[i] == 1) {
                    sum -= v1[i + 1];
                }
                else if (temp[i] == 2) {
                    sum *= v1[i + 1];
                }
                else {
                    sum /= v1[i + 1];
                }
            }
            if (sum > maxn) {
                maxn = sum;
            }
            if (sum < minn) {
                minn = sum;
            }

            aa++;
            return;
        }

 
        for (int i = 0; i < 4; i++) {
            if (oper[i] != 0) {
  
                oper[i]--;
                ct++;
                temp.push_back(i);
               
                cal_oper(i);
                oper[i]++;
                temp.pop_back();
                ct--;
            }
        }
     
  
}

int main() {
    ios::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    
    cin >> n;
    
    for (int i = 0; i < n; i++) {
        cin >> num;
        v1.push_back(num);
    }

    for (int i = 0; i < 4; i++) {
        cin >> num;
        oper.push_back(num);
    }

    if (DEBUG) {
        allcase = factorial(n - 1);
        for (int i = 0; i < 4; i++) {
            if (oper[i] > 1) {
                allcase /= oper[i];
            }
        }
        cout << allcase << endl;
        cout << aa << endl;
    }
   
    cal_oper(0);
    cout << maxn << endl;
    cout << minn << endl;
    return 0;
}