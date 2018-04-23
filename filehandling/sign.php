<?php
include("config.php");
session_start();
if($_SERVER["REQUEST_METHOD"] == "POST" ) {

          $name =  $_POST['name'];
         $username = $_POST['username'];
           $password = $_POST['password'];
           $usertype=1;
           $subid= $_POST['subid'];


            $sql = "SELECT * FROM faculty WHERE userid = '$username' and psw = '$password'";
           $result = mysqli_query($connection,$sql);
          $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
         $count = mysqli_num_rows($result);

               if($count==1) {
                 echo "USER ALREADY EXITS!!";
                // header("Loaction:home.html");
                echo "<a href='home.html'> Cilck Here to go Home </a>";
                }
                else {

            $sqll = "INSERT INTO faculty  VALUES ('$name' , '$username' , '$password' , '$usertype' , '$subid' )";

            $resultt=mysqli_query($connection,$sqll);
            $_SESSION['username'] =$_POST['username'];
            $_SESSION['subid'] =$_POST['subid'];



  }
  header("Loaction:home.html");

}
?>
