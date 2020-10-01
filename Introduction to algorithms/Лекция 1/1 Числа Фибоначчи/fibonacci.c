#include <stdio.h>

int fibRecursive(int n){
    if(n == 0){
        return 0;
    }
    if(n == 1){
        return 1;
    }
    return fibRecursive(n - 1) + fibRecursive(n - 2);
}

int fibIterative(int n){
    int f = 0;
    int s = 1;
    int t;
    for(int i = 0; i < n; i++){
        t = f + s;
        f = s;
        s = t;
    }
    return f;
}

int main(){
    int n = 5;
    printf("%d\n", fibRecursive(n));
    printf("%d", fibIterative(n));
}