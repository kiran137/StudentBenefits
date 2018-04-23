
<?php
$servername='localhost';
$username='root';
$password='';
$databasename='filehandling';

$connection = mysqli_connect($servername,$username,$password,$databasename);
if (!$connection) {
die("Connection failed: " . $con->connect_error);
}
?>
