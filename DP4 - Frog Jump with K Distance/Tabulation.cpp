#include<bits/stdc++.h>

using namespace std;

int main() {
    int n;
    int k;
    cin >> n >> k;

    int height[n];

    for(int i = 0; i < n; i++) {
        cin >> height[i];
    }

    int dp[n];

    dp[0] = 0;

    for(int i = 1; i < n; i++) {

        int ans = INT_MAX;

        for(int j=1; j<=k; j++) {
            if(i-j >=  0) {
                ans = min(ans, dp[i-j] + abs(height[i] - height[i-j]));
            }
        }
        
        dp[i] = ans;
    }

    cout << dp[n-1] << endl;
}