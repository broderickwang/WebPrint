package Servlet;

import Jasper.JRHelper;
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

        try {
            JRHelper helper = new JRHelper.Builder()
                    .connection(Utils.getConnection())
                    .type(PrintType.PDF_IO_TYPE)
                    .jasperFile(jasperFile)
                    .response(response)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*Map<String, Object> parameters = new HashedMap();

        try {
            JasperHelper.export(PrintType.PDF_IO_TYPE,null,jasperFile,parameters, Utils.getConnection(),response);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
