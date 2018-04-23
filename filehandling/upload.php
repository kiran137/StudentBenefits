<?php
include("config.php");
session_start();
if(isset($_POST['btn-upload']))
{

 $file = rand(1000,100000)."-".$_FILES['file']['name'];
    $file_loc = $_FILES['file']['tmp_name'];
 $file_size = $_FILES['file']['size'];
 $file_type = $_FILES['file']['type'];
 $folder="facultyuploadfile/";
 $batch=$_POST['batch'];
 $sec=$_POST['section'];
 $subid=1;
 move_uploaded_file($file_loc,$folder.$file);
 $sql="INSERT INTO tbl_uploads VALUES('$subid','$batch','$sec','$file','$file_type','$file_size')";
 mysqli_query($connection,$sql);
 header("Location:facnav.html");
}
?>
