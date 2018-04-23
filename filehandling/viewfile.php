
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

<?php
 include("config.php");
 session_start();
 $sql="SELECT * FROM tbl_uploads";
 $result_set=mysqli_query($connection,$sql);
 echo "<table>";

 echo "
  <table width='80%' border='1'>
     <tr>
     <td>File Name   </td>
     <td>File Type</td>
     <td>File Size(KB)</td>
     <td>View</td>
     </tr>
";

while($row=mysqli_fetch_array($result_set,MYSQLI_ASSOC))
{
   echo "<tr>";
  echo "<td>".$row['id']."</td>";
  echo "<td>".$row['type']."</td>";
  echo "<td>".$row['size']."</td>";
  echo "<td><a href='facultyuploadfile\' ".$row['id'] ." target='_blank' >view file</a></td>";

 }
 echo "</table>";


?>

​
