<?php
include("config.php");
session_start();
if($_SERVER["REQUEST_METHOD"] == "POST") {

           $password = $_POST['password'];
           $cpsw=$_POST['cpwd'];
          $username= $_SESSION['username'] ;
            echo $username;
            $sql = "SELECT * FROM faculty WHERE userid = '$username' ";
           $result = mysqli_query($connection,$sql);
          $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
         $count = mysqli_num_rows($result);
            echo $count;
               if($count==1) {
                 if($cpsw==$password){
                  $sql="UPDATE student SET psw='$cpsw' where userid='$username'";
                  header("Loacation: stunav.html");
                }
                 }
                else {
                    header("Loacation: changepwd.html");
             }
}
?>
