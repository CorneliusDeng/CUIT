/**********************************最小生成树（普里姆算法）***********************************

#include <iostream>
using namespace std;
#define maxN 100

int main()
{
	int points, edges, min, i;
	int edge[maxN][maxN];
	int dis[maxN];
	int flag[maxN] = { 0 };
	int infinity = 99999999;
	cout << "请输入顶点个数：";
	cin >> points;
	cout << "请输入边的条数：";
	cin >> edges;
	for (int i = 1; i <= points; i++)
	{
		for (int j = 1; j <= points; j++)
		{
			if (i == j)
			{
				edge[i][j] = 0;
			}
			else
			{
				edge[i][j] = infinity;
			}
		}
	}
	int p1, p2, w;
	cout << "请输入无向图的邻接矩阵" << endl;
	for (i = 1; i <= edges; i++)
	{
		cin >> p1 >> p2 >> w;
		edge[p1][p2] = w;
		edge[p2][p1] = w;
	}
	for (i = 1; i <= points; i++)//初始化1号顶点到其它顶点的距离
	{
		dis[i] = edge[1][i];
	}
	flag[1] = 1;
	int count = 1;
	int j;
	int sum = 0;
	while (count < points)
	{
		min = infinity;
		for (i = 1; i <= points; i++)
		{
			if (flag[i] == 0 && dis[i] < min)//每次选择1号顶点到其它顶点的最短距离加入生成树
			{
				min = dis[i];
				j = i;
			}
		}
		flag[j] = 1;
		count++;
		sum += dis[j];
		for (i = 1; i <= points; i++)//选择出的顶点再延伸更新1号顶点到其它顶点的距离
		{
			if (flag[i] == 0 && dis[i] > edge[j][i])
			{
				dis[i] = edge[j][i];//如果满足条件则更新
			}
		}
	}
	cout << "最小生成树的路径权重之和为：" << sum << endl;
}*/

/*
6
9
2 4 11
3 5 13
4 6 3
5 6 4
2 3 6
4 5 7
1 2 1
3 4 9
1 3 2
*/




