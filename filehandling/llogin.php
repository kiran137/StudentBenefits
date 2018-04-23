<?php
include("config.php");
   session_start();

   if($_SERVER["REQUEST_METHOD"] == "POST") {
      // username and password sent from form

      $myusername = mysqli_real_escape_string($connection,$_POST['username']);
      $mypassword = mysqli_real_escape_string($connection,$_POST['password']);

      $sql = "SELECT * FROM faculty WHERE  userid= '$myusername' and psw = '$mypassword'";
      $result = mysqli_query($connection,$sql);
     $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
      $count = mysqli_num_rows($result);

      $sq = "SELECT * FROM student WHERE userid='$myusername' and psw='$mypassword'";
      $res = mysqli_query($connection,$sq);
     $ro= mysqli_fetch_array($res,MYSQLI_ASSOC);
      $count1 = mysqli_num_rows($res);

      // If result matched $myusername and $mypassword, table row must be 1 row
      if($count==1 || $count1==1) {


       $_SESSION['username'] =$_POST['username'];

       if($row['usertype']==1) {
       header("location: facnav.html");
     }
     else {
    header("location: stunav.php");
     }
      }
      else {
         $error = "Your Login Name or Password is invalid";
         echo $error;
      }

   }
?>
