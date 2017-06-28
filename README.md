# WebPrint
一个JasperReport报表的基本DEMO，实现了基本的打印功能，包括PDF,HTML,WORD和EXCEL

Jasper导出报表的使用已经封装到Jasper-Print.jar包中，可以直接使用。

```java
File jasperFile=new File(this.getServletContext()
        .getRealPath("jasper/taoda.jasper"));
JasperHelper.export(PrintType.PDF_IO_TYPE,null,jasperFile,paramers,
        list.getTaodaBeanList(),response);
```

PrintType是打印类型枚举，如下

```Java
public enum PrintType {
    PDF_TYPE,
    PDF_IO_TYPE,
    EXCEL_TYPE,
    HTML_TYPE,
    WORD_TYPE;

    private PrintType() {
    }
}
```

模板设计请参考JasperStudio