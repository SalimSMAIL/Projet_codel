$(document ).ready(function(){
	console.log("coucou");
	ShowListGroup();	
});

function ShowListGroup(){
	
	$.ajax({
		type: "GET",
		url : "displayContactGroup",
		dataType : 'json',
		success : function(data) {
			var resultat = data;
			console.log(resultat.response);
			if (resultat.response==200)
			{
				for (i=0; i<resultat.groups.length; i++)
					showLists(groups[i]); 
			}else{
				var DivListGroup = $("#listGroups"); 
				var DivLists = 'Aucun groupe ';
				DivListGroup.append(DivLists); 
			}
		},
		error : function(XHR, testStatus, errorThrown) 
		{
			console.log("status: " + XHR.status + ", erreur: " + XHR.responseText);
		}
	});
}

function showLists(resultat)
{	
		var DivListGroup = $("#listGroups"); 
		var DivLists = '<ul><li> <i class="icon-users icon text-success"></i> <span class="font-bold">'+resultat.name+'</span></li></ul> ';
		DivListGroup.append(DivLists); 	

}






















