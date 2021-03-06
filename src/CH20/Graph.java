package CH20;
import CH03.MyStack;
import CH03.MyQueue;
/**
 * 图
 * @author MouseZhang
 *
 */
public class Graph {
	//顶点数组
	private Vertex[] vertexList;
	//邻接矩阵 
	private int[][] adjMat;
	//顶点的最大数目
	private int maxSize = 20;
	//当前顶点
	private int nVertex;
	//栈
	private MyStack stack;
	//队列
	private MyQueue queue;
	
	public Graph() {
		vertexList = new Vertex[maxSize];
		adjMat = new int[maxSize][maxSize];
		for (int i = 0; i < maxSize; i++) {
			for (int j = 0; j < maxSize; j++) {
				adjMat[i][j] = 0;
			}
		}
		nVertex = 0;
		stack = new MyStack();
		queue = new MyQueue();
	}
	
	/**
	 * 添加顶点
	 */ 
	public void addVertex(char label) {
		vertexList[nVertex++] = new Vertex(label);
	}
	
	/**
	 * 添加边
	 */
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	public int getadjUnvisitedVertex(int v) {
		for (int i = 0; i < nVertex; i++) {
			if (adjMat[v][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 深度优先搜索
	 */
	public void dfs() {
		//首先访问0号顶点
		vertexList[0].wasVisited = true;
		//显示该顶点
		displayVertex(0);
		//压入栈中
		stack.push(0);
		while (!stack.isEmpty()) {
			//获得一个未访问过的邻接点
			int v = getadjUnvisitedVertex((int)stack.peek());
			if (v == -1) {
				//弹出一个顶点
				stack.pop();
			}
			else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				stack.push(v);
			}
		}
		//搜索完以后，要将访问信息修改
		for (int i = 0; i < nVertex; i++) {
			vertexList[i].wasVisited = false;
		}
	}
	
	/**
	 * 广度优先搜索
	 */
	public void bfs() {
		//首先访问0号顶点
		vertexList[0].wasVisited = true;
		//显示该顶点
		displayVertex(0);
		//插入队列中
		queue.insert(0);
		while (!queue.isEmpty()) {
			//获得一个未访问过的邻接点
			int v = getadjUnvisitedVertex((int)queue.peek());
			if (v == -1) {
				//删除一个顶点
				queue.remove();
			}
			else {
				vertexList[v].wasVisited = true;
				displayVertex(v);
				queue.insert(v);
			}
		}
		//搜索完以后，要将访问信息修改
		for (int i = 0; i < nVertex; i++) {
			vertexList[i].wasVisited = false;
		}
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
	
	/**
	 * 最小生成树
	 */
	public void mst() {
		//首先访问0号顶点
		vertexList[0].wasVisited = true;
		//压入栈中
		stack.push(0);
		while (!stack.isEmpty()) {
			//当前顶点
			int currentVertex = (int)stack.peek();
			//获得一个未访问过的邻接点
			int v = getadjUnvisitedVertex(currentVertex);
			if (v == -1) {
				//弹出一个顶点
				stack.pop();
			}
			else {
				vertexList[v].wasVisited = true;
				stack.push(v);
				displayVertex(currentVertex);
				System.out.print("-");
				displayVertex(v);
				System.out.print(" ");
			}
		}
		//搜索完以后要将访问信息修改
		for (int i = 0; i < nVertex; i++) {
			vertexList[i].wasVisited = false;
		}
	}
}
