def Bubble_Sort(array):
    for i in range(1, len(array)):
        for j in range(0, len(array) - i):
            if array[j] > array[j + 1]:
                array[j], array[j + 1] = array[j + 1], array[j]
    return array

if __name__ == '__main__':
    array = [1, 985, 820, 301, 101, 75, 120, 139, 100]
    print(Bubble_Sort(array))
