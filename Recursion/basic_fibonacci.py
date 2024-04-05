def fibonacci(a):
    if(a<=1):
        return a
    else:
        f=fibonacci(a-1)+fibonacci(a-2)
        return f
n=10
if(n<1):
    print("invalid no ")
else:
    for i in range (n):
        print (fibonacci(i))