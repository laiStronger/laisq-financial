package com;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;

/**
 *黄金数据调用示例代码 － 聚合数据
 *在线接口文档：http://www.juhe.cn/docs/29
 **/

public class GoldFinancial {

    //配置您申请的KEY
    public static final String APPKEY ="b562193a50e03ebd519d6213f98ef899";

    public static void main(String[] args) {
        getRequest3();
    }

    //1.上海黄金交易所
    public static void getRequest1(){
        String result =null;
        String url ="http://web.juhe.cn:8080/finance/gold/shgold";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key",APPKEY);//APP Key
        params.put("v","");//JSON格式版本(0或1)默认为0

        try {
            result =Utils.net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //2.上海期货交易所
    public static void getRequest2(){
        String result =null;
        String url ="http://web.juhe.cn:8080/finance/gold/shfuture";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key",APPKEY);//APP Key
        params.put("v","");//JSON格式版本(0或1)默认为0

        try {
            result =Utils.net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //3.银行账户黄金
    public static void getRequest3(){
        String result =null;
        String url ="http://web.juhe.cn:8080/finance/gold/bankgold";//请求接口地址
        Map params = new HashMap();//请求参数
        params.put("key",APPKEY);//APP Key

        try {
            result =Utils.net(url, params, "GET");
            JSONObject object = JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
                System.out.println(object.get("result"));
            }else{
                System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}