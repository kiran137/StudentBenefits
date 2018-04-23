<?php
include("config.php");
session_start();

?>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">ARPANDER</a>
    </div>
    <ul class="nav navbar-nav" >
      <li class="active"><a href="#">Home</a></li>

      <li><a href="#">About Us</a></li>
      <li> <a href="changepwd.html" >Change password</a></li>
      <li> <a href="viewfile.php" >Viewfiles</a></li>

    </ul>
    <ul class="nav navbar-nav navbar-right">

      <li><a href="logout.php"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>









</body>
</html>


​
