<%@include file="_inc/_check_session.jsp" %>
<%@include file="_inc/_header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean class="me.dannly.shop.data_source.CategoryDAO" id="categoryDAO"/>
<div class="container">
    <div class="row">
        <%@include file="_inc/_menu.jsp" %>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Categories</h1>
                <a href="category_edit.jsp" class="btn btn-primary">Add</a>
            </div>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th scope="col">Description</th>
                            <th scope="col">Active</th>
                            <th scope="col">Options</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${categoryDAO.elements}" var="category">
                            <tr>
                                <td>${category.id}</td>
                                <td>${category.name}</td>
                                <td>${category.description}</td>
                                <td>${category.active}</td>
                                <td>
                                    <a class="btn btn-warning" href="category_edit.jsp?id=${category.id}">Edit</a>
                                    <form action="category_processer" method="post" class="form-inline" id="formDelete${category.id}">
                                        <input type="hidden" value="${category.id}" name="delete_id"/>
                                        <button class="btn btn-danger" type="button" onclick="deletePrompt('${category.name}', ${category.id});">Delete</button>
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
<script type="text/javascript" src="assets/js/delete_prompt.js"></script>
</body>
</html>
