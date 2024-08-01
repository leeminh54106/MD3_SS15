<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 7/30/2024
  Time: 11:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<!-- Mirrored from hotflix.volkovdesign.com/admin/catalog.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 26 Jul 2024 09:43:03 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/slimselect.css">
    <link rel="stylesheet" href="resources/css/admin.css">

    <!-- Icon font -->
    <link rel="stylesheet" href="resources/webfont/tabler-icons.min.css">

    <!-- Favicons -->
    <link rel="icon" type="image/png" href="resources/icon/favicon-32x32.png" sizes="32x32">
    <link rel="apple-touch-icon" href="resources/icon/favicon-32x32.png">

    <meta name="description" content="Online Movies, TV Shows & Cinema HTML Template">
    <meta name="keywords" content="">
    <meta name="author" content="Dmitry Volkov">
    <title>Bài tập</title>
</head>

<body>

<!-- header -->
<header class="header">
    <div class="header__content">
        <!-- header logo -->
        <a href="" class="header__logo">
            <img src="resources/img/logo.svg" alt="">
        </a>
        <!-- end header logo -->

        <!-- header menu btn -->
        <button class="header__btn" type="button">
            <span></span>
            <span></span>
            <span></span>
        </button>
        <!-- end header menu btn -->
    </div>
</header>
<!-- end header -->

<!-- sidebar -->
<div class="sidebar">
    <!-- sidebar logo -->
    <a href="" class="sidebar__logo">
        <img src="resources/img/logo.svg" alt="">
    </a>
    <!-- end sidebar logo -->

    <!-- sidebar user -->
    <div class="sidebar__user">
        <div class="sidebar__user-img">
            <img src="resources/img/user.svg" alt="">
        </div>

        <div class="sidebar__user-title">
            <span>Admin</span>
            <p>Nguyễn Trường Sơn</p>
        </div>

        <button class="sidebar__user-btn" type="button">
            <i class="ti ti-logout"></i>
        </button>
    </div>
    <!-- end sidebar user -->

    <!-- sidebar nav -->
    <div class="sidebar__nav-wrap">
        <ul class="sidebar__nav">
            <!-- dropdown -->
            <li class="sidebar__nav-item">
                <a class="sidebar__nav-link" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="ti ti-category"></i>
                    <span>Danh mục</span>
                    <i class="ti ti-chevron-down"></i>
                </a>

                <ul class="dropdown-menu sidebar__dropdown-menu">
                    <li><a href="/category-controller">Hiển thị danh mục</a></li>
                </ul>
            </li>
            <!-- end dropdown -->
            <!-- dropdown -->
            <li class="sidebar__nav-item">
                <a class="sidebar__nav-link" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="ti ti-address-book"></i>
                    <span>Sách</span>
                    <i class="ti ti-chevron-down"></i>
                </a>

                <ul class="dropdown-menu sidebar__dropdown-menu">
                    <li><a href="/book-controller">Hiển thị sách</a></li>
                </ul>
            </li>
            <!-- end dropdown -->
        </ul>
    </div>
    <!-- end sidebar nav -->

    <!-- sidebar copyright -->
    <div class="sidebar__copyright">© HOTFLIX, 2019—2024. <br>Create by <a href="https://themeforest.net/user/dmitryvolkov/portfolio" target="_blank">Dmitry Volkov</a></div>
    <!-- end sidebar copyright -->
</div>
<!-- end sidebar -->

<!-- main content -->
<main class="main">
    <div class="container-fluid">
        <div class="row">
            <!-- main title -->
            <div class="col-12">
                <div class="main__title">
                    <h2>Danh mục</h2>
                </div>
            </div>
            <!-- end main title -->

            <!-- items -->
            <div class="col-12">
                <div class="catalog catalog--1">
                    <table class="catalog__table">
                        <thead>
                        <tr style="text-align: center">
                            <th>Mã danh mục</th>
                            <th>Tên danh mục</th>
                            <th>Trạng thái</th>
                        </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <td >
                                    <div class="catalog__text" style="text-align: center; width: 100%; display: block;" >${categoryDetail.id}</div>
                                </td>
                                <td >
                                    <div class="catalog__text" style="text-align: center; width: 100%; display: block;">${categoryDetail.name}</div>
                                </td>
                                <td >
                                    <div class="catalog__text ${categoryDetail.status ? 'catalog__text--green' : 'catalog__text--red'}" style="text-align: center; width: 100%; display: block;" >
                                            ${categoryDetail.status ? "Hoạt động" : "Không hoạt động"}
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- end items -->
        </div>
    </div>
</main>
<!-- end main content -->
<!-- JS -->
<script src="resources/js/bootstrap.bundle.min.js"></script>
<script src="resources/js/slimselect.min.js"></script>
<script src="resources/js/smooth-scrollbar.js"></script>
<script src="resources/js/admin.js"></script>
</body>

<!-- Mirrored from hotflix.volkovdesign.com/admin/catalog.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 26 Jul 2024 09:43:03 GMT -->
</html>