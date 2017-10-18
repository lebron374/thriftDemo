package com.thrift.server;

import com.thrift.rpc.Operation;
import com.thrift.impl.OperationImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportFactory;

/**
 * Created by zhi.wang on 2017/10/18.
 */
public class DemoTSimpleServer {
    public static void main(String[] args) {
        TServer server = null;
        try {
            TServerSocket serverSocket = new TServerSocket(8088);
            TProcessor processor = new Operation.Processor(new OperationImpl());
            TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
            TTransportFactory transportFactory = new TTransportFactory();
            server = new TThreadPoolServer(new TThreadPoolServer.Args(serverSocket).processor(processor).transportFactory(transportFactory).protocolFactory(factory));
            System.out.println("Start server on port 8088...");
            server.serve();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            server.stop();
        }
    }
}
