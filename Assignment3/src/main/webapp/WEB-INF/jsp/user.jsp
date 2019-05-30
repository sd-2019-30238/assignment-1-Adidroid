<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

    <title>
        Your Books Everywhere
    </title>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <center>

        <br><br>
        <H1>Library Books</H1> <br>
        <div class="container">
            <table class="table table-striped">
                <thead>
                <tr>

                    <th>Title</th>
                    <th>Author</th>
                    <th>Genre</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Buy</th>

                </tr>
                </thead>

                <tbody>
                <c:forEach items="${books}" var="book" >
                    <tr>
                        <td>${book.title}</td>
                        <td>${book.author}</td>
                        <td>${book.genre}</td>
                        <td>${book.price}</td>
                        <td>${book.quantity}</td>
                        <td><a type="button" class="btn btn-warning" href="/buyBook?id=${book.id}">Borrow</a> </td>


                    </tr>



                </c:forEach>


                </tbody>
            </table>


    </center>

    <br><br>


        <center>

            <br><br>
            <H1> My Books</H1> <br>
            <div class="container">
                <table class="table table-striped">
                    <thead>
                    <tr>

                        <th>Title</th>
                        <th>Author</th>
                        <th>Genre</th>
                        <th>Price</th>
                        <th>Return</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach items="${myBooks}" var="book" >
                        <tr>
                            <td>${book.title}</td>
                            <td>${book.author}</td>
                            <td>${book.genre}</td>
                            <td>${book.price}</td>

                            <td><a type="button" class="btn btn-success"  href="/returnBook?id=${book.id}">Return</a> </td>

                        </tr>



                    </c:forEach>


                    </tbody>
                </table>


        </center>


    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</div>

</body>

</html>