/*

*/
var ko_subpage = "sub_pages/ko.jsp"
var header_url = "sub_pages/header.jsp";
var header_logo_url = "sub_pages/header_logo.jsp";
var sidebar_url = "sub_pages/sidebar.jsp";
var footer_url = "sub_pages/footer.jsp";
var main_page_url = "sub_pages/main_page.jsp";
var basket_url = "sub_pages/main_page.jsp";
var login_url = "sub_pages/login.jsp";
var register_url = "sub_pages/register_form.jsp";
var register_ok_url = "sub_pages/register_ok.jsp";
var kontakt_url = "sub_pages/kontakt_main.jsp";
var products_url = "sub_pages/products_main.jsp";

var registerNewUserUrl = "register";

var err_msg = "Something went wrong";
var dialog_name = "Error";

//Loading functions
function load_page_basic_components() {
	$("#header").load(header_url);
	$("#header-logo").load(header_logo_url);
	$("#sidebar").load(sidebar_url);
	$("#footer").load(footer_url);
}

function load_main_page() {
	$("#main").load(main_page_url);
}

function load_basket_page() {
	$("#main").load(basket_url);
}

function load_login_page() {
	$("#main").load(login_url);
}

function load_register_page() {
	
	$("#main").load(register_url);
}

function load_register_ok_page() {
	
	$("#main").load(register_ok_url);
}

function load_konakt_page() {
	
	$("#main").load(kontakt_url);
}

function load_products_page() {
	
	$("#main").load(products_url);
}

//Form submitions and validations
function registerNewUser() {
	var error_msg = "";
	
	if ($('#name').val() == "") {
		error_msg = "Empty user name provided";
	} else if ($('#surname').val() == "") {
		error_msg = "Empty user surname provided";
	} else if ($('#login').val() == "") {
		error_msg = "Empty user login provided";
	} else if ($('#password').val() == "" && $('#password_retype').val() == ""
			&& $('#password').val() == $('#password_retype').val()) {
		error_msg = "Empty user address provided";
	} else if ($('#city').val() == "") {
		error_msg = "Empty user city provided";
	} else if ($('#address').val() == "") {
		error_msg = "Empty user address provided";
	} else if ($('#loc_number').val() == "") {
		error_msg = "Empty user address provided";
	} else if ($('#zip_code').val() == "") {
		error_msg = "Empty user address provided";
	}
	
	if (error_msg != "") {
		alert(error_msg);
		return;
	}

//commented for future use
//    var options = {
//        url: registerNewUserUrl,
//        success: function(msg){
//            $("#main").html(msg);
//        },
//        error: function(msg){
//        	alert(err_msg);
//        }
//    };
//    
//    $('#register_form').submit(function(){
//	    $(this).ajaxSubmit(options);
//	    return false;
//	});
    $('#register_form').submit();
	
}