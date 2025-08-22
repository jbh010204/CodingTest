#include <iostream>

using namespace std;

int main(){
    int ct;
    cin >> ct;
    while(ct > 0){
        for(int i=0; i<ct; i++){
            cout << "*";
        }
        cout << endl;
        ct--;
    }

    return 0;
}
