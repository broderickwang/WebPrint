package Servlet;

import Jasper.JRHelper;
import JasperUtil.JasperHelper;
import JasperUtil.PrintType;
import util.Utils;

import javax.rmi.CORBA.Util;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrossTableTotalPDFServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        try {
            File reportFile = new File(this.getServletContext()
                    .getRealPath("jasper/CrossReport.jasper"));

            Map parameters = new HashMap();

            /*JasperHelper.export(PrintType.PDF_IO_TYPE,null,reportFile,
                    parameters, Utils.getConnection(),response);*/
            new JRHelper.Builder()
                    .type(PrintType.PDF_IO_TYPE)
                    .jasperFile(reportFile)
                    .connection(Utils.getConnection())
                    .response(response)
                    .build();
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
