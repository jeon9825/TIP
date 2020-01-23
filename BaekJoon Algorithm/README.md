https://www.acmicpc.net/

* Scanner 에서 next()와 nextLine()의 차이점      

String	nextLine()      
Advances this scanner past the current line and returns the input that was skipped.             

String	next()          
Finds and returns the next complete token from this scanner.            

* next()	공백을 만나면 종료(공백 단위)       
* nextLine()	/n(개행-엔터)를 만나면 종료         
next()와 달리 띄어쓰기 가능(엔터 단위)      


* 유클리드 호제법 - 최대 공약수
두 양의 정수 aa, bb (a>b)(a>b)에 대하여 a=bq+r\,\left(0\leq r<a\right)a=bq+r(0≤r<a)라 하면, aa, bb의 최대공약수는 bb, rr의 최대공약수와 같다.   
즉, \gcd\left(a,\ b\right)=\gcd\left(b,\ r\right)gcd(a, b)=gcd(b, r).   
* 공약수 = 최대공약수의 약수