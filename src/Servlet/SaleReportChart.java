package Servlet;

import Jasper.JasperHelper;
import Jasper.PrintType;
import util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SaleReportChart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File jasperFile=new File(this.getServletContext()
                .getRealPath("jasper/SaleReport.jasper"));
        try {
            Map parameters = new HashMap();
            JasperHelper.export(PrintType.PDF_IO_TYPE,null,jasperFile,parameters,
                    Utils.getConnection(),response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
