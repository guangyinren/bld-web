package io.renren.common.utils;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;


public class AlipayUtils {

    public static void webPay(String orderId,BigDecimal amount,String subject,HttpServletRequest httpRequest,HttpServletResponse httpResponse){
        String alipayAppId="2018092761530588";
        String alipayAppPrivateKey="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCgCxjyet26HEhEOmTrhbT2312wGqDhiyGiw4FRK82hXcCofgQve4KctCugIFfBmctO4ClDQDZPyFnmyPl6tdvI/kvi17SG0sHcEasmF7AFWU04vHSrr+fm4zw3e6Q/lSsEoTnjF9g4zQUYQ6EvlkSeIQht6OBtzOoCvOs1h1aYu0/G3HIrSXGmFTrEFtGJqq5LYgNihXZ+klQYEREtbgCfNk9akJIBoP+CnRL1e9Eu4N9YWluw/ZUZ9IXd1qnp5kvwb9lX7A2itGCjA42FC7cpNjlcUXZr+ZKny0xmHOl9ZNUY2UtHaJwWf8l6yEFgfAIMx0mZJNDzw9GYb6hoL2YzAgMBAAECggEAbABRK4Eik+92DSTi6dVnE5oUnTy7CLldT3tjjyViNN0RoCK6LFjLAXjMX9izn+BrRKUc81cnz5tCn+1L/jUvRmnlSAWMu9cKH7qEpsYhcNqctAbpLNseQb9i6YY0hvvg9dTfPZLfxSUFpSQuZ/CeCZ/9Ej6vBSndWU+n4o2cMKBVqXKvmupfjb57uW/2+4o53HPFFGyGWdBmNkmdlO3gHSTyrmZakGFFI8A9gmOToMgFQfETkn0zvPlrqiV0Pq4kI5lp0jFt1SAETNA56F1Gsnw+dPtqMgFpgY3fCM6KmTRaCyrWpFz2XILnOjltV85KRTjEe0kOkqOAg/x0777+IQKBgQDO+W9C8t41zs6OTgVGQtJImPbJMw3unMtrRczZIJcgZNUFVJHGyZnRbYq5kSgdy/K9KUrK+tYq9nd6uaiDNduPPp4QCP4u29Mqj1ZkSDBDS/uLxfkcS5Qfvg/dzYcTxPD0PkU3qCbRUFDa+C6xQG924JoPLTERBQdjWIIA1saxKQKBgQDF89klABMA5AKsjeVFhGd9v/RS2su2qYg1dNp85RNqw04zKa5OPfHepbSajfxmM4BuO5LQvvKrPwACYU+40IfML53eCILgWR64/sbtVd45k2vIJjBY2Ek6K0XIvc63MZZ8bU9/Bo9aZnVMLxSO+NEnWQf5t9RvXuSDySTKPVl7+wKBgQCOlu199A/+hfFrvHiJxTNV7HvodRHeF4tU5guQcpFrMcxIFdEwYGdmDs+JtGUs0frzMuViHZk6k/4QQKPFcW9Hql3+shNbePpr0cA06j7Fvi0YSFWslqz/iVMo/ZVXm1BdFCFfjKrhfTGXCXAxkTC5d1brqbip/wrt+GXn6g+MsQKBgQC7ozuP8RQSYg+O1SogzTL0ZgIIj9FOIkE0usFoZhQTvXHg2X+aNumQLO6XGkPH9MWmt92g9X89iAhQOUHCZBh1GiXAk7zLQG742LhjvGNbnDwsitaFQO+YrfAGKrVJvT1yUINsWyGDhV9mibIpG/3WGHSQ5wn9T6u4p++xrJmoBQKBgD+2DCG8xWwfbI/Zn48VnGvwJ5gJ5/6fGbAVvzlbpdrRgAH+PgILMr3YfFRpyhhbSEzTy7MmkTWCFg7awmpti2VgyqfPCxvuzY9s5IiiL5/WbyKIZOtoGlCFkzehfpVtGRkpGR/vkD7PCkW1G+EcvYgQihlkQFj14CXiTIRW+J1q";
        String alipayPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0Av62gpFScGmXDZLo7b/sZynYQiD2ZVud5UzqotlxcTwu8CFe85bYND/qpwYjFVP4N4Sz9+V/kA2VxZzgxIcpm2BMXjEVbPCl8VMfR55XJV41+J0A6D2E8KZuLrMCwRjVD94N7ZiOH5viFCVF1QQmf/JMKFC/dU3Hq6gEODy2gIoXXmRoC8/Jkm9pG6fsUqcrbIpc0DgewditFMMBdHIbFpBK2PiSxNocE0pq3RJpf6Er08E/2vNYNYid/IVllu8u7nVWNAncJ5DkV8sSpWiQHUs8dHyTAHRQgFjoIL8GZSsyr4aS+xLZNK3A15wDh/7ZJoFpXI72qeIJ6fQNyNatwIDAQAB";
        String siteUrl="http://www.s-virtue.com/bld";
        try{
//            Config config = SystemUtils.getConfig();
//            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", config.getAlipayAppId(), config.getAlipayAppPrivateKey(), AlipayConstants.FORMAT_JSON, AlipayConstants.CHARSET_UTF8, config.getAlipayPublicKey(), AlipayConstants.SIGN_TYPE_RSA2); //获得初始化的AlipayClient
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", alipayAppId, alipayAppPrivateKey, AlipayConstants.FORMAT_JSON, AlipayConstants.CHARSET_UTF8, alipayPublicKey, AlipayConstants.SIGN_TYPE_RSA2); //获得初始化的AlipayClient
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
            alipayRequest.setReturnUrl(siteUrl+"/api/payment/alipayReturn/"+orderId);
            alipayRequest.setNotifyUrl(siteUrl+"/api/payment/alipayNotify");//在公共参数中设置回跳和通知地址
            alipayRequest.setBizContent("{" +
                    "    \"out_trade_no\":\""+DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS")+RandomStringUtils.randomNumeric(4)+"\"," +
                    "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                    "    \"total_amount\":"+amount+"," +
                    "    \"subject\":\""+subject+"\"," +
                    "    \"body\":\""+subject+"\"," +
                    "    \"passback_params\":\""+URLEncoder.encode(String.valueOf(orderId),AlipayConstants.CHARSET_UTF8)+"\"," +    //URLEncoder.encode(orderId,"UTF-8")
                    "    \"extend_params\":{" +
                    "    \"sys_service_provider_id\":\""+alipayAppId+"\"" +
                    "    }"+
                    "  }");//填充业务参数
            String form="";
            try {
                form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
            httpResponse.setContentType("text/html;charset=" + AlipayConstants.CHARSET_UTF8);
            httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
    public static void webPayRecharge(String orderId,BigDecimal amount,String subject,HttpServletRequest httpRequest,HttpServletResponse httpResponse){
        String alipayAppId="2018092761530588";
        String alipayAppPrivateKey="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCgCxjyet26HEhEOmTrhbT2312wGqDhiyGiw4FRK82hXcCofgQve4KctCugIFfBmctO4ClDQDZPyFnmyPl6tdvI/kvi17SG0sHcEasmF7AFWU04vHSrr+fm4zw3e6Q/lSsEoTnjF9g4zQUYQ6EvlkSeIQht6OBtzOoCvOs1h1aYu0/G3HIrSXGmFTrEFtGJqq5LYgNihXZ+klQYEREtbgCfNk9akJIBoP+CnRL1e9Eu4N9YWluw/ZUZ9IXd1qnp5kvwb9lX7A2itGCjA42FC7cpNjlcUXZr+ZKny0xmHOl9ZNUY2UtHaJwWf8l6yEFgfAIMx0mZJNDzw9GYb6hoL2YzAgMBAAECggEAbABRK4Eik+92DSTi6dVnE5oUnTy7CLldT3tjjyViNN0RoCK6LFjLAXjMX9izn+BrRKUc81cnz5tCn+1L/jUvRmnlSAWMu9cKH7qEpsYhcNqctAbpLNseQb9i6YY0hvvg9dTfPZLfxSUFpSQuZ/CeCZ/9Ej6vBSndWU+n4o2cMKBVqXKvmupfjb57uW/2+4o53HPFFGyGWdBmNkmdlO3gHSTyrmZakGFFI8A9gmOToMgFQfETkn0zvPlrqiV0Pq4kI5lp0jFt1SAETNA56F1Gsnw+dPtqMgFpgY3fCM6KmTRaCyrWpFz2XILnOjltV85KRTjEe0kOkqOAg/x0777+IQKBgQDO+W9C8t41zs6OTgVGQtJImPbJMw3unMtrRczZIJcgZNUFVJHGyZnRbYq5kSgdy/K9KUrK+tYq9nd6uaiDNduPPp4QCP4u29Mqj1ZkSDBDS/uLxfkcS5Qfvg/dzYcTxPD0PkU3qCbRUFDa+C6xQG924JoPLTERBQdjWIIA1saxKQKBgQDF89klABMA5AKsjeVFhGd9v/RS2su2qYg1dNp85RNqw04zKa5OPfHepbSajfxmM4BuO5LQvvKrPwACYU+40IfML53eCILgWR64/sbtVd45k2vIJjBY2Ek6K0XIvc63MZZ8bU9/Bo9aZnVMLxSO+NEnWQf5t9RvXuSDySTKPVl7+wKBgQCOlu199A/+hfFrvHiJxTNV7HvodRHeF4tU5guQcpFrMcxIFdEwYGdmDs+JtGUs0frzMuViHZk6k/4QQKPFcW9Hql3+shNbePpr0cA06j7Fvi0YSFWslqz/iVMo/ZVXm1BdFCFfjKrhfTGXCXAxkTC5d1brqbip/wrt+GXn6g+MsQKBgQC7ozuP8RQSYg+O1SogzTL0ZgIIj9FOIkE0usFoZhQTvXHg2X+aNumQLO6XGkPH9MWmt92g9X89iAhQOUHCZBh1GiXAk7zLQG742LhjvGNbnDwsitaFQO+YrfAGKrVJvT1yUINsWyGDhV9mibIpG/3WGHSQ5wn9T6u4p++xrJmoBQKBgD+2DCG8xWwfbI/Zn48VnGvwJ5gJ5/6fGbAVvzlbpdrRgAH+PgILMr3YfFRpyhhbSEzTy7MmkTWCFg7awmpti2VgyqfPCxvuzY9s5IiiL5/WbyKIZOtoGlCFkzehfpVtGRkpGR/vkD7PCkW1G+EcvYgQihlkQFj14CXiTIRW+J1q";
        String alipayPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0Av62gpFScGmXDZLo7b/sZynYQiD2ZVud5UzqotlxcTwu8CFe85bYND/qpwYjFVP4N4Sz9+V/kA2VxZzgxIcpm2BMXjEVbPCl8VMfR55XJV41+J0A6D2E8KZuLrMCwRjVD94N7ZiOH5viFCVF1QQmf/JMKFC/dU3Hq6gEODy2gIoXXmRoC8/Jkm9pG6fsUqcrbIpc0DgewditFMMBdHIbFpBK2PiSxNocE0pq3RJpf6Er08E/2vNYNYid/IVllu8u7nVWNAncJ5DkV8sSpWiQHUs8dHyTAHRQgFjoIL8GZSsyr4aS+xLZNK3A15wDh/7ZJoFpXI72qeIJ6fQNyNatwIDAQAB";
        String siteUrl="http://www.s-virtue.com/bld";
        try{
//            Config config = SystemUtils.getConfig();
//            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", config.getAlipayAppId(), config.getAlipayAppPrivateKey(), AlipayConstants.FORMAT_JSON, AlipayConstants.CHARSET_UTF8, config.getAlipayPublicKey(), AlipayConstants.SIGN_TYPE_RSA2); //获得初始化的AlipayClient
            AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", alipayAppId, alipayAppPrivateKey, AlipayConstants.FORMAT_JSON, AlipayConstants.CHARSET_UTF8, alipayPublicKey, AlipayConstants.SIGN_TYPE_RSA2); //获得初始化的AlipayClient
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
            alipayRequest.setReturnUrl(siteUrl+"/api/account/alipayReturn/"+orderId);
            alipayRequest.setNotifyUrl(siteUrl+"/api/account/alipayNotify");//在公共参数中设置回跳和通知地址
            alipayRequest.setBizContent("{" +
                    "    \"out_trade_no\":\""+DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS")+RandomStringUtils.randomNumeric(4)+"\"," +
                    "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                    "    \"total_amount\":"+amount+"," +
                    "    \"subject\":\""+subject+"\"," +
                    "    \"body\":\""+subject+"\"," +
                    "    \"passback_params\":\""+URLEncoder.encode(String.valueOf(orderId),AlipayConstants.CHARSET_UTF8)+"\"," +    //URLEncoder.encode(orderId,"UTF-8")
                    "    \"extend_params\":{" +
                    "    \"sys_service_provider_id\":\""+alipayAppId+"\"" +
                    "    }"+
                    "  }");//填充业务参数
            String form="";
            try {
                form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
            } catch (AlipayApiException e) {
                e.printStackTrace();
            }
            httpResponse.setContentType("text/html;charset=" + AlipayConstants.CHARSET_UTF8);
            httpResponse.getWriter().write(form);//直接将完整的表单html输出到页面
            httpResponse.getWriter().flush();
            httpResponse.getWriter().close();
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
