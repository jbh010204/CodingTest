#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int main(){
    int N;

    cin >> N;

    vector<int> dp(N+2, 0);

    vector<int> duration(N+2, 0);
    vector<int> money(N+2, 0);

    for(int i=1; i<=N; i++){
        cin >> duration[i] >> money[i];
    }
    

    int tmp;    

    for(int i=1; i<=N; i++){
        dp[i+1] = max(dp[i+1], dp[i]);

        int next = duration[i] + i; // update

        if(next > N+1) continue;
        dp[next] = max(dp[next], dp[i] + money[i]);
    } 

    cout << dp[N+1] << '\n';

    return 0;
}