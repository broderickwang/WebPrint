package Servlet;

import JasperUtil.JasperHelper;
import JasperUtil.PrintType;
import org.apache.commons.collections.map.HashedMap;
import util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ExportPDF extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        File jasperFile = new File(this.getServletContext()
                .getRealPath("/jasper/jiaofeidan.jasper"));

        Map<String, Object> parameters = new HashedMap();

        try {
            JasperHelper.export(PrintType.PDF_IO_TYPE,null,jasperFile,parameters, Utils.getConnection(),response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
