package com.thrift.impl;

import com.thrift.rpc.Operation;
import com.thrift.rpc.ResultEnum;
import com.thrift.rpc.input;
import com.thrift.rpc.output;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;

/**
 * Created by zhi.wang on 2017/10/18.
 */
public class AsyncOperationImpl implements Operation.AsyncIface {
    @Override
    public void add(input param, AsyncMethodCallback<output> resultHandler) throws TException {
        output ret = new output();
        ret.setResult(ResultEnum.SUCCESS);
        ret.setMessage(String.valueOf(Integer.valueOf(param.getParam1()) + Integer.valueOf(param.getParam2())));

        resultHandler.onComplete(ret);
    }

    @Override
    public void sub(input param, AsyncMethodCallback<output> resultHandler) throws TException {
        output ret = new output();
        ret.setResult(ResultEnum.SUCCESS);
        ret.setMessage(String.valueOf(Integer.valueOf(param.getParam1()) - Integer.valueOf(param.getParam2())));

        resultHandler.onComplete(ret);
    }

    @Override
    public void alive(AsyncMethodCallback<output> resultHandler) throws TException {
        output ret = new output();
        ret.setResult(ResultEnum.SUCCESS);
        ret.setMessage("alive");

        resultHandler.onComplete(ret);
    }

    @Override
    public void divide(input param, AsyncMethodCallback<output> resultHandler) throws TException {
        output ret = new output();
        ret.setResult(ResultEnum.SUCCESS);
        ret.setMessage(String.valueOf(Integer.valueOf(param.getParam1()) / Integer.valueOf(param.getParam2())));

        resultHandler.onComplete(ret);
    }

    @Override
    public void multiplication(input param, AsyncMethodCallback<output> resultHandler) throws TException {
        output ret = new output();
        ret.setResult(ResultEnum.SUCCESS);
        ret.setMessage(String.valueOf(Integer.valueOf(param.getParam1()) * Integer.valueOf(param.getParam2())));

        resultHandler.onComplete(ret);
    }
}
