#include<bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;

    int points[n][3] ;
    int dp[n][4] ;

    for(int i=0; i<n; i++) {
        for(int j=0; j<=2; j++) {
            cin >> points[i][j];
        }
    } 

    dp[0][0] = max(points[0][1] , points[0][2]);
    dp[0][1] = max(points[0][0] , points[0][2]);
    dp[0][2] = max(points[0][0] , points[0][1]);
    dp[0][3] = max ( max(points[0][0] , points[0][1]) , points[0][2] );

    for(int day = 1; day <n; day++) {
        for(int last = 0; last<4; last++) {
            dp[day][last] = 0;
            for(int task = 0; task<=2; task++) {
                if(task != last) {
                    dp[day][last] = max(dp[day][last] , dp[day-1][task] + points[day][task]);
                }
            }
        }
    }

    cout << dp[n-1][3] << endl; 
}