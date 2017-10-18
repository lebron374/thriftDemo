package com.thrift.impl;

import com.thrift.rpc.Operation;
import com.thrift.rpc.ResultEnum;
import com.thrift.rpc.input;
import com.thrift.rpc.output;
import org.apache.thrift.TException;

/**
 * Created by zhi.wang on 2017/10/18.
 */
public class OperationImpl implements Operation.Iface {
    @Override
    public output add(input param) throws TException {
        output ret = new output();
        ret.setResult(ResultEnum.SUCCESS);
        ret.setMessage(String.valueOf(Integer.valueOf(param.getParam1()) + Integer.valueOf(param.getParam2())));

        return  ret;
    }

    @Override
    public output sub(input param) throws TException {
        output ret = new output();
        ret.setResult(ResultEnum.SUCCESS);
        ret.setMessage(String.valueOf(Integer.valueOf(param.getParam1()) - Integer.valueOf(param.getParam2())));

        return  ret;
    }

    @Override
    public output alive() throws TException {
        output ret = new output();
        ret.setResult(ResultEnum.SUCCESS);
        ret.setMessage("alive");

        return  ret;
    }

    @Override
    public output divide(input param) throws TException {
        output ret = new output();
        ret.setResult(ResultEnum.SUCCESS);
        ret.setMessage(String.valueOf(Integer.valueOf(param.getParam1()) / Integer.valueOf(param.getParam2())));

        return  ret;
    }

    @Override
    public output multiplication(input param) throws TException {
        output ret = new output();
        ret.setResult(ResultEnum.SUCCESS);
        ret.setMessage(String.valueOf(Integer.valueOf(param.getParam1()) * Integer.valueOf(param.getParam2())));

        return  ret;
    }
}
