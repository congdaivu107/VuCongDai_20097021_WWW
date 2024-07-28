<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/Resources/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/Resources/css/style.css"  rel="stylesheet" type="text/css">
        <title>Service</title>
    </head>
    <body>
        <nav class="menu-area">
            <ul>
                <li><a href="/Service/">BOOKSHOP:</a></li>
                <li><a href="/Service/api/books">Books</a></li>
                <li><a href="/Service/api/carts">Shopping Cart</a></li>
                <li><a href="/Service/api/customers">Customers</a></li>
            </ul>
            <form action="/Client/sach/search?q=" method="GET">
                <input name="q" type="search" placeholder="Search books here....">
                <button type="submit">Find</button>
            </form>
        </nav>
        <nav class="menu-area">
            <ul>
                <li><a href="/Service/">BOOKSHOP:</a></li>
                <li><a href="/Service/api/books/comments">Comment</a></li>
                <li><a href="/Service/api/accounts">Accounts</a></li>
            </ul>
            <form action="/Client/sach/search?q=" method="GET">
                <input type="search" placeholder="Search customers here....">
                <button>Find</button>
            </form>
        </nav>
        <div class="banner-text">
            <h2>SERVER IS START</h2>
            <p>Date Start: <span id="datetime"></span></p>
            <p id="MyClockDisplay" onload="showTime()"></p>
            <script>
                var dt = new Date();
                document.getElementById("datetime").innerHTML = dt.toLocaleString();
            </script>            
            <script>
                function showTime() {
                    var date = new Date();
                    var h = date.getHours(); // 0 - 23
                    var m = date.getMinutes(); // 0 - 59
                    var s = date.getSeconds(); // 0 - 59
                    var session = "AM";
                    if (h == 0) {
                        h = 12;
                    }
                    if (h > 12) {
                        h = h - 12;
                        session = "PM";
                    }
                    h = (h < 10) ? "0" + h : h;
                    m = (m < 10) ? "0" + m : m;
                    s = (s < 10) ? "0" + s : s;
                    var time = h + ":" + m + ":" + s + " " + session;
                    document.getElementById("MyClockDisplay").innerText = time;
                    document.getElementById("MyClockDisplay").textContent = time;
                    setTimeout(showTime, 1000);

                }
                showTime();
            </script>
        </div>
    </body>
</html>
