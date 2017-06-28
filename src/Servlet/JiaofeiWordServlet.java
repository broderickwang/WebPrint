package Servlet;

import JasperUtil.JasperHelper;
import JasperUtil.PrintType;
import util.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JiaofeiWordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext=this.getServletConfig().getServletContext();
        File jasperFile=new File(servletContext.getRealPath("/jasper/jiaofeidan.jasper"));
        try {
            Map parameters = new HashMap();
            JasperHelper.export(PrintType.WORD_TYPE,"jiaofeidan",jasperFile,parameters,
                    Utils.getConnection(),response);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
