package com.yl.test;

import org.apache.tuscany.sca.node.Node;
import org.apache.tuscany.sca.node.NodeFactory;

public class TestTus {
    public static void main(String[] args) {
        Node node = NodeFactory.newInstance().createNode("service.composite");
        node.start();
        System.out.println("服务端2启动");
    }
}
