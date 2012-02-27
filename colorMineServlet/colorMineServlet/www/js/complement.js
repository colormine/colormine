$(document).ready(function() {

	var colorBlock = $('#color1');
	var complementBlock = $('#color2');

	var triad1 = $('#color3');
	var triad2 = $('#color4');

	function normalize(color) {
		return parseInt(color.substring(1,3), 16) + '-' +
			parseInt(color.substring(3,5), 16) + '-' +
			parseInt(color.substring(5), 16);
	}

	function rgbToHex(color) {
		rgb = color.match(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/);
		function hex(x) {
			return ("0" + parseInt(x).toString(16)).slice(-2);
		}
		return normalize("#" + hex(rgb[1]) + hex(rgb[2]) + hex(rgb[3]));
	}

	function setComplementColorBlock(color) {
		complementBlock.css('background-color',color.color);
	}

	function setTriadBlocks(color) {
		triad1.css('background-color',color.color[0]);
		triad2.css('background-color',color.color[1]);
	}

	function setColorBlocks(color) {
		colorBlock.css('background-color', color);
	}
	
	function updateColorBlocks() {
		var color = colorBlock.css('background-color');
		var data = {
			color: rgbToHex(color),
		};

		$.get('/ColorMine/ComplementMath', data, setComplementColorBlock);
		$.get('/ColorMine/TriadMath', data, setTriadBlocks);
	}

	$('#colorPickerA').farbtastic(setColorBlocks);
	$('#update').bind('click', updateColorBlocks);
});