//#include<vector>  
//#include<string>  
//#include<list>  
//#include<queue> 
//#define MAXWEIGHT 100
//
//struct node   //为了便于prim算法  
//{
//	int vertexNum;
//	int key;
//	node(int num = 0, int k = INT_MAX) :vertexNum(num), key(k) {}
//	friend bool operator<(const node& n1, const node& n2)
//	{
//		return n1.key < n2.key;
//	}
//	friend bool operator>(const node& n1, const node& n2)
//	{
//		return n1.key > n2.key;
//	}
//};
//struct edgeNode
//{
//	int oneVertex;
//	int otherVertex;
//	int edgeWeight;
//	edgeNode(int oneNum = 0, int otherNum = 0, int eWeight = 0) :oneVertex(oneNum), otherVertex(otherNum), edgeWeight(eWeight) {}
//	friend bool operator>(const edgeNode& edge1, const edgeNode& edge2)
//	{
//		return edge1.edgeWeight > edge2.edgeWeight;
//	}
//};
//class UDGraph
//{
//	struct Edge
//	{
//		int nDestVertex;
//		int edgeWeight;
//		Edge(int num, int weight) :
//			nDestVertex(num), edgeWeight(weight) {}
//	};
//private:
//	struct vertex
//	{
//		string vertexName;
//		list<Edge> adjEdges;
//		vertex(const string& name = NULL, list<Edge> adj = list<Edge>()) :vertexName(name), adjEdges(adj) {}
//	};
//public:
//	UDGraph() :m_vertexList(NULL) {}
//	~UDGraph()
//	{
//		for (int i = 0; i < m_vertexList.size(); i++)
//		{
//			m_vertexList[i].adjEdges.clear();
//		}
//		m_vertexList.clear();
//	}
//	bool insertVertex(const string& v)
//	{
//		int index = getVertexIndex(v);
//		if (-1 != index)
//			return false;
//		m_vertexList.push_back(vertex(v));
//	}
//	bool insertEdge(const string& v1, const string& v2, int weight = 0)
//	{
//		int index1 = getVertexIndex(v1);
//		int index2 = getVertexIndex(v2);
//		if (-1 == index1)
//			return false;
//		if (-1 == index2)
//			return false;
//		m_vertexList[index1].adjEdges.push_back(Edge(index2, weight));
//		m_vertexList[index2].adjEdges.push_back(Edge(index1, weight));
//		return true;
//	}
//	int getVertexNum() const
//	{
//		return m_vertexList.size();
//	}
//	bool removeEdge(const string& v1, const string& v2)
//	{
//		int index1 = getVertexIndex(v1);
//		int index2 = getVertexIndex(v2);
//		if (-1 == index1)
//			return false;
//		if (-1 == index2)
//			return false;
//		auto itr1 = m_vertexList[index1].adjEdges.begin();
//		auto itr2 = m_vertexList[index2].adjEdges.begin();
//		bool flag1 = false, flag2 = false;
//		for (; itr1 != m_vertexList[index1].adjEdges.end(); ++itr1)
//		{
//			if (itr1->nDestVertex == index2)
//			{
//				m_vertexList[index1].adjEdges.erase(itr1);
//				flag1 = true;
//				break;
//			}
//		}
//		for (; itr2 != m_vertexList[index2].adjEdges.end(); ++itr2)
//		{
//			if (itr2->nDestVertex == index1)
//			{
//				m_vertexList[index1].adjEdges.erase(itr2);
//				flag2 = true;
//				break;
//			}
//		}
//		return flag1 && flag2;
//	}
//	void Prim(const string& v, vector<int>& prev, vector<node>& node_vec)
//	{
//		priority_queue<node, vector<node>, greater<node> > nodeQueue;
//		node_vec.resize(m_vertexList.size());
//		for (int i = 0; i < node_vec.size(); i++)
//		{
//			node_vec[i].vertexNum = i;
//			node_vec[i].key = INT_MAX;
//		}
//		int beginIndex = getVertexIndex(v);
//		node_vec[beginIndex].key = 0;
//		vector<bool> visited(m_vertexList.size(), false);
//		prev.assign(m_vertexList.size(), -1);
//		visited[beginIndex] = true;
//		nodeQueue.push(node_vec[beginIndex]);
//		while (!nodeQueue.empty())
//		{
//			node vertexNode = nodeQueue.top();
//			nodeQueue.pop();
//			/*if(visited[vertexNode.vertexNum])
//				continue;*/
//			visited[vertexNode.vertexNum] = true;
//			list<Edge> edgeList = m_vertexList[vertexNode.vertexNum].adjEdges;
//			for (auto it = edgeList.begin(); it != edgeList.end(); ++it)
//			{
//				if (!visited[it->nDestVertex] && it->edgeWeight < node_vec[it->nDestVertex].key)
//				{
//					prev[it->nDestVertex] = vertexNode.vertexNum;
//					node_vec[it->nDestVertex].key = it->edgeWeight;
//					node_vec[it->nDestVertex].vertexNum = it->nDestVertex;
//					nodeQueue.push(node_vec[it->nDestVertex]);
//				}
//			}
//		}
//	}
//	void printPathResult(const vector<int>& prev) const
//	{
//		for (int i = 1; i < prev.size(); i++)
//		{
//			cout << "(" << getName(i) << "," << getName(prev[i]) << ")" << endl;
//		}
//	}
//	int PrimWeightResult(const vector<node>& node_vec) const
//	{
//		int edgeSum = 0;
//		for (int i = 0; i < node_vec.size(); i++)
//			edgeSum += node_vec[i].key;
//		return edgeSum;
//	}
//
//	void setTreeNode(const string& name)
//	{
//		treeNode = getVertexIndex(name);
//	}
//private:
//	vector<vertex> m_vertexList;
//	static int counter;  //用来为深度优先搜索时为点排序号  
//	static int treeNodeNum;   //记录根节点的分支个数  
//	static int treeNode;   //记录根节点的编号  
//	int getVertexIndex(const string& name) const
//	{
//		for (int i = 0; i < m_vertexList.size(); i++)
//		{
//			if (name == m_vertexList[i].vertexName)
//				return i;
//		}
//		return -1;
//	}
//	string getName(int index) const
//	{
//		return m_vertexList[index].vertexName;
//	}
//	bool compare(const node& n1, const node& n2)
//	{
//		return n1.key < n2.key;
//	}
//	priority_queue<edgeNode, vector<edgeNode>, greater<edgeNode> > getEdgeNodes() const
//	{
//		priority_queue<edgeNode, vector<edgeNode>, greater<edgeNode> > edgeQueue;
//		vector<int> visit1(m_vertexList.size(), false);
//		vector<int> visit2(m_vertexList.size(), false);
//		for (int index = 0; index < m_vertexList.size(); index++)
//		{
//			list<Edge> adjList = m_vertexList[index].adjEdges;
//			for (auto it = adjList.begin(); it != adjList.end(); ++it)
//			{
//				if (visit1[index] && visit2[it->nDestVertex])
//					continue;
//				else
//				{
//					edgeQueue.push(edgeNode(index, it->nDestVertex, it->edgeWeight));
//				}
//			}
//			visit1[index] = true;
//			visit2[index] = true;
//		}
//		return edgeQueue;
//	}
//	int find(const vector<int>& prev, int x) const
//	{
//		if (prev[x] < 0)
//			return x;
//		else
//			return find(prev, prev[x]);
//	}
//	void unionSets(vector<int>& prev, int root1, int root2)
//	{
//		prev[root1] = root2;
//	}
//
//};
//int UDGraph::counter = 1;
//int UDGraph::treeNodeNum = 0;
//int UDGraph::treeNode = 0;
//int main()
//{
//	UDGraph graph;
//	graph.insertVertex("v1");
//	graph.insertVertex("v2");
//	graph.insertVertex("v3");
//	graph.insertVertex("v4");
//	graph.insertVertex("v5");
//	graph.insertVertex("v6");
//	graph.insertVertex("v7");
//	graph.insertEdge("v1", "v2", 2);
//	graph.insertEdge("v1", "v3", 4);
//	graph.insertEdge("v1", "v4", 1);
//	graph.insertEdge("v2", "v4", 3);
//	graph.insertEdge("v2", "v5", 10);
//	graph.insertEdge("v3", "v6", 5);
//	graph.insertEdge("v3", "v4", 2);
//	graph.insertEdge("v4", "v5", 7);
//	graph.insertEdge("v4", "v6", 8);
//	graph.insertEdge("v4", "v7", 4);
//	graph.insertEdge("v5", "v7", 6);
//	graph.insertEdge("v6", "v7", 1);
//	vector<int> prev;
//	vector<node> node_vec;
//	vector<int> dist;
//	graph.Prim("v1", prev, node_vec);
//	graph.printPathResult(prev);
//	int edgeSum = graph.PrimWeightResult(node_vec);
//	cout << "最小生成树的路径权重之和为：" << edgeSum << endl;
//
//	return 0;
//}

