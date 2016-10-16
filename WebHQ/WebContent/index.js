var debug = true;
var homeShown = true;

var slideTime = 700;
var navigationTabs = [];
var logPrefix = "[*WebHQ*]";

var homeTab;
var resumeTab;
var projectsTab;
var connectTab;
var currentOpenTab = null;

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
		currentOpenTab.slideUp(slideTime, function() {
			currentOpenTab = $("#"+elementIdToOpen);
			currentOpenTab.slideDown(slideTime);
		});
	}
}

function showHome() {
	homeShown = true;
	currentOpenTab = null;
	$("#preambleDiv #row1").slideDown(slideTime);
	$("#preambleDiv #row3").slideDown(slideTime);
	$("#preambleDiv #row5").slideUp(slideTime);
}

function hideHome() {
	homeShown = false;
	$("#preambleDiv #row1").slideUp(slideTime);
	$("#preambleDiv #row3").slideUp(slideTime);
	$("#preambleDiv #row5").slideDown(slideTime);
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

function log(level, message) {
	if (debug) {
		var levelString;
		
		switch(level) {
			case 1:  levelString = "INFO "; break;
			case 2:  levelString = "WARN "; break;
			case 3:  levelString = "DEBUG"; break;
			case 4:  levelString = "ERROR"; break;
			default: levelString = "INFO "; break;
		}
		
		console.log(logPrefix + " " + levelString + " " + message);
	}
}

function init() {
	$("#resumeDiv").slideUp(0);
	$("#connectDiv").slideUp(0);
	$("#projectsDiv").slideUp(0);
	$("#preambleDiv #row5").slideUp(0);

	$("#project-website").slideUp(0);
	$("#project-computer").slideUp(0);
	$("#project-pi").slideUp(0);
	$("#project-vr").slideUp(0);
	
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
	
	$("#project-pi-toggle").click(function() { toggleProject('#project-pi-toggle', '#project-pi'); });
	$("#project-vr-toggle").click(function() { toggleProject('#project-vr-toggle', '#project-vr'); });
	$("#project-website-toggle").click(function() { toggleProject('#project-website-toggle', '#project-website'); });
	$("#project-computer-toggle").click(function() { toggleProject('#project-computer-toggle', '#project-computer'); });
});
































