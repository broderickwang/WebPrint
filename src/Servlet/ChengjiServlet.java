package Servlet;

import Jasper.JRHelper;
import JasperUtil.PrintType;
import util.BeanList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class ChengjiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            File reportFile = new File(this.getServletContext()
                    .getRealPath("jasper/chengji.jasper"));

            new JRHelper.Builder()
                    .jasperFile(reportFile)
                    .response(response)
                    .collection(BeanList.getChengji())
                    .type(PrintType.HTML_TYPE)
                    .outName(this.getServletContext().getRealPath("/")+"chengji")
                    .build();
        }catch (Exception e){

        }
    }
}
