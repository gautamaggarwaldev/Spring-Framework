<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>User Page</title>
    <link rel="stylesheet" href="/assets/style.css">
</head>
<body>

    <h1>${message}</h1>

    <form action="/greet" method="post">
        <label for="name">Enter your Name:</label>
        <input type="text" id="name" name="name">

        <button type="submit">Submit</button>
    </form>

</body>
</html>