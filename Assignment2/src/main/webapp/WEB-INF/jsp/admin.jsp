<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

    <title>
        Admin
    </title>

    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container">

<form method="post">
    <center>
        Title : <input type="text" name="title"/> <br>
        Author : <input type="text" name="author"/> <br>
        Genre :&nbsp <input type="text" name="genre"/> <br>
        Price :&nbsp <input type="text" name="price"/> <br>
        Quantity:<input type="text" name="quantity"/> <br><br>

        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  <input type="submit" value="Add Book" /> &nbsp&nbsp&nbsp

    </center>
</form>


<center>

    <br><br>

    <H1>Library Books</H1>
    <div class="container">
    <table class="table table-striped">
        <thead>
           <tr>

               <th>Title</th>
               <th>Author</th>
               <th>Genre</th>
               <th>Price</th>
               <th>Quantity</th>
               <th>Delete</th>
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
                <td><a type="button" class="btn btn-warning" href="/deleteBook?id=${book.id}">Delete</a> </td>


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