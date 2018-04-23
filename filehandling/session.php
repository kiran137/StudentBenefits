<?php
   include('config.php');
   session_start();
// check the usename and if faculty redirect to one page  other wise to another page.............
   $user_check = $_SESSION['login_use'];

   $ses_sql = mysqli_query($connection,"select userid from  where username = '$user_check' ");

   $row = mysqli_fetch_array($ses_sql,MYSQLI_ASSOC);

   $login_session = $row['username'];

   if(!isset($_SESSION['login_user'])){
      header("location:login.php");
   }
?>
