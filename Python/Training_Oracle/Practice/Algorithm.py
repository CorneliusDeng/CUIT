'''
算法一 ：
有一台机器完成若干个任务，每个任务包含开始时间和结束时间，相关信息保存在jobs.txt文件里
设计一种算法，完成如下目标：这台机器尽可能多的完成任务的个数
'''


# 冒泡排序
def bubble_sort(start, end):
    for i in range(len(end)):
        for j in range(0, len(end) - i - 1):
            # 结束时间和开始时间是一一对应关系，一方变化另一方也要变化
            if end[j] > end[j + 1]:
                end[j], end[j + 1] = end[j + 1], end[j]
                start[j], start[j + 1] = start[j + 1], start[j]


# 算法主体
def find_longest_path(file_path):
    with open(file_path) as lines:
        array = lines.readlines()
        # 获取原始数据，将数据处理为两个list
        list_start, list_end = [], []
        for i in array:
            i.strip("\n")
            list_start.append(int(i.split()[0]))
            list_end.append(int(i.split()[1]))
        # 将两个数组按照end时间排序，end越小可以说明start小 但start小不能确定end小
        bubble_sort(list_start, list_end)
        # 结果集为嵌套列表，数据为当前选中的活动,最开始为第一个活动，因为end最小
        result = [[list_start[0], list_end[0]]]
        for i in range(1, len(list_end)):
            # 当前活动的开始值小于result中最后一个的开始时间就加入结果集
            if list_start[i] >= result[-1][1]:
                result.append([list_start[i], list_end[i]])
        return result


''' 
算法二：
高速公路是一条直线，已经设计好了 N 盏路灯，每盏路灯的位置为a[i] 。为了节约用电，决定拆掉几盏路灯，不影响行车安全。
具体规则是，如果某盏路灯的左右两盏亮着的灯距离不超过 M，就可以把这路灯关闭。其中头尾两盏灯不允许关闭。
为了能够更可能多的节约用电，请设计出一种算法，求出拆掉路灯的最多盏数。
输入格式:
第一行两个整数 N和M，表示电灯的盏数和最大距离 M(6<=M<=10)。
第二行 N个整数，表示每盏灯的位置  。
输出格式:
一个整数，表示最多关掉路灯的数量。
样例输入:
4 5
3 6 10 1 
'''

def close_light(condition, location):
    # 判断数据的合法性
    if int(condition[0]) != len(location) or len(condition) > 2:
        return 0, "wrong data"
    # 取出最大间距
    max_interval = int(condition[1])
    # 将位置信息转换为列表
    for i in range(0, len(location)):
        location[i] = int(location[i])
    # 将位置信息升序排序，成为一个有序集
    location.sort()
    # 定义返回的结果集,初始值为第一盏灯的位置（不允许关闭）
    result = [location[0]]

    # 记录当前的遍历位置,记录需要添加入最后列表的那个数在location的位置
    index = 0
    # 从第二盏开始遍历，直到倒数第二盏灯（第一盏、最后一盏灯不能不能关闭 ）
    for i in range(1, len(location)):
        # 循环跳出条件
        if index >= len(location) - 2:
            break
        # 如果两个间隔位置的距离小于最大距离，则直接加入间隔位置，删除中间的相邻位
        if location[index + 2] - location[index] <= max_interval:
            result.append(location[index + 2])
            index += 2
        # 否则加入中间的相邻位
        else:
            result.append(location[index + 1])
            index += 1
    # 将最后一盏灯加入结果集
    result.append(location[-1])
    return result


if __name__ == '__main__':
    print("算法题1：")
    result = find_longest_path('jobs.txt')
    print("结果集为：", result, "\n可以完成的最大任务数：", len(result))

    condition = input("\n算法题2：\n第一行两个整数 N和M，表示电灯的盏数和最大距离(空格间隔)：").split(" ")
    location = input("N个整数，表示每盏灯的位置(空格间隔)：").split(" ")
    result = close_light(condition, location)
    print("关闭后的灯列表：", result)



