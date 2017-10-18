package com.thrift.client;

import com.alibaba.fastjson.JSON;
import com.thrift.rpc.Operation;
import com.thrift.rpc.input;
import com.thrift.rpc.output;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;

/**
 * Created by zhi.wang on 2017/10/18.
 */
public class AsyncThriftClient {
    public static void main(String[] args) {
        try {
            TNonblockingTransport transport = new TNonblockingSocket("localhost", 8088);
            TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
            TAsyncClientManager asyncClientManager = new TAsyncClientManager();
            Operation.AsyncClient client = new Operation.AsyncClient(factory, asyncClientManager, transport);
            System.out.println("Client calls .....");

            input input = new input();
            input.setParam1("100");
            input.setParam2("50");

            client.add(input, new AsyncMethodCallback<output>() {
                @Override
                public void onComplete(output response) {
                    System.out.println(JSON.toJSONString(response));
                }

                @Override
                public void onError(Exception exception) {
                    exception.printStackTrace();
                }
            });

            client.sub(input, new AsyncMethodCallback<output>() {
                @Override
                public void onComplete(output response) {
                    System.out.println(JSON.toJSONString(response));
                }

                @Override
                public void onError(Exception exception) {
                    exception.printStackTrace();
                }
            });


            client.divide(input, new AsyncMethodCallback<output>() {
                @Override
                public void onComplete(output response) {
                    System.out.println(JSON.toJSONString(response));
                }

                @Override
                public void onError(Exception exception) {
                    exception.printStackTrace();
                }
            });


            client.multiplication(input, new AsyncMethodCallback<output>() {
                @Override
                public void onComplete(output response) {
                    System.out.println(JSON.toJSONString(response));
                }

                @Override
                public void onError(Exception exception) {
                    exception.printStackTrace();
                }
            });

            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
