<%@ page language="java" contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.io.BufferedWriter" %>
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

    String sql = "INSERT INTO clobtable (num,content) VALUES (1,empty_clob())";
    String sql2 = "SELECT content FROM clobtable WHERE num=1 FOR UPDATE";

    try {
        Class.forName(driver);
        conn = DriverManager.getConnection(url, "root", "1234");

        conn.setAutoCommit(false);

        sb = new StringBuffer();
        for (int i = 0; i <= 10000; i++) {
            sb.append("홍길동");
        }

        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
        pstmt.close();

        pstmt = conn.prepareStatement(sql2);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            oracle.sql.CLOB clob = (oracle.sql.CLOB) (rs).getClob("content");
            BufferedWriter bw = new BufferedWriter(clob.getCharacterOutputStream());
            bw.write(sb.toString());
            bw.close();
        }
        pstmt.close();


        conn.commit();
        conn.setAutoCommit(true);
        out.println("데이타를 저장했습니다.");

        rs.close();
        pstmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
