$(document).on("click", "#btnCreateproduct", function(event){ 
	
	
	// -----------------Clear alerts---------------------
	
	
 $("#alertSuccess").text("Successfully Inserted "); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
// Form validation-------------------
var status = validateproductForm(); 
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 
 
 
 
// ----------------If valid------------------------


var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "productAPI", 
 type : type, 
 data : $("#formproduct").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onproductSaveComplete(response.responseText, status); 
 } 
 });
});


// -----------------------CLIENT-MODEL-------------------------------------------


function validateproductForm(){
	// code
	if ($("#id").val().trim() == ""){
		return "Insert id.";
	}
	// Name
	if ($("#name").val().trim() == ""){
		return "Insert Name.";
	}

	// price-------------------------------
	if ($("#amount").val().trim() == ""){
		return "Insert amount.";
	}
	// Description-------------------------------
	if ($("#des").val().trim() == ""){
		return "Insert description.";
	}
	
	
	return true;
}




function onproductSaveComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully saved."); 
 $("#alertSuccess").show(); 
 $("#divItemsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error saving."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while saving.."); 
 $("#alertError").show(); 
 } 
$("#hidItemIDSave").val(""); 
 
}




$(document).on("click", ".btnRemove", function(event) { 
		 $.ajax( 
		 	{ 
		 	url : "productAPI", 
		 	type : "DELETE", 
		 	data : "id=" + $(this).data("id"),
		 	dataType : "text", 
		 	complete : function(response, status) { 
		 		onproductDeleteComplete(response.responseText, status); 
		 	} 
		}); 
})
		
function onproductDeleteComplete(response, status){ 
	if (status == "success") { 
 		var resultSet = JSON.parse(response); 
 		if (resultSet.status.trim() == "success") { 
 			$("#alertSuccess").text("Successfully deleted."); 
 			$("#alertSuccess").show(); 
 			$("#divItemsGrid").html(resultSet.data); 
 		} else if (resultSet.status.trim() == "error") { 
 			$("#alertError").text(resultSet.data); 
 			$("#alertError").show(); 
 		} 
 	} else if (status == "error") { 
 		$("#alertError").text("Error deleting."); 
 		$("#alertError").show(); 
 	} else { 
 		$("#alertError").text("Unknown error deleting.."); 
 		$("#alertError").show(); 
 	} 
}

// -----------------------------UPDATE---------------------------------------------



$(document).on("click", ".btnUpdate", function(event)
{ 
	 $("#hidItemIDSave").val($(this).data("id")); 
		 $("#id").val($(this).closest("tr").find('td:eq(0)').text()); 
		 $("#name").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#amount").val($(this).closest("tr").find('td:eq(2)').text()); 
		 $("#des").val($(this).closest("tr").find('td:eq(3)').text()); 
		 
		});