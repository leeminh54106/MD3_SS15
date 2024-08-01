<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 7/31/2024
  Time: 12:49 AM
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


                    <div class="main__title-wrap">
                        <a href="/category-controller?action=add" class="main__title-link main__title-link--wrap">Thêm danh mục</a>

                        <!-- search -->
                        <form action="/category-controller" method="post" class="main__title-form">
                            <input type="text" name="categoryName" placeholder="Tìm kiếm danh mục">
                            <button type="submit" name="action" value="search">
                                <i class="ti ti-search"></i>
                            </button>
                        </form>
                        <!-- end search -->
                    </div>
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
                            <th>Hành động</th>
                        </tr>
                        </thead>

                        <tbody>
                            <c:forEach items = "${categories}" var = "c">
                                <tr>
                                    <td >
                                        <div class="catalog__text" style="text-align: center; width: 100%; display: block;" >${c.id}</div>
                                    </td>
                                    <td >
                                        <div class="catalog__text" style="text-align: center; width: 100%; display: block;">${c.name}</div>
                                    </td>
                                    <td >
                                        <div class="catalog__text ${c.status ? 'catalog__text--green' : 'catalog__text--red'}" style="text-align: center; width: 100%; display: block;" >
                                                ${c.status ? "Hoạt động" : "Không hoạt động"}
                                        </div>
                                    </td>
                                    <td style="text-align: center">
                                        <div class="catalog__btns">
                                            <a href="/category-controller?action=detail&id=${c.id}" class="catalog__btn catalog__btn--view">
                                                <i class="ti ti-eye"></i>
                                            </a>
                                            <a href="/category-controller?action=edit&id=${c.id}" class="catalog__btn catalog__btn--edit">
                                                <i class="ti ti-edit"></i>
                                            </a>
                                            <a href="/category-controller?action=delete&id=${c.id}" class="catalog__btn catalog__btn--delete" data-bs-target="#modal-delete">
                                                <i class="ti ti-trash"></i>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- end items -->
        </div>
    </div>
</main>
<!-- end main content -->

<!-- status modal -->
<div class="modal fade" id="modal-status" tabindex="-1" aria-labelledby="modal-status" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal__content">
                <form action="#" class="modal__form">
                    <h4 class="modal__title">Status change</h4>

                    <p class="modal__text">Are you sure about immediately change status?</p>

                    <div class="modal__btns">
                        <button class="modal__btn modal__btn--apply" type="button"><span>Apply</span></button>
                        <button class="modal__btn modal__btn--dismiss" type="button" data-bs-dismiss="modal" aria-label="Close"><span>Dismiss</span></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- end status modal -->

<!-- delete modal -->
<div class="modal fade" id="modal-delete" tabindex="-1" aria-labelledby="modal-delete" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal__content">
                <form action="#" class="modal__form">
                    <h4 class="modal__title">Item delete</h4>

                    <p class="modal__text">Are you sure to permanently delete this item?</p>

                    <div class="modal__btns">
                        <button class="modal__btn modal__btn--apply" type="button"><span>Delete</span></button>
                        <button class="modal__btn modal__btn--dismiss" type="button" data-bs-dismiss="modal" aria-label="Close"><span>Dismiss</span></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- end delete modal -->

<!-- JS -->
<script src="resources/js/bootstrap.bundle.min.js"></script>
<script src="resources/js/slimselect.min.js"></script>
<script src="resources/js/smooth-scrollbar.js"></script>
<script src="resources/js/admin.js"></script>
</body>

<!-- Mirrored from hotflix.volkovdesign.com/admin/catalog.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 26 Jul 2024 09:43:03 GMT -->
</html>