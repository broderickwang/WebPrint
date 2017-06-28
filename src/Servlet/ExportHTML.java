package Servlet;

import Jasper.JasperHelper;
import Jasper.PrintType;
import net.sf.jasperreports.engine.JasperReport;
import util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExportHTML extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        try {
            File reportFile = new File(this.getServletContext()
                    .getRealPath("jasper/jiaofeidan.jasper"));
            Map parameters = new HashMap();

            JasperHelper.export(PrintType.HTML_TYPE,
                    this.getServletContext().getRealPath("/")+"jiaofei.html",reportFile,
                    parameters, Utils.getConnection(),response);
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
