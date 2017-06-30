# WebPrint
一个JasperReport报表的基本DEMO，实现了基本的打印功能，包括PDF,HTML,WORD和EXCEL

**使用JasperSoft的版本是6.3.0**

Jasper导出报表的使用已经封装到Jasper-Print.jar包中，可以直接使用。

```java
File jasperFile=new File(this.getServletContext()
        .getRealPath("jasper/taoda.jasper"));
JasperHelper.export(PrintType.PDF_IO_TYPE,null,jasperFile,paramers,
        list.getTaodaBeanList(),response);
//该方法已过时
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

模板设计请参考[JasperStudio](http://community.jaspersoft.com/documentation/tibco-jaspersoft-studio-user-guide/v621/getting-started-jaspersoft-studio)

### 使用方法详细说明

调用Jasper-Print.jar中的JRHelper类来辅助导出和打印。

使用方法修改为链式调用

```java
new JRHelper.Builder()
  		//设置返回输出的response
        .response(response)
        //设置输出名称，如果不设置默认是export。
  		//如果输出的是HTML格式，需要带上this.getServletContext().getRealPath("/")
  		//以便输出HTML后，重定向到该HTML页面，如果输出是PDF_IO,outName可以省略
  		.outName(this.getServletContext().getRealPath("/")+"template")
        //设置输出的格式，支持：HTML,PDF文件,PDF IO流,EXCEL,WORD
  		.type(PrintType.HTML_TYPE)
        //设置模板的数据集,支持collection和connection
  		//调用了collection之后就不能再调用connection
  		.collection(datas)
        //设置模板文件
  		.jasperFile(reportFile)
        //最后调用,输出
  		.build();

JRHelper helper = new JRHelper.Builder()
  					//设置模板的数据集,支持collection和connection
  					//调用了connection之后就不能再调用collection
                    .connection(Utils.getConnection())
  					//设置输出的格式，支持：HTML,PDF文件,PDF IO流,EXCEL,WORD
                    .type(PrintType.PDF_IO_TYPE)
  					//设置模板文件
                    .jasperFile(jasperFile)
  					//设置返回输出的response
                    .response(response)
  					//最后调用,输出
                    .build();
```

<!--链式调用build()方法必须最后调用-->

> PrintType是HTML_TYPE的时候，outName的设置需要带上路径
>
> collection() 和 connection()必须调用其中一个，并且仅能调用一个，不能同时调用
>
> outName的设置不需要带后缀名
>
> addP()是给模板添加参数的，如果模板没有参数可以不调用
>
> bulid（）方法只能最后调用，是最后的输出。

https://github.com/broderickwang/WebPrint/tree/master/src/Servlet