'''算法一，教师参考代码'''
import json
def read_txt_file(filename):
    # 保存任务的列表
    jobs_lines = []
    # 读取文件
    with open("jobs_fix.txt") as f:
        for t in f.readlines():
            if t is not None:
                # 去掉每一行的\n，加到列表中
                jobs_lines.append(t.strip("\n"))
    # 去掉开始时间和结束时间相同的任务(保持原有顺序)
    new_job_lines = []
    for t in range(len(jobs_lines)):
        jobs_lines[t] = json.loads(jobs_lines[t])
        equ = False
        for k in range(len(new_job_lines)):
            if jobs_lines[t]['start_time'] == new_job_lines[k]['start_time']:
                if jobs_lines[t]['finish_time'] == new_job_lines[k]['finish_time']:
                    equ = True
        if equ == False:
            new_job_lines.append(jobs_lines[t])
    return new_job_lines


# 排序，按照完成时间的升序排序
# 如果完成时间相同，开始时间晚的排在前面
def sort_tasks(tasks_list):
    for index, task in enumerate(tasks_list):
        for index2, task2 in enumerate(tasks_list):
            if int(tasks_list[index]['finish_time']) < int(tasks_list[index2]['finish_time']):
                tasks_list[index], tasks_list[index2] = tasks_list[index2], tasks_list[index]
            elif int(tasks_list[index]['finish_time']) == int(tasks_list[index2]['finish_time']):
                if int(tasks_list[index]['start_time']) > int(tasks_list[index2]['start_time']):
                    tasks_list[index], tasks_list[index2] = tasks_list[index2], tasks_list[index]
    return tasks_list
# 分配任务
def work(tasks_list):
    work_lists = []
    work_lists.append(tasks_list[0])
    last = 0
    for n in range(1, len(tasks_list)):
        if tasks_list[n]['start_time'] >= work_lists[last]['finish_time']:
            work_lists.append(tasks_list[n])
            last = last + 1
    return work_lists, last + 1
if __name__ == '__main__':
    task_lists = read_txt_file("jobs_fix.txt")
    task_lists = sort_tasks(task_lists)
    work_lists, counts = work(task_lists)
    print("最多完成" + str(counts) + "个任务！")
    print("任务如下：")
    print(work_lists)


'''算法二，教师参考代码'''
def read_txt_file(filename):
    # 保存每栈灯位置的列表
    locations_list = None
    distance = 0
    counts = 0
    index = 0
    with open(filename) as f:
        for t in f.readlines():
            if t is not None:
                if index == 0:
                    counts = t.split(" ")[0]
                    distance = t.split(" ")[1]
                    index = index + 1
                else:
                    locations_list = t.split(" ")

    # 转化为整数
    for index, l in enumerate(locations_list):
        locations_list[index] = int(l)
    print(locations_list)
    # 排序，按照位置从小到大的顺序排序
    locations_list.sort()
    print(locations_list)
    return locations_list, int(distance), int(counts)
# 计算关掉路灯数量
# 遍历对比两盏灯的距离,如果没有超过最大距离，既可以拆掉该盏灯
def close_road_lamp(lamps_lists_location, max_distances,counts):
    closes_counts = 0
    new_lamps_lists_location = []
    last = int(lamps_lists_location[0])
    new_lamps_lists_location.append(last)
    for t in range(1, len(locations_list) - 1):
        if int(locations_list[t + 1]) - last <= max_distances:
            closes_counts = closes_counts + 1
        else:
            last = locations_list[t]
            new_lamps_lists_location.append(last)
    return closes_counts, new_lamps_lists_location
if __name__ == '__main__':
    locations_list, distance, counts = read_txt_file("02.txt")
    closes_counts, lamps_lists_location = close_road_lamp(locations_list, distance,counts)
    print(closes_counts)
    # 加载最后的路灯
    lamps_lists_location.append(locations_list[counts-1])
    print(lamps_lists_location)