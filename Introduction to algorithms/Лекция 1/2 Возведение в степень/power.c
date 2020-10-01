#include <stdio.h>

int pow(int a, int n){
    int b = 1;
    for(int i = 0; i < n; i++){
        b = b * a;
    }
    return b;
}

int fastIterativePow(int a, int n){
    int c = a;
    int b = 1;
    while(n != 0) {
        if (n % 2 == 0) {
            c = c * c;
            n = n / 2;
        } else {
            b = b * c;
            n = n - 1;
        }
    }
    return b;
}

int fastRecursivePow(int a, int b, int n){
    if(n == 0){
        return b;
    }
    if(n % 2 == 0){
        fastRecursivePow(a * a, b, n / 2);
    }else{
        fastRecursivePow(a, b * a, n - 1);
    }
}

// a^(n) = {n=2*k} = a^(2*k)= {k=2*l} = a^(2*2*l) = {l=s+1} = a^(2*2*(s+1)) =
// = a^[(2*2*s)+(2*2)] = a^(2*2*s) * a^(2*2)
// Когда степень нечетная (когда вычитаем единицу), то мы умножаем на a в степени
// произведения двоек, которые накопились, когда мы делили четную степень на 2
// То есть n уменьшается и параллельно расписывается a^n


int main(){
    int a = 2;
    int n = 5;
    printf("%d\n", pow(2, 5));
    printf("%d\n", fastIterativePow(2, 5));
    printf("%d\n", fastRecursivePow(2, 1, 5));
}