def twosplit(sourceDate,findData):
    left = 0
    right = len(sourceDate)
    if findData not in (sourceDate):
        print("can't find data {0}".format(findData))
        exit(0)
    while left <= right:
        mid = int((left + right) / 2)
        if sourceDate[mid] == findData:
            print("find data: {0}".format(findData))
            exit(0)
        for i,ch in enumerate(sourceDate):
            if ch == findData:
                if i < mid:
                    right = mid - 1
                    print("Data in left {0}".format(sourceDate[left:right+1]))
                elif i > mid:
                    left = mid + 1
                    print("Data in right {0}".format(sourceDate[left:right+1]))
data = [1,2,'c',3,4,5,6,7,8,17,26,15,14,13,12,11,'a','b']
find = input()
twosplit(data,find)
