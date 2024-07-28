<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BOOK SHOP</title>
        <!--LINL CSS-->
        <link href="${pageContext.request.contextPath}/Resources/css/bootstrap.min.css"  rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/Resources/css/templatemo.css"  rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/Resources/css/custom.css"  rel="stylesheet" type="text/css">
        <!--FONT-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <!--ICON-->
        <link href="${pageContext.request.contextPath}/Resources/css/fontawesome.css"  rel="stylesheet">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
        <!--LINK JS-->
        <script src="<c:url value='/Resources/js/jquery-1.11.0.min.js' />" ></script>
        <script src="<c:url value='/Resources/js/jquery-migrate-1.2.1.min.js' />" ></script>
        <script src="<c:url value='/Resources/js/bootstrap.bundle.min.js' />" ></script>
        <script src="<c:url value='/Resources/js/templatemo.js' />" ></script>
        <script src="<c:url value='/Resources/js/custom.js' />" ></script>
        <!--LINK IMG-->
        <c:url var="LOGO" value="/Resources/img/LOGO.png"/>
        <link rel="apple-touch-icon" href="${LOGO}">
        <link rel="shortcut icon" type="image/x-icon" href="${LOGO}">


    </head>
    <body>
        <!-- Start Top Nav -->
        <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
            <div class="container text-light">
                <div class="w-100 d-flex justify-content-between">
                    <div>
                        <i class="fa fa-envelope mx-2"></i>
                        <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:congdaivu107@gmail.com">congdaivu107@gmail.com</a>
                        <i class="fa fa-phone mx-2"></i>
                        <a class="navbar-sm-brand text-light text-decoration-none" href="tel:034-432-5820">034-432-5820</a>
                    </div>
                    <div>
                        <a class="text-light" href="https://fb.com/congdaivu107@gmail.com" target="_blank" rel="sponsored"><i class="fab fa-facebook-f fa-sm fa-fw me-2"></i></a>
                        <a class="text-light" href="https://www.instagram.com/congdaivu107@gmail.com" target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                        <a class="text-light" href="https://twitter.com/" target="_blank"><i class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                        <a class="text-light" href="https://www.linkedin.com/" target="_blank"><i class="fab fa-linkedin fa-sm fa-fw"></i></a>
                    </div>
                </div>
            </div>
        </nav>
        <!-- Header -->
        <nav class="navbar navbar-expand-lg navbar-light shadow">
            <div class="container d-flex justify-content-between align-items-center">

                <a class="navbar-brand text-success logo h1 align-self-center" href="http://localhost:8080/Client/home">
                    Book Shop
                </a>

                <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                    <div class="flex-fill">
                        <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/Client/home">Trang Chủ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/Client/about">Dịch Vụ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/Client/sach/shop">Cửa Hàng</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="http://localhost:8080/Client/contact">Liên Hệ</a>
                            </li>
                        </ul>
                    </div>
                    <div class="navbar align-self-center d-flex">
                        <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                            <div class="input-group">
                                <input type="text" class="form-control" id="inputMobileSearch" placeholder="Search ...">
                                <div class="input-group-text">
                                    <i class="fa fa-fw fa-search"></i>
                                </div>
                            </div>
                        </div>
                        <a class="nav-icon d-none d-lg-inline" href="#" data-bs-toggle="modal" data-bs-target="#templatemo_search">
                            <i class="fa fa-fw fa-search text-dark mr-2"></i>
                        </a>
                        <a class="nav-icon position-relative text-decoration-none" href="http://localhost:8080/Client/profile/show">
                            <i class="fa fa-fw fa-user text-dark mr-3"></i>
                            <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">+99</span>
                        </a>
                    </div>
                </div>

            </div>
        </nav>
        <!-- Modal Search -->
        <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="w-100 pt-1 mb-5 text-right">
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <form action="/Client/sach/search" method="get" class="modal-content modal-body border-0 p-0">
                    <div class="input-group mb-2">
                        <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Tìm Kiếm...">
                        <button type="submit" class="input-group-text bg-success text-light">
                            <i class="fa fa-fw fa-search text-white"></i>
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <div class="container">
            <table id="cart" class="table table-hover table-condensed" >
                <thead style="text-align: center">
                    <tr>
                        <th style="width:50%">Sản Phẩm</th>
                        <th style="width:10%">Giá</th>
                        <th style="width:10%">Số Lượng</th>
                        <th style="width:20%" class="text-center">Tổng</th>
                        <th style="width:10%"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${itemCarts}">                        
                        <tr>
                            <td>
                                <div class="row">
                                    <div class="col-sm-2 hidden-xs"><img src="/Client${item.image.getPhotosImagePath()}" style="width: 100px; max-height: 100px; overflow: hidden;" alt="..." class="img-responsive" /></div>
                                    <div class="col-sm-10">
                                        <h4 class="nomargin">${item.gioHang.maSach.tenSach}</h4>
                                        <p>${item.gioHang.maSach.tacGia}</p>
                                    </div>
                                </div>
                            </td>
                            <td>
                                ${item.gioHang.maSach.giaSach}₫
                                <input type="hidden" class="priceTotal" value="${item.gioHang.maSach.giaSach}">
                            </td>
                            <td>
                                <input type="number" class="form-control text-center quantityTotal" value="${item.gioHang.soLuong}" min="1">
                            </td>
                            <td data-th="Subtotal" class="text-center tongTotal">1.99</td>
                            <td class="actions">
                                <a href="/Client/sach/book?id=${item.gioHang.maSach.maSach}" class="btn btn-info btn-sm">
                                    <i class="fas fa-eye" style="color: #fff"></i>
                                </a>
                                <a href="delete?id=${item.gioHang.maSach.maSach}" class="btn btn-danger btn-sm">
                                    <i class="fa fa-trash-o"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td><a href="/Client/sach/shop" class="btn btn-warning"><i class="fa fa-angle-left"></i> Tiếp tục mua sách</a></td>
                        <td colspan="2" class="hidden-xs text-center tongCong"><strong>Tổng Cộng: $1.99</strong></td>
                        <td colspan="2" >
                            <a href="#" class="btn btn-success btn-block">Thủ tục thanh toán <i class="fa fa-angle-right"></i></a>
                        </td>
                    </tr>
                </tfoot>
            </table>
        </div>
        <!-- Start Featured Product -->
        <section class="bg-light">
            <div class="container py-5">
                <div class="row text-center py-3">
                    <div class="col-lg-6 m-auto">
                        <h1 class="h1">Sách Nổi Bậc</h1>
                        <p>
                            Những cuốn sách hay nên đọc khi còn trẻ được định nghĩa là là những cuốn sách kinh điển nhất mọi thời đại.
                        </p>
                    </div>
                </div>
                <div class="row">
                    <c:url var="sachNoiBac1" value="/Resources/img/BanDatGiaBaoNhieu.jpg"/>
                    <c:url var="sachNoiBac2" value="/Resources/img/canBangCamXucLucGiongBao.jpg"/>
                    <c:url var="sachNoiBac3" value="/Resources/img/conChimXanhBietBayVe.jpg"/>
                    <div class="col-12 col-md-4 mb-4">
                        <div class="card h-100">
                            <a href="#" class="AnhSachNoiBac">
                                <img src="${sachNoiBac1}" class="card-img-top " alt="...">
                            </a>
                            <div class="card-body">
                                <ul class="list-unstyled d-flex justify-content-between">
                                    <li>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                    </li>
                                    <li class="text-muted text-right">212.00₫</li>
                                </ul>
                                <a href="#" class="h2 text-decoration-none text-dark">Bạn đắt giá bao nhiêu?</a>
                                <p class="card-text">
                                    là một tác phẩm văn học Trung Quốc của nhà văn Vãn Tình. Câu chuyện tản mạn xoay quanh các chủ đề tình yêu, hôn nhân, gia đình, sự nghiệp…
                                </p>
                                <p class="text-muted">Reviews (96)</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-4 mb-4">
                        <div class="card h-100">
                            <a href="/Client/sach/shop" class="AnhSachNoiBac">
                                <img src="${sachNoiBac2}" class="card-img-top" alt="...">
                            </a>
                            <div class="card-body">
                                <ul class="list-unstyled d-flex justify-content-between">
                                    <li>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                        <i class="text-muted fa fa-star"></i>
                                    </li>
                                    <li class="text-muted text-right">212.00₫</li>
                                </ul>
                                <a href="/Client/sach/shop" class="h2 text-decoration-none text-dark">Cân bằng cảm xúc, cả lúc bão giông</a>
                                <p class="card-text">
                                    một cuốn sách thực tế mà không kém phần khoa học – có thể sẽ phần nào giúp bạn tìm ra được định nghĩa hạnh phúc cho riêng mình.
                                </p>
                                <p class="text-muted">Reviews (78)</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-12 col-md-4 mb-4">
                        <div class="card h-100">
                            <a href="/Client/sach/shop" class="AnhSachNoiBac">
                                <img src="${sachNoiBac3}" class="card-img-top " alt="...">
                            </a>
                            <div class="card-body">
                                <ul class="list-unstyled d-flex justify-content-between">
                                    <li>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                        <i class="text-warning fa fa-star"></i>
                                    </li>
                                    <li class="text-muted text-right">212.00₫</li>
                                </ul>
                                <a href="/Client/sach/shop" class="h2 text-decoration-none text-dark">Con chim xanh biếc bay về</a>
                                <p class="card-text">
                                    Có thể gói gọn mối tình trong Con chim xanh biếc bay về trong bốn chữ từ - bi - hỷ - xả với mối tình tay tư trong một bối cảnh Sài Gòn ngày nay;
                                </p>
                                <p class="text-muted">Reviews (34)</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Featured Product -->
        <!-- Start Footer -->
        <footer class="bg-dark" id="tempaltemo_footer">
            <div class="container">
                <div class="row">

                    <div class="col-md-4 pt-5">
                        <h2 class="h2 text-success border-bottom pb-3 border-light logo">Book Shop</h2>
                        <ul class="list-unstyled text-light footer-link-list">
                            <li>
                                <i class="fas fa-map-marker-alt fa-fw"></i> Hồ Chí Mình, Việt Nam
                            </li>
                            <li>
                                <i class="fa fa-phone fa-fw"></i>
                                <a class="text-decoration-none" href="tel:034-432-5820">034-432-5820</a>
                            </li>
                            <li>
                                <i class="fa fa-envelope fa-fw"></i>
                                <a class="text-decoration-none" href="mailto:congdaivu107@gmail.com">congdaivu107@gmail.com</a>
                            </li>
                        </ul>
                    </div>

                    <div class="col-md-4 pt-5">
                        <h2 class="h2 text-light border-bottom pb-3 border-light">Các Loại Sách</h2>
                        <ul class="list-unstyled text-light footer-link-list">
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=chinh+tri+phap+luat">Sách Chính trị – pháp luật</a></li>
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=khoa+hoc+cong+nghe+kinh+te">Sách Khoa học công nghệ – Kinh tế</a></li>
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=van+hoc+nghe+thuat">Sách Văn học nghệ thuật</a></li>
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=van+hoa+xa+hoi+lich+su">Sách Văn hóa xã hội – Lịch sử</a></li>
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=giao+trinh">Sách Giáo trình</a></li>
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=truyen+tieu+thuyet">Sách Truyện, tiểu thuyết</a></li>
                            <li><a class="text-decoration-none" href="/Client/sach/search?q=sach+thieu+nhi">Sách thiếu nhi</a></li>
                        </ul>
                    </div>

                    <div class="col-md-4 pt-5">
                        <h2 class="h2 text-light border-bottom pb-3 border-light">Thông Tin Thêm</h2>
                        <ul class="list-unstyled text-light footer-link-list">
                            <li><a class="text-decoration-none" href="http://localhost:8080/Client/home">Trang Chủ</a></li>
                            <li><a class="text-decoration-none" href="http://localhost:8080/Client/contact">Liên Hệ</a></li>
                            <li><a class="text-decoration-none" href="http://localhost:8080/Client/contact">Vị Trí</a></li>
                            <li><a class="text-decoration-none" href="http://localhost:8080/Client/contact">Đặc Câu Hỏi</a></li>
                            <li><a class="text-decoration-none" href="http://localhost:8080/Client/contact">Liên Lạc</a></li>
                        </ul>
                    </div>

                </div>

                <div class="row text-light mb-4">
                    <div class="col-12 mb-3">
                        <div class="w-100 my-3 border-top border-light"></div>
                    </div>
                    <div class="col-auto me-auto">
                        <ul class="list-inline text-left footer-icons">
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="http://facebook.com/"><i class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                            </li>
                            <li class="list-inline-item border border-light rounded-circle text-center">
                                <a class="text-light text-decoration-none" target="_blank" href="https://www.linkedin.com/"><i class="fab fa-linkedin fa-lg fa-fw"></i></a>
                            </li>
                        </ul>
                    </div>
                    <!-- <div class="col-auto">
                        <label class="sr-only" for="subscribeEmail">Đăng Ký</label>
                        <div class="input-group mb-2">
                            <input type="text" class="form-control bg-dark border-light" id="subscribeEmail" placeholder="Nhập Mail Ở Đây">
                            <div class="input-group-text btn-success text-light">Đăng Ký</div>
                        </div>
                    </div> -->
                </div>
            </div>

            <div class="w-100 bg-black py-3">
                <div class="container">
                    <div class="row pt-2">
                        <div class="col-12">
                            <p class="text-left text-light">
                                Copyright &copy; 2024 | Thiết Kế Bởi <a rel="sponsored" href="https://www.facebook.com" target="_blank">Vũ Công Đại </a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>

        </footer>
        <!-- End Footer -->
        <script>
            $(document).ready(function () {
                updateRowTotal();
                $('.quantityTotal').change(function () {
                    updateRowTotal();
                });
            });

            function updateRowTotal() {
                var sum = 0.0;
                $('#cart > tbody > tr').each(function () {
                    var soLuong = $(this).find('.quantityTotal').val();
                    var gia = $(this).find('.priceTotal').val();
                    var tong = (soLuong * gia);
                    sum += tong;
                    $(this).find('.tongTotal').text(tong.toLocaleString('it-IT', {style: 'currency', currency: 'VND'}));
                });
                $('.tongCong').text("Tổng Cộng: " + sum.toLocaleString('it-IT', {style: 'currency', currency: 'VND'}));
            }
        </script>
    </body>
</html>
