package com.thrift.server;

import com.thrift.impl.OperationImpl;
import com.thrift.rpc.Operation;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;

/**
 * Created by zhi.wang on 2017/10/18.
 */
public class DemoTNonblockingServer {
    public static void main(String[] args) {
        TServer server = null;

        try {
            TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(8088);
            TProcessor processor = new Operation.Processor<Operation.Iface>(new OperationImpl());
            TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
            server = new TNonblockingServer(new TNonblockingServer.Args(serverSocket).processor(processor).protocolFactory(factory));
            System.out.println("Start server on port 8088...");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }
}
