#include<bits/stdc++.h>

using namespace std;

int main() {
    int n;
    cin >> n;

    int points[n][3] ;
    int prev[4] ;

    for(int i=0; i<n; i++) {
        for(int j=0; j<=2; j++) {
            cin >> points[i][j];
        }
    } 

    prev[0] = max(points[0][1] , points[0][2]);
    prev[1] = max(points[0][0] , points[0][2]);
    prev[2] = max(points[0][0] , points[0][1]);
    prev[3] = max ( max(points[0][0] , points[0][1]) , points[0][2] );

    for(int day = 1; day <n; day++) {
        int curr[4];
        for(int last = 0; last<4; last++) {
            curr[last] = 0;
            for(int task = 0; task<=2; task++) {
                if(task != last) {
                    curr[last] = max(curr[last] , prev[task] + points[day][task]);
                }
            }
        }

        for(int i = 0; i < 4; i++) {
            prev[i] = curr[i];
        }
    }

    cout << prev[3] << endl; 
}