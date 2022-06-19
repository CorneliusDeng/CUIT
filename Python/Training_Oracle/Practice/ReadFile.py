# import json
#
# def readTxt(filename):
#     # Save all jobs into list
#     job_files = []
#     # read text file
#     with open(filename) as lines:
#         # a list is returned
#         array = lines.readlines()
#         # read the first line of content, i.e. machine list information
#         machines_list = json.loads(array[0].strip("\n"))
#         # read other contents, i.e. task list information
#         array = array[1:]
#         # traverse each element in the array
#         for task in array:
#             # remove line breaks '\n'
#             task = task.strip('\n')
#             # convert string to JSON and append into the list
#             job_files.append(json.loads(task))
#     return machines_list, job_files
#
#
# if __name__ == '__main__':
#     infros=readTxt("jobs.txt")
#     print(infros[0])
#     print(infros[1])

# if __name__ == '__main__':
#     with open("jobs.txt") as lines:
#         arrays = lines.readlines()
#         for i in arrays:
#             i = i.strip("\n")
#             print(i)

# if __name__ == '__main__':
#     with open("jobs.txt") as lines:
#         arrays = eval(lines.readline())
#         list_machines = arrays.get("machines_list")
#         print("机器数量：", len(list_machines))

if __name__ == '__main__':
    with open("jobs_machine.txt") as lines:
        arrays = lines.readlines()
        for i in range(0, len(arrays)):
            arrays[i] = eval(arrays[i])
        line = arrays[0]
        arrays.remove(line)
        arrays.sort(key= lambda x: x["finish_time"], reverse=True)
        print(line)
        print("按耗时排序：")
        for i in arrays:
            print(i)

