package com.bangcle.service;

import java.util.Iterator;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

@WebService
@Slf4j
public class SendMessageService {
  @WebMethod
  public String sendMessage(String strBody){
    try {
      Document document= DocumentHelper.parseText(strBody);
      //获取根节点元素对象
      Element root = document.getRootElement();
      listNodes(root);
    } catch (DocumentException e) {
      e.printStackTrace();
    }
    return null;
  }

  //遍历当前节点下的所有节点
  public void listNodes(Element node){
    log.info("当前节点的名称：" + node.getName());
    //首先获取当前节点的所有属性节点
    List<Attribute> list = node.attributes();
    //遍历属性节点
    for(Attribute attribute : list){
      log.info("属性"+attribute.getName() +":" + attribute.getValue());
    }
    //如果当前节点内容不为空，则输出
    if(!(node.getTextTrim().equals(""))){
      if ("base64_ECD_Txn_Inf".equals(node.getName())){
        doPost("",node.getText());
      }
      log.info( node.getName() + "：" + node.getText());
    }
    //同时迭代当前节点下面的所有子节点
    //使用递归
    Iterator<Element> iterator = node.elementIterator();
    while(iterator.hasNext()){
      Element e = iterator.next();
      listNodes(e);
    }
  }

  private String doPost(String strURL, String strBody) {
    String strReturn = "error";
    HttpPost httpPost = new HttpPost(strURL);
    RequestConfig requestConfig = RequestConfig.custom()
        .setSocketTimeout(1000)
        .setConnectTimeout(1000)
        .build();
    httpPost.setConfig(requestConfig);
    StringEntity stringEntity = new StringEntity(strBody,
        ContentType.create("text/plain", "UTF-8"));
    stringEntity.setChunked(true);
    httpPost.setEntity(stringEntity);
    CloseableHttpClient httpclient = null;
    CloseableHttpResponse httpResponse = null;
    try {
      httpclient = HttpClients.createDefault();
      httpResponse = httpclient.execute(httpPost);
      //log.info("status line:{}", httpResponse.getStatusLine());
      strReturn = EntityUtils.toString(httpResponse.getEntity());
      EntityUtils.consume(httpResponse.getEntity());
      //log.info("strReturn:{}", strReturn);
    } catch (Exception e) {
      log.error("", e);
    } finally {
      if (httpResponse != null) {
        try {
          httpResponse.close();
        } catch (Exception e) {
          log.error("", e);
        }
      }
      if (httpclient != null) {
        try {
          httpclient.close();
        } catch (Exception e) {
          log.error("", e);
        }
      }
    }
    return strReturn;
  }

}
