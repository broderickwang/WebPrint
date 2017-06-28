package util;

import bean.DataBean;
import bean.FapiaoBean;
import bean.TaodaBean;

import java.util.ArrayList;

/*
 *Created by Broderick
 * User: Broderick
 * Date: 2017/6/21
 * Time: 09:52
 * Version: 1.0
 * Description:
 * Email:wangchengda1990@gmail.com
**/
public class BeanList {
    public ArrayList<DataBean> getDataBeanList() {
        ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

        dataBeanList.add(produce("Manisha", "India"));
        dataBeanList.add(produce("Dennis Ritchie", "USA"));
        dataBeanList.add(produce("V.Anand", "India"));
        dataBeanList.add(produce("Shrinath", "California"));

        return dataBeanList;
    }

    public ArrayList<TaodaBean> getTaodaBeanList(){
        ArrayList<TaodaBean> dataBeanList = new ArrayList<TaodaBean>();

        dataBeanList.add(taoda("Manisha", "India"));
        dataBeanList.add(taoda("Dennis Ritchie", "USA"));
        dataBeanList.add(taoda("V.Anand", "India"));
        dataBeanList.add(taoda("Shrinath", "California"));

        return dataBeanList;
    }

    private TaodaBean taoda(String test1,String test2){
        TaodaBean bean = new TaodaBean();
        bean.setTest1(test1);
        bean.setTest2(test2);
        return bean;
    }

    public static FapiaoBean getFapiaoBean(){
        FapiaoBean fapiaoBean = new FapiaoBean();

        fapiaoBean.setTaitou("张三 1900932241");
        fapiaoBean.setZuoyi("测试数据 \n 某莫某某");
        fapiaoBean.setJiqima("00322 45982 89JS1 6512 9091 458X \n T4323 76820");
        fapiaoBean.setNeirong1("测试数据 某莫某某");
        fapiaoBean.setNeirong2("测试数据 某莫某某");
        fapiaoBean.setNeirong3("测试数据 某莫某某");
        fapiaoBean.setNeirong4("测试数据 某莫某某");
        fapiaoBean.setZuihou("测试数据 某莫某某");
        fapiaoBean.setJine("￥1,7900");
        fapiaoBean.setBeizhu("测试数据 某莫某某 测试数据 某莫某某 " +
                "测试数据 某莫某某 测试数据 某莫某某 测试数据 某莫某某 测试数据 某莫某某 测试数据 某莫某某 测试数据 某莫某某 ");
        fapiaoBean.setKaipiaoren("JOHN");
        fapiaoBean.setShoukuanren("JERRY");
        fapiaoBean.setFuhe("Harry");
        return fapiaoBean;
    }

    /**
     * This method returns a DataBean object,
     * with name and country set in it.
     */
    private DataBean produce(String name, String country) {
        DataBean dataBean = new DataBean();
        dataBean.setName(name);
        dataBean.setCountry(country);
        return dataBean;
    }
}
