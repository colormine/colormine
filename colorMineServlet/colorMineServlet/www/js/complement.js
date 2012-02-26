$(document).ready(function() {

		var colorBlock = '#color1'
		var ComplementBlock = '#color2'

		var Triad1 = "#color3"
		var Triad2 = "#color4"

		function normalize(color) {
		return parseInt(color.substring(1,3), 16) + '-' +
			parseInt(color.substring(3,5), 16) + '-' +
			parseInt(color.substring(5), 16);
		}


		function setComplementColorBlock(color) {
			$(ComplementBlock).css('background-color',color.color);
		}

		function setTriadBlocks(color) {
			$(Triad1).css('background-color',color.color[0]);
			$(Triad2).css('background-color',color.color[1]);
		}

		function setColorblocks(color) {
			$(colorBlock).css('background-color',color);

			var data = {
				color: normalize(color),
				};

			var test =$.get('/ColorMine/ComplementMath',data,function(value){
			setComplementColorBlock(value)});

			var data = {
				color: normalize(color),
				};

			var test =$.get('/ColorMine/TriadMath',data,function(value){
			setTriadBlocks(value)});

		}

		

	$('#colorPickerA').farbtastic(function(color) { setColorblocks(color); });
});
