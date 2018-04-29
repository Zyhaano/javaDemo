package com.bangcle.utils;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class test {

  public static void main(String[] args) {

    JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
    org.apache.cxf.endpoint.Client client = dcf
        .createClient("http://localhost:8080/message/send?wsdl");
    //getUser 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
    Object[] objects = new Object[0];
    String strBody="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        + "<TX>\n"
        + "    <TX_HEADER>\n"
        + "        <SYS_HDR_LEN/>\n"
        + "        <SYS_PKG_VRSN>01</SYS_PKG_VRSN>\n"
        + "        <SYS_TTL_LEN />\n"
        + "        <SYS_REQ_SEC_ID>102001</SYS_REQ_SEC_ID>\n"
        + "        <SYS_SND_SEC_ID>102001</SYS_SND_SEC_ID>\n"
        + "        <SYS_TX_CODE>CBACB0001</SYS_TX_CODE>\n"
        + "        <SYS_TX_VRSN>01</SYS_TX_VRSN>\n"
        + "        <SYS_TX_TYPE>020000</SYS_TX_TYPE>\n"
        + "        <SYS_RESERVED />\n"
        + "        <SYS_EVT_TRACE_ID>1020010041505804499129818</SYS_EVT_TRACE_ID><!--流水号-->\n"
        + "        <SYS_SND_SERIAL_NO>0000000000</SYS_SND_SERIAL_NO> \n"
        + "        <SYS_PKG_TYPE>1</SYS_PKG_TYPE>\n"
        + "        <SYS_MSG_LEN />\n"
        + "        <SYS_IS_ENCRYPTED>0</SYS_IS_ENCRYPTED>\n"
        + "        <SYS_ENCRYPT_TYPE>3</SYS_ENCRYPT_TYPE>\n"
        + "        <SYS_COMPRESS_TYPE>0</SYS_COMPRESS_TYPE>\n"
        + "        <SYS_EMB_MSG_LEN />\n"
        + "        <SYS_REQ_TIME>20170919150139554</SYS_REQ_TIME>\n"
        + "        <SYS_TIME_LEFT>000120000</SYS_TIME_LEFT>\n"
        + "        <SYS_PKG_STS_TYPE>00</SYS_PKG_STS_TYPE>\n"
        + "        <SYS_SEC_CONTEXT_LEN />\n"
        + "        <SYS_SEC_CONTEXT />\n"
        + "    </TX_HEADER>\n"
        + "    <TX_BODY>\n"
        + "        <COMMON>\n"
        + "            <COM1>\n"
        + "                <TXN_INSID>111111111</TXN_INSID>\n"
        + "                <TXN_ITT_CHNL_ID>0018</TXN_ITT_CHNL_ID>\n"
        + "                <TXN_ITT_CHNL_CGY_CODE>20380090</TXN_ITT_CHNL_CGY_CODE>\n"
        + "                <TXN_DT>20170919</TXN_DT>\n"
        + "                <TXN_TM>150139</TXN_TM>\n"
        + "                <TXN_STFF_ID>17797365</TXN_STFF_ID>\n"
        + "                <MULTI_TENANCY_ID>CN000</MULTI_TENANCY_ID>\n"
        + "                <LNG_ID>zh-cn</LNG_ID>\n"
        + "                <BSN_MT_ENT_IDR>CN000</BSN_MT_ENT_IDR>\n"
        + "            </COM1>\n"
        + "        </COMMON>\n"
        + "\t\t\t\t<ENTITY>\n"
        + "\t\t\t\t\t<Stm_Chnl_ID>3001</Stm_Chnl_ID>\n"
        + "\t\t\t\t\t<Stm_Chnl_Txn_CD>CBACB0001-ccvea</Stm_Chnl_Txn_CD>\n"
        + "\t\t\t\t\t<base64_ECD_Txn_Inf>XXXXXXXXXXXXX</base64_ECD_Txn_Inf><!--客户端采集的信息，即原来strBody的信息-->\n"
        + "\t\t\t\t\t<base64_Ecrp_Txn_Inf>CBACB0001-ccvea</base64_Ecrp_Txn_Inf>\n"
        + "\t\t\t\t\t<Usr_Inf_Dsc>CBACB0001-ccvea</Usr_Inf_Dsc>\n"
        + "\t\t\t\t\t<Eqmt_Inf_Dsc>CBACB0001-ccvea</Eqmt_Inf_Dsc>\n"
        + "\t\t\t\t\t<Aflt_Inf_Dsc>CBACB0001-ccvea</Aflt_Inf_Dsc>\t\t\t\t\t\n"
        + "\t\t\t\t</ENTITY>\n"
        + "\t\t\t\n"
        + "    </TX_BODY>\n"
        + "</TX>";
    try {
      objects = client.invoke("sendMessage", strBody);
    } catch (Exception e) {
      e.printStackTrace();
    }
    //输出调用结果
    System.out.println("*****" + objects[0].toString());
  }
}
