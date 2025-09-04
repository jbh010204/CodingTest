#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
const int INF = 2000000000;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int T, num;

    cin >> T;
    
    while(T--){
        cin >> num;

        vector<int> files(num);
        vector<int> pre_sum(num+1,0);
        
        for(int i=0; i<num; i++){
            cin >> files[i];
            pre_sum[i+1] = pre_sum[i] + files[i];
        }

        vector<vector<int>> dp(num, vector<int>(num,0));
        vector<vector<int>> opt(num, vector<int>(num,0));

        for(int i=0; i<num; i++){
            opt[i][i] = i;
        }


        for(int len=1; len<num; len++){
            for(int i=0; i+len<num; i++){
                int j = i + len;
                dp[i][j] = INF;

                int sum_val = pre_sum[j+1] - pre_sum[i];
                for(int k = opt[i][j-1]; k<=opt[i+1][j] && k<j; k++){
                    int sum = dp[i][k] + dp[k+1][j] + sum_val;

                    if(sum < dp[i][j]){
                        dp[i][j] = sum;
                        opt[i][j] = k;
                    }
                }
            }
        }

        cout << dp[0][num-1] << '\n';
    }
    
    return 0;
}