package org.designmode.behavior.chain.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mu_qingfeng
 * @date 2022/3/14 9:13 PM
 */
public class ServerletMain {

    public static void main(String[] args) {
        Request request = new Request();
        request.req = "你好，沐清风！！！";

        Response response = new Response();
        response.res = " <alert>Welcom to baidu";

        FilterChain chain = new FilterChain();
        chain.add(new EnglishiFilter()).add(new HTMLFilter());


        chain.filter(request,response, chain);

        System.out.println(request.req);
        System.out.println(response.res);

//        System.out.println(msg);

    }

}

class FilterChain implements Filter{

    List<Filter> filterList = new ArrayList<>();

    int index = 0;

    public FilterChain add(Filter filter){
        filterList.add(filter);
        return this;
    }

    @Override
    public void filter(Request request, Response response, FilterChain chain) {
        if(index == filterList.size()){
            return;
        }
        Filter f = filterList.get(index);
        index++;
        f.filter(request, response, chain);
//        for(Filter f : filterList){
//            f.filter(request, response, chain);
//        }
    }
}

class EnglishiFilter implements Filter{

    @Override
    public void filter(Request request, Response response, FilterChain chain){
        request.req =request.req.replace("baidu","http://wwww.baidu.com");
        chain.filter(request,response,chain);
        response.res += "---- EnglishiFilter";
    }
}

class HTMLFilter implements Filter{

    @Override
    public void filter(Request request, Response response, FilterChain chain){
        request.req = request.req.replace("<","[").replace(">","]");
        chain.filter(request,response,chain);
        response.res += "---- HTMLFilter";
    }
}


interface Filter{
    void filter(Request request, Response response, FilterChain chain);
}

class Request{
    String req;
}

class Response{
    String res;
}

class Msg{
    String name;

    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
