var textarea;
var counter;
var submit;

window.onload = function(){
	textarea = document.getElementsByTagName("textarea")[0];
	counter = document.getElementById("count");	submit = document.getElementById("submit");

	textarea.addEventListener("keyup", keyTyped, false);
	submit.addEventListener("click", post, false);
	disableSubmit();
}	

function disableSubmit(){	
	submit.disabled = true;
	submit.style.opacity = 0.2;
}

function enableSubmit(){
	submit.disabled = false;
	submit.style.opacity = 1;
}

function invalidateTzeet(){
	counter.style.color = "red";
	
}

function validateTzeet(){
	counter.style.color = "#8899a6";
}

function keyTyped(){
	var text = textarea.value;
	var n = text.length;	

	counter.innerHTML = 140 - n;

	if (n >= 0 && n <= 140){		
		validateTzeet();

		if (n == 0)
			disableSubmit();			
		else
			enableSubmit();	
	}	
	else if (n > 140){
		disableSubmit();
		invalidateTzeet();			
	}		
}

function post(){
	//alert("Postado!");
}


