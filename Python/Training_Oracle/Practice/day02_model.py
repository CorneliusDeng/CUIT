def f(n):
    sum = 0
    for i in range(1, n+1):
        temp = 1
        for j in range(1, i+1):
            temp *= j
        sum += 1 / temp
    return sum