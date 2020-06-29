# webmvc
##JDBC
Java.sql.Connection:负责连接数据库
Java.sql.Statement:负责执行sql语句
Java.sql.ResultSet:负责存放查询结果

操作步骤
1、连接到mysql驱动
Class.forName("com.mysql.jdbc.Driver");连接到mysql驱动
2、获取连接
connection=DriverManager.getConnection(url,user,password);
3、使用Statement或者PreparedStatement接口运行sql语句
PreparedStatement pstmt=conn.prepareStatement(sql);
4、存放sql查询结果
ResultSet rs=pstmt.executeQuery();
5、关闭数据库连接
rs.close();
pstmt.close();
conn.close();

ResultSet是个小表格，游标是在ResultSet中一个可以移动的指针，指向一行数据。初始时指向第一行的前一行，实际上不指向任何数据。Rs.next()可以将游标移到下一行，它的返回值是一个布尔类型，即有数据返回true，没有数据返回false，可以用rs.next()配合while循环来对结果实现遍历。

PreparedStatement会对sql语句进行预编译，预编译后，会存储在PreparedStatement对象中，等下次再执行这个PreparedStatement对象时，会提高很多效率。
当客户发送一条SQL语句给服务器后，服务器总是需要校验SQL语句的语法格式是否正确，然后把SQL语句编译成可执行的函数，最后才是执行SQL语句。其中校验语法，和编译所花的时间可能比执行SQL语句花的时间还要多。如果使用预编译功能，那么只对SQL语句进行一次语法校验和编译，所以效率要高。

PreparedStatement是Statement的子接口，功能相似。他用”?”代替了需要插入的参数
CallableStatement是PreparedStatement的子接口，可以同时处理In参数和out参数

Connection可以定义是否自动提交，并进行失误的提交或者Rollback回滚（异常回滚）,保证两条sql语句都执行。场景：银行账户转账。


##Web开发
web开发是B/S（Browser/Server）模式下的一种开发形式。

JSP表达式
<%= 变量/返回值/表达式%>

JSP程序段,不能在jsp程序段中定义方法
<% %>

JSP声明,优先执行
<%!  代码  %>


JSP九种内置对象
Out对象：负责管理对客户端的输出
Request对象：负责得到客户端的请求信息
Response对象：负责向客户端发出响应
Session对象：负责保存同一客户端一次会话过程中的一些信息
Application对象：表示整个应用的环境的信息
Exception对象：表示页面上发生的异常，可以通过它获得页面异常信息
Page对象：表示的是当前JSP页面本身，就像Java类定义中的this一样
PageContext对象：表示的是此JSP的上下文
Config对象：表示此JSP的ServletConfig

Cookie实际上是一小段的文本信息。客户端请求服务器，如果服务器需要记录该用户状态，就使用response向客户端浏览器颁发一个Cookie。客户端浏览器会把Cookie保存起来。当浏览器再请求该网站时，浏览器把请求的网址连同该Cookie一同提交给服务器。服务器检查该Cookie，以此来辨认用户状态。服务器还可以根据需要修改Cookie的内容。
删除cookie的几种方法
给cookie赋空值
设置cookie失效时间为当前时间
通过浏览器删除cookie

Session与Cookie的区别在于Session是记录在服务端的，而Cookie是记录在客户端的。

当Web服务器启动时，Web服务器会自动创建一个application对象。application对象一旦创建，它将一直存在，直到Web服务器关闭。
一个Web服务器通常有多个Web服务目录 (网站)，当Web服务器启动时，它自动为每个Web服务目录都创建一个application对象，这些application对象各自独立，而且和Web服务目录一一对应。
访问同一个网站的客户都共享一个application对象，因此，application对象可以实现多客户间的数据共享。
访问不同网站的客户，对应的application对象不同

Javebean
这个Java类必须具有一个无参的构造函数
属性必须私有化。
私有化的属性必须通过public类型的方法暴露给其它程序，并且方法的命名也必须遵守一定的命名规范

VO：主要用于传输数据，用于向页面返回数据；
DAO：底层数据传输，访问数据库，操作数据库，一般包含*Mapper.xml
DTO:DTO(Data Transfer Object 数据传输对象)，有时候我们仅仅需要获得某一个表的几个字段，所以此时可以用DTO存储这几个字段

##Servlet是一种运行在服务器端的java应用程序，生成动态的web页面，是属于客户与服务器响应的中间层。
步骤：创建类，继承httpservlet，重写doGet()方法，配置servlet，部署servlet，测试servlet
Servlet的配置通过web.xml来实现

常见的Servlet跳转

1、重定向sendRedirect
Response.sendRedirect(“url”)
2、请求转发，服务器内跳转forward
地址栏不变，两个页面属于同一次请求，公用request，重新发送一次请求，对数据进行修改
request.getRequestDispatcher("/student/searchstudent.jsp").forward(request, response);
当不需要出参数或者跳转到另一个服务器页面时使用重定向

过滤器配置解决乱码问题,适用于Servlet过多的情况下，不用在每个Servlet中进行配置
