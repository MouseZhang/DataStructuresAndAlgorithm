package CH03;
/**
 * 队列类
 * @author MouseZhang
 *
 */
public class MyQueue {
	//底层使用数组
	private long[] arr;
	//有效数据的大小
	private int elements;
	//队头
	private int front;
	//队尾
	private int end;
	
	/**
	 * 默认构造方法
	 */
	public MyQueue() {
		arr = new long[10];
		elements = 0;
		front = 0;
		end = -1;
	}
	
	/**
	 * 带参数的构造方法，参数为数组的大小
	 * @param maxSize
	 */
	public MyQueue(int maxSize) {
		arr = new long[maxSize];
		elements = 0;
		front = 0;
		end = -1;
	}
	
	/**
	 * 添加数据，从队尾插入
	 * @param value
	 */
	public void insert(long value) {
		arr[++end] = value;
		elements++;
	}
	
	/**
	 * 删除数据，从队头删除
	 * @return
	 */
	public long remove() {
		elements--;
		return arr[front++];
	}
	
	/**
	 * 查看数据，从队头查看
	 * @return
	 */
	public long peek() {
		return arr[front];
	}
	
	/**
	 * 判断是否为空
	 * @return
	 */
	public boolean isEmpty() {
		return elements == 0;
	}
	
	/**
	 * 判断是否队满
	 * @return
	 */
	public boolean isFull() {
		return elements == arr.length;
	}

}
