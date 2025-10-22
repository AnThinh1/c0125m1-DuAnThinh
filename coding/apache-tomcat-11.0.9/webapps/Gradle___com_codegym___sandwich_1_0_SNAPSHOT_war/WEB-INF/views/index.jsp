<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h2>Choose condiments for your Sandwich</h2>

<form action="save" method="post">
    <input type="checkbox" name="condiment" value="Lettuce"> Lettuce <br>
    <input type="checkbox" name="condiment" value="Tomato"> Tomato <br>
    <input type="checkbox" name="condiment" value="Mustard"> Mustard <br>
    <input type="checkbox" name="condiment" value="Sprouts"> Sprouts <br>
    <input type="checkbox" name="condiment" value="Onion"> Onion <br>
    <br>
    <input type="submit" value="Save">
</form>

</body>
</html>
