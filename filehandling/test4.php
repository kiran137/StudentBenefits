
<!DOCTYPE html>
<head>
	<link rel="stylesheet" type="text/css" href="test4.css" >
</head>

	<body>

	<div class="signin" >


	<h1 style ="color :darkblue; font-family: tahoma; text-shadow:5px 5px 10px white;">Signin here</h1>

	<form name="signin" action="sign.php" onsubmit="myfunction()" method="post">


		<p > name </p>
			<input type="text" placeholder="enter name" name="name" ></br>

			<p > username </p>
			<input type="text" placeholder=" user name is roll number" name="username" ></br>

			<p >password </p>
			<input type="password" placeholder="plz enter pwd"  name="password">

			</br>
			<p > confirm password </p>
			<input type="password" placeholder="confirm password" name="cpwd" ></br>

			<p > subject name</p>
				<input type="text" placeholder="enter subject id" name="subid" ></br>

			<input type="submit"   name="button" style="font-family: tahoma; text-align: center; font-size:15px; background-color: white; cursor:pointer; border-radius: 40px; background-color: white; box-shadow: 0 2.5px #666;transform: translateY(4px); width:110px;"
			   >



	</form>
</div>
</body>
</html>

<script type="text/javascript">
	var index=0;
function myfunction()
{
	allLetter(document.signin.name);

		allNumber(document.signin.username);

				allPsw(document.signin.password);

				allPsw(document.signin.cpwd);

					allCpsw(document.signin.cpwd,document.signin.password);
						if(index>0)
						{
							window.location.href="test4.php";
						}
					}
 function allCpsw(psw1,psw2)
 {

	 var todo = document.getElementById("todo");
	   var todo2 = document.getElementById("todo2");

	   if(todo != todo2) {
			 alert("pls re-enter the confirm password!!");
                index++;
								return false;
			 } else {
	   //  alert("Your Registration was successfull");
			 return true;
	     }
 }
  function allPsw(password) {
  	// body...
  	var letters =/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
  	var minNumberofChars=8;
  	var maxNumberofChars=16;
  	if(password.length<minNumberofChars||password.length>maxNumberofChars)
  	{
  		index++;
		alert("password must contain atleast 8 character and atmost 16 chars!!!");
        return false;

  	}
  		 if(password.value.match(letters)) {
				 return true;
			 }
			 else {


  		 	index++;
        alert("password should contain atleast one number and one Upper case and lower case...");
      return false;
    }
    return true;
  }
	function allLetter(inputtxt)
  {
   var letters = /^[A-Za-z]+$/;
   if(inputtxt.value.match(letters))
     {
     return  true;
     }

   else
     {
     alert("message: wrng input please enter valid name");
     index++;
     return false;
     }
  }
  function allNumber(inputtxt)
  {
   var letters = /^[0-9]+$/;
   if(inputtxt.value.match(letters))
     {
      return true;

     }
   else
     {
     alert("message :wrng input,please enter a valid roll number");
     index++;
     return false;
     }
  }

</script>
