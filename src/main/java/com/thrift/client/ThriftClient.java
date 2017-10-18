package com.thrift.client;

import com.alibaba.fastjson.JSON;
import com.thrift.rpc.Operation;
import com.thrift.rpc.input;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by zhi.wang on 2017/10/18.
 */
public class ThriftClient {
    public static void main(String[] args) {
        try {
            TTransport transport = new TSocket("localhost", 8088);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            Operation.Client client = new Operation.Client(protocol);

            input input = new input();
            input.setParam1("100");
            input.setParam2("50");

            System.out.println(JSON.toJSONString(client.add(input)));
            System.out.println(JSON.toJSONString(client.sub(input)));
            System.out.println(JSON.toJSONString(client.divide(input)));
            System.out.println(JSON.toJSONString(client.multiplication(input)));
            System.out.println(JSON.toJSONString(client.alive()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
