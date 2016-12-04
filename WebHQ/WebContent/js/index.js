var slideTime = 700;
var homeShown = true;
var navigationTabs = [];

var homeTab;
var resumeTab;
var connectTab;
var projectsTab;
var currentOpenTab = null;

function navigateToPage(pageName) {
	sessionStorage.currentTab = currentOpenTab.attr("id");
	sessionStorage.currentScoll = $("#"+sessionStorage.currentTab).scrollTop();
	window.location.href = pageName;
}

function handleHome() {
	if (!homeShown) {
		currentOpenTab.slideUp(slideTime);
		handleNavTabs("");
		showHome();
	}
}

function handleClick(navElementId, divElementId) {
	handleNavTabs(navElementId);

	if (currentOpenTab == null) { 
		hideHome(); 
		currentOpenTab = $("#"+divElementId);
		currentOpenTab.slideDown(slideTime);
	}
	else { 
		closeOpenTab(divElementId);
	}

}

function handleHoverIn(ele) {
	var tmp = ele.parent();
	tmp.addClass("nav-hover");
	if (!tmp.hasClass("nav-selected")) {
		tmp.removeClass("nav-idle");
	}
}

function handleHoverOut(ele) {
	var tmp = ele.parent();
	tmp.removeClass("nav-hover");
	if (!tmp.hasClass("nav-selected")) {
		tmp.addClass("nav-idle");
	}
}

function handleKeys(event, element) {
	if(event.keyCode === 13){
		element.click();
	}
}

function closeOpenTab(elementIdToOpen) {
	if (currentOpenTab != null) {
		if (currentOpenTab.attr('id') !== elementIdToOpen) {
			currentOpenTab.slideUp(slideTime, function() {
				currentOpenTab = $("#"+elementIdToOpen);
				currentOpenTab.slideDown(slideTime);
			});			
		}
	}
}

function showHome() {
	homeShown = true;
	currentOpenTab = null;
	$("#homeDiv #row1").slideDown(slideTime);
	$("#homeDiv #row3").slideDown(slideTime);
	$("#homeDiv #row5").slideUp(slideTime);
	
	sessionStorage.removeItem("currentTab");
	sessionStorage.removeItem("currentScoll");
}

function hideHome(instant) {
	homeShown = false;
	var tmpTime = slideTime;
	
	if (instant == true) {
		slideTime = 0;
	}
	
	$("#homeDiv #row1").slideUp(slideTime);
	$("#homeDiv #row3").slideUp(slideTime);
	$("#homeDiv #row5").slideDown(slideTime);
	
	slideTime = tmpTime;
}

function handleNavTabs(elementId) {
	var tmp;
	var currentId;
	var currentTab;
	for (var i = 0; i < navigationTabs.length; i++) {
		currentTab = navigationTabs[i];
		currentId = currentTab.attr("id");
		tmp = currentTab.parent();
		
		tmp.removeClass("nav-idle");
		tmp.removeClass("nav-hover");
		tmp.removeClass("nav-selected");
		
		if (currentId !== elementId) {
			tmp.addClass("nav-idle");
		}
		else {
			if (elementId !== "nav-home") {
				tmp.addClass("nav-selected");
			}
			else {
				tmp.addClass("nav-idle");
			}
		}
	}
}

function toggleProject(spanId, panelId) {
	 var element = $(panelId);
	 var glyphSpan = $(spanId);
	 if (glyphSpan.hasClass("glyphicon-collapse-down")) {
		 glyphSpan.removeClass("glyphicon-collapse-down");
		 glyphSpan.addClass("glyphicon-collapse-up");
		 element.slideDown(slideTime);
	 }
	 else {
		 glyphSpan.removeClass("glyphicon-collapse-up");
		 glyphSpan.addClass("glyphicon-collapse-down");
		 element.slideUp(slideTime);
	 }
}

function init() {
	$("#resumeDiv").slideUp(0);
	$("#connectDiv").slideUp(0);
	$("#projectsDiv").slideUp(0);
	$("#homeDiv #row5").slideUp(0);
	
	homeTab = $("#nav-home");
	resumeTab = $("#nav-resume");
	connectTab = $("#nav-connect");
	projectsTab = $("#nav-projects");
	
	navigationTabs.push(homeTab);
	navigationTabs.push(resumeTab);
	navigationTabs.push(connectTab);
	navigationTabs.push(projectsTab);
}

$(document).ready(function(){
	init();
	
	homeTab.click(function() { handleHome(); });
	homeTab.keyup(function(event) { handleKeys(event, this); });
	homeTab.mouseout(function() { handleHoverOut(homeTab); });
	homeTab.mouseover(function() { handleHoverIn(homeTab); });
	
	connectTab.keyup(function(event) { handleKeys(event, this); });
	connectTab.mouseout(function() { handleHoverOut(connectTab); });
	connectTab.mouseover(function() { handleHoverIn(connectTab); });
	connectTab.click(function() { handleClick("nav-connect", "connectDiv"); });
	
	resumeTab.keyup(function(event) { handleKeys(event, this); });
	resumeTab.mouseout(function() { handleHoverOut(resumeTab); });
	resumeTab.mouseover(function() { handleHoverIn(resumeTab); });
	resumeTab.click(function() { handleClick("nav-resume", "resumeDiv"); });
	
	projectsTab.keyup(function(event) { handleKeys(event, this); });
	projectsTab.mouseout(function() { handleHoverOut(projectsTab); });
	projectsTab.mouseover(function() { handleHoverIn(projectsTab); });
	projectsTab.click(function() { handleClick("nav-projects", "projectsDiv"); });
	
	if (sessionStorage.currentTab) {
		currentOpenTab = $("#"+sessionStorage.currentTab);
		hideHome(true);
		handleNavTabs("nav-" + sessionStorage.currentTab.substring(0, sessionStorage.currentTab.length-3));
		currentOpenTab.slideDown(0);
		
		if (sessionStorage.currentScoll) {
			$("#"+sessionStorage.currentTab).scrollTop(sessionStorage.currentScoll);
		}
	}
});
































