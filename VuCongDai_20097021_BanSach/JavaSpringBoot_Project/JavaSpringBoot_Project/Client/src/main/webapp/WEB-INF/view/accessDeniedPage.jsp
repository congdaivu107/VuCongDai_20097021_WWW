<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <!--FONT-->
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;700&display=swap" rel="stylesheet">
        <!--LINL CSS-->
        <link href="${pageContext.request.contextPath}/Resources/css/accessDenied.css"  rel="stylesheet" type="text/css">
        <!--LINK JS-->        
        <c:url var="LOGO" value="/Resources/img/LOGO.png"/>
        <link rel="apple-touch-icon" href="${LOGO}">
        <link rel="shortcut icon" type="image/x-icon" href="${LOGO}">
    </head>
    <body>
        <a href="javascript:history.back()">
            <div class="base io">
                <h1 class="io">403</h1>
                <h2>Quyền truy cập bị Từ chối</h2>
                <h5><p>(Quay Lai Trang)</p></h5>
            </div>
        </a>
    </body>
</html>
