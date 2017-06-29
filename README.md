# WebPrint
一个JasperReport报表的基本DEMO，实现了基本的打印功能，包括PDF,HTML,WORD和EXCEL

**使用JasperSoft的版本是6.3.0**

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



使用方法修改为链式调用

```java
new JRHelper.Builder()
        .response(response)
        .outName(this.getServletContext().getRealPath("/")+"template")
        .type(PrintType.HTML_TYPE)
        .collection(datas)
        .jasperFile(reportFile)
        .build();

JRHelper helper = new JRHelper.Builder()
                    .connection(Utils.getConnection())
                    .type(PrintType.PDF_IO_TYPE)
                    .jasperFile(jasperFile)
                    .response(response)
                    .build();
```

<!--链式调用build()方法必须最后调用-->

> PrintType是HTML_TYPE的时候，outName的设置需要带上路径
>
> collection() 和 connection()只能调用其中一个，并且只能调用一个，不能同时调用
>
> outName的设置不行要带后缀名
>
> bulid（）方法只能最后调用，是最后的输出。

https://github.com/broderickwang/WebPrint/tree/master/src/Servlet