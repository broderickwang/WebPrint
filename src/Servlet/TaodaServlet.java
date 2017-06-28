package Servlet;

import JasperUtil.JasperHelper;
import JasperUtil.PrintType;
import org.apache.commons.collections.map.HashedMap;
import util.BeanList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class TaodaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,Object> paramers = new HashedMap();
        BeanList list = new BeanList();
        File jasperFile=new File(this.getServletContext()
                .getRealPath("jasper/taoda.jasper"));
        JasperHelper.export(PrintType.PDF_IO_TYPE,null,jasperFile,paramers,
                list.getTaodaBeanList(),response);
    }
}
