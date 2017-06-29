package Servlet;

import JasperUtil.JasperHelper;
import JasperUtil.PrintType;
import util.Utils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CrossTableTotalHTMLServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        try {
            File reportFile = new File(this.getServletContext()
                    .getRealPath("jasper/CrossReport.jasper"));

            Map parameters = new HashMap();

            JasperHelper.export(PrintType.HTML_TYPE,
                    this.getServletContext().getRealPath("/")+"crosstable",reportFile,
                    parameters, Utils.getConnection(),response);

        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
