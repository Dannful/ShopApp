<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav">
                <jsp:useBean class="me.dannly.shop.data_source.CategoryDAO" id="categoryDAO"/>
                <c:forEach items="${categoryDAO.elements}" var="category">
                    <li class="nav-item">
                        <a class="nav-link" href="./products.jsp?cid=${category.id}">${category.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</nav>