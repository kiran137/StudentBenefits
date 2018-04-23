<?php
include("config.php");
session_start();
if($_SERVER["REQUEST_METHOD"] == "POST") {

         $name =  $_POST['name'];
         $username = $_POST['username'];
           $password = $_POST['password'];
           $usertype=2;
           $subid= $_POST['subid'];
          $batch = $_POST['select-profession'];
          $sec=$_POST['section'];

            $sql = "SELECT * FROM student WHERE userid = '$username' and psw = '$password'";
           $result = mysqli_query($connection,$sql);
          $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
         $count = mysqli_num_rows($result);
          //  echo $batch;
               if($count==1) {
                 echo "USER ALREADY EXITS!!";
                 header("location: facnav.html");
                }
                else {

           $sqll = "INSERT INTO student VALUES ('$username', '$password' ,'$usertype' ,'$name' ,'$batch', '$subid','$sec' )";

            $resultt=mysqli_query($connection,$sqll);
             header("location:facnav.html");
             }
}
?>
