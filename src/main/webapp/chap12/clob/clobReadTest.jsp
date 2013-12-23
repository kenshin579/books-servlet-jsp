<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.io.Reader" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuffer sb = null;

//    String driver = "oracle.jdbc.driver.OracleDriver";
//    String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/servlet_jsp";

    try {
        Class.forName(driver);
        conn = DriverManager.getConnection(url, "root", "1234");

        pstmt = conn.prepareStatement("SELECT * FROM clobtable WHERE num=1");
        rs = pstmt.executeQuery();
        if (rs.next()) {
            Reader rd = rs.getCharacterStream("content");

            sb = new StringBuffer();
            char[] buf = new char[1024];
            int readcnt;
            while ((readcnt = rd.read(buf, 0, 1024)) != -1) {
                sb.append(buf, 0, readcnt);
            }
        }

        rs.close();
        pstmt.close();
        conn.close();
        out.println(sb.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
