学习笔记:
1. 注意审题。
2. 空间换时间。
3. 多撸。
4. TODO list：
    - https://leetcode-cn.com/problems/maximum-subarray/ 最大子序和，动态规划，分治。
    - https://leetcode-cn.com/problems/trapping-rain-water/ 接雨水，动态规划，栈。
5. Queue：
    - FIFO
    - 有消息等待消费，排队。
    - 添加元素返回值boolean：
        - add，如果已满抛出IllegalStateException异常；
        - offer，不会抛异常。
    - 返回并移除首元素：
        - remove，为空抛出NoSuchElementException异常；
        - poll，为空仅仅返回null而不抛异常。
    - 返回但不移除首元素：
        - element，为空抛出NoSuchElementException异常；
        - peek，为空仅仅返回null而不抛异常。
6. PriorityQueue：
    - FIFO，但有优先级，默认自然优先级，或自定义comparator。
    - 通过二叉小顶堆？？？实现。
    - boolean add(E e) 和 boolean offer(E e)：
        - 向队列插入元素，add，如果已满抛出IllegalStateException异常；offer，不会抛异常。
        - 新插入元素会破坏小顶堆的特性，void siftUp(int k, E x)方法用来维持此特性？？？。
        - 调整的过程为：从k指定的位置开始，将元素x逐层与当前点的parent进行比较并交换，直到满足x >= queue[parent]为止。
    - E element() 和 E peek()：
        - 获取但不删除队首元素，失败element()抛出NoSuchElementException异常，peek()返回null。
        - 根据小顶堆的性质，堆顶元素最小，所以直接返回数组0下标处的那个元素即可。
    - E remove() 和 E poll()：
        - 获取并删除队首元素，失败remove()抛出NoSuchElementException异常，poll()返回null。
        - 由于删除操作会改变队列的结构，为维护小顶堆的性质，需要进行必要的调整。
        - 首先记录0下标元素，然后用队尾元素替换队首，再用void siftWown(int k, E x)对堆进行调整。
        - 调整的过程为：从k指定的位置开始，将x逐层向下与当前点的左右孩子中较小的那个交换，直到x小于或等于左右孩子中的任何一个为止。
    - boolean remove(Object o)：
        - 用于删除队列中跟o相等的某一个元素（如果有多个相等，只删除一个），该方法是Collection接口定义的方法。
        - 遍历数组找到第一个o.equals(queue[i])元素的下标。
        - 由于删除元素的位置可能是任意的，所以调整过程比其它函数稍加繁琐。
        - 两种情况：
            - 删除队尾元素，直接删除即可。
            - 非队尾元素，在被删除元素的位置调用void siftWown(int k, E x)对堆进行调整。

7. 在后面的课程涉及到heap之后复习Queue和PriorityQueue的内容。