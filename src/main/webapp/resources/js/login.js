
window.onload = function(){
	var registe = document.getElementById("registe");
	var login = document.getElementById("login");
	var loginBox = document.getElementById("loginBox");
	var registeBox = document.getElementById("registeBox");
	var loginPage = document.getElementById("loginPage");
	var btn = document.getElementById("btn");
	
	registe.onclick = function(){
		loginBox.style.display = 'none'
		registeBox.style.display = 'block'
	}
	login.onclick = function(){
		loginBox.style.display = 'block'
		registeBox.style.display = 'none'
	}
	btn.onclick = function(){
		window.location.href="http://localhost:8080/work/student.jsp" 
	}
	retBtn.onclick = function () {
        window.location.href="http://localhost:8080/student/toStudent"
    }



}

