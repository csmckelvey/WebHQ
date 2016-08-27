var debug = true;
var homeShown = false;

var slideTime = 700;
var toggleTime = 700;
var animationTime = 300;

var parent3Height = 0;
var logPrefix = "[*WebHQ*]";
var navigationTabs = [];

$(document).ready(function(){
	init();
	initLinkClickHandlers();
});

function init() {
	navigationTabs.push($("#nav-home"));
	navigationTabs.push($("#nav-projects"));
	navigationTabs.push($("#nav-resume"));
	navigationTabs.push($("#nav-contact"));
}

function initLinkClickHandlers() {
	var tmp;
	for (var i = 0; i < navigationTabs.length; i++) {
		tmp = navigationTabs[i];
		tmp.click(function(){ handleLinkClick($(this)); });
		tmp.mouseout(function() { handleLinkHoverOut($(this)); });
		tmp.mouseover(function() { handleLinkHoverIn($(this)); });
	}
}

function handleLinkHoverIn(ele) {
	var tmp = ele.parent();
	tmp.addClass("nav-hover");
	if (!tmp.hasClass("nav-selected")) {
		tmp.removeClass("nav-idle");
	}
}

function handleLinkHoverOut(ele) {
	var tmp = ele.parent();
	tmp.removeClass("nav-hover");
	if (!tmp.hasClass("nav-selected")) {
		tmp.addClass("nav-idle");
	}
}

function handleLinkClick(ele) {
	var tmp;
	var elementId = ele.attr("id");
	
	for (var i = 0; i < navigationTabs.length; i++) {
		tmp = navigationTabs[i].parent();
		
		tmp.removeClass("nav-hover");
		tmp.removeClass("nav-selected");
		
		if (navigationTabs[i].attr("id") !== elementId) {
			tmp.addClass("nav-idle");
		}
		else {
			tmp.addClass("nav-selected");
		}
	}
}

function introAnimation() {
	var rows = [];
	var parents = [];
	
	rows.push($("#preamble-row-2"));
	rows.push($("#preamble-row-3"));
	rows.push($("#preamble-row-4"));
	
	parents.push($("#preamble-row-2-parent"));
	parents.push($("#preamble-row-3-parent"));
	parents.push($("#preamble-row-4-parent"));
	
	//Set fixed height to parents' current height so the animation doesn't move content all over the page
	for (var i = 0; i < parents.length; i++) {
		parents[i].css({ "height" : (parents[i].height())});
	}
	
	//Hide all rows involved in animation
	for (var j = 0; j < rows.length; j++) {
		rows[j].slideUp(0, "linear");
	}
	
	//Start animation chain - no generic loop here as the animations might be customized
	rows[0].slideDown(animationTime, "linear", function() {
		rows[1].slideDown(animationTime, "linear", function() {
			rows[2].slideDown(animationTime, "linear");
		});
	});
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
