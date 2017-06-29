package Servlet;

import Jasper.JRHelper;
import JasperUtil.JasperHelper;
import JasperUtil.PrintType;
import bean.DataBean;
import util.BeanList;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JavaBeanFillTemp extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        try {
            File reportFile = new File(this.getServletContext()
                    .getRealPath("jasper/template.jasper"));

            Map parameters = new HashMap();

            BeanList dataList = new BeanList();
            ArrayList<DataBean> datas = dataList.getDataBeanList();

            /*JasperHelper.export(PrintType.HTML_TYPE,
                    this.getServletContext().getRealPath("/")+"template",reportFile,parameters,
                    datas, response);*/
            new JRHelper.Builder()
                    .response(response)
                    .outName(this.getServletContext().getRealPath("/")+"template")
                    .type(PrintType.HTML_TYPE)
                    .collection(datas)
                    .jasperFile(reportFile)
                    .build();

        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
