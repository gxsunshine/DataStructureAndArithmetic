package com.gx.dataStructure.graph;

import java.util.Scanner;

/**
 * @Author: gx
 * @Date: Created in 2020/5/4 23:45
 * @Description: 邻接矩阵图结构
 */
public class AMGraph {
    private int vexNum;
    private int arcNum;
    public char[] vexs;
    public int[][] arcs;

    public AMGraph(int vexNum, int arcNum) {
        this.vexNum = vexNum;
        this.arcNum = arcNum;
        init();
    }

    /**
     * 初始化顶点表和邻接矩阵
     */
    public void init(){
        vexs = new char[vexNum];
        arcs = new int[vexNum][vexNum];
        for(int i=0; i < vexNum; i++){
            for(int j=0; j < vexNum; j++){
                arcs[i][j] = 0;
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入顶点：");
        for(int i=0; i < vexNum; i++){
            vexs[i] =  scan.nextLine().charAt(0);
        }
        System.out.println("请输入边：");
        int i,j;
        for(int k=0; k < arcNum; k++){
            i = scan.nextInt();
            j = scan.nextInt();
            // 无向图
            arcs[i][j] = arcs[j][i] = 1;
        }
    }

    /**
     * 打印顶点表和邻接矩阵
     */
    public void print(){
        System.out.println("顶点表数据为：");
        for(int i=0; i < vexNum - 1 ; i++){
            System.out.print(vexs[i] + ",");
        }
        System.out.println(vexs[vexNum-1]);
        System.out.println("邻接矩阵数据为：");
        for(int i=0; i < vexNum; i++){
            for(int j=0; j < vexNum - 1; j++){
                System.out.print(arcs[i][j] + ",");
            }
            System.out.println(arcs[i][vexNum-1]);
        }
    }

    public int getVexNum() {
        return vexNum;
    }

    public int getArcNum() {
        return arcNum;
    }

}
