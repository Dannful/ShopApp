<%@page import="me.dannly.shop.domain.model.Product"%>
<%@include file="_inc/_check_session.jsp" %>
<%@include file="_inc/_header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean class="me.dannly.shop.data_source.ProductDAO" id="productDAO"/>
<jsp:useBean class="me.dannly.shop.data_source.CategoryDAO" id="categoryDAO"/>
<div class="container-fluid">
    <div class="row">
        <%@include file="_inc/_menu.jsp" %>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Products</h1>
                <a href="product_edit.jsp" class="btn btn-primary">Add</a>
            </div>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Description</th>
                            <th scope="col">Extra info</th>
                            <th scope="col">Weight</th>
                            <th scope="col">Highlighted</th>
                            <th scope="col">Active</th>
                            <th scope="col">Image</th>
                            <th scope="col">Category</th>
                            <th scope="col">Options</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${productDAO.elements}" var="product">
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.description}</td>
                                <td>${product.extraInfo}</td>
                                <td>${product.weight}</td>
                                <td>${product.highlighted}</td>
                                <td>${product.active}</td>
                                <td>${product.image}</td>
                                <c:set var="filter" value="id = ${product.categoriesId}"/>
                                <c:forEach items="${categoryDAO.getElementsByFilter('id = ?', product.id)}" var="category">
                                    <td>${category.name}</td>
                                </c:forEach>
                                <td>
                                    <a class="btn btn-warning" href="product_edit.jsp?id=${product.id}">Edit</a>
                                    <form action="product_processer" method="post" class="form-inline" id="formDelete${product.id}">
                                        <input type="hidden" value="${product.id}" name="delete_id"/>
                                        <button class="btn btn-danger" type="button" onclick="deletePrompt('${product.name}', ${product.id});">Delete</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>
<script src="assets/js/delete_prompt.js" type="text/javascript"></script>
</body>
</html>
