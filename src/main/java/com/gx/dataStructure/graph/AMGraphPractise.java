package com.gx.dataStructure.graph;

import com.sun.jmx.remote.internal.ArrayQueue;
import sun.security.krb5.internal.rcache.DflCache;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 邻接矩阵图练习
 */
public class AMGraphPractise{
    public static void main(String[] args) {
        AMGraph amGraph = new AMGraph(9,14);
        amGraph.print();
        AMGraphOperate amGraphOperate = new AMGraphOperate();
        amGraphOperate.initVisited(amGraph);
        System.out.println("深搜：");
        amGraphOperate.DFS(amGraph, 0);
        amGraphOperate.initVisited(amGraph);
        System.out.println("\n广搜：");
        amGraphOperate.BFS(amGraph);
    }
}

/**
 * @Author: gx
 * @Date: Created in 2020/5/5 9:08
 * @Description: 邻接矩阵图操作 - DFS, BFS
 */
class AMGraphOperate{

    public int[] visited;

    /**
     * 初始化已访问数组 visited
     * @param graph
     */
    public void initVisited(AMGraph graph){
        visited = new int[graph.getVexNum()];
        for(int i = 0; i < graph.getVexNum(); i++){
            visited[i] = 0;
        }
    }

    /**
     * 图的深搜
     * @param graph 图
     * @param vexIndex 顶点下标
     */
    public void DFS(AMGraph graph, int vexIndex){
        System.out.print(graph.vexs[vexIndex] + ",");
        visited[vexIndex] = 1;
        for(int j = 0; j < graph.getVexNum(); j++){
            if(graph.arcs[vexIndex][j] == 1 && visited[j] == 0 ){
                // 递归调用下一个顶点，DFS的精髓
                DFS(graph, j);
            }
        }
    }

    /**
     * 图的广搜
     * @param graph 图
     */
    public void BFS(AMGraph graph){
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(graph.getVexNum());
        // 遍历每一个顶点，如果是联通图，则第一个节点就会把所有的顶点都遍历出来了
        for(int i = 0; i < graph.getVexNum(); i++){
            if(visited[i] == 0){
                System.out.print(graph.vexs[i] + ",");
                // 入队列
                queue.add(i);
                visited[i] = 1;
                while(!queue.isEmpty()){
                    // 出队列
                    int k = queue.poll();
                    for(int j =0 ; j < graph.getVexNum(); j++){
                        if(graph.arcs[k][j] == 1 && visited[j] == 0){
                            System.out.print(graph.vexs[j] + ",");
                            queue.add(j);
                            visited[j] = 1;
                        }
                    }
                }
            }
        }
    }
}
