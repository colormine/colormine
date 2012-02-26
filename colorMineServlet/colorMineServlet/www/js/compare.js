$(document).ready(function() {

	var scoreDiv = $('#score');
	var complementDiv = $('#complement');
	var colorA = $('#colorA');
	var colorB = $('#colorB');

	function normalize(color) {
		return parseInt(color.substring(1,3), 16) + '-' +
			parseInt(color.substring(3,5), 16) + '-' +
			parseInt(color.substring(5), 16);
	}

	function rgbToHex(R,G,B) {
		return toHex(R)+toHex(G)+toHex(B)
	}

	function toHex(n) {
 		n = parseInt(n,10);
 		if (isNaN(n)) return "00";
 		n = Math.max(0,Math.min(n,255));
 		return "0123456789ABCDEF".charAt((n-n%16)/16) + "0123456789ABCDEF".charAt(n%16);
	}

	function updateScore(scoreData) {
		var score = scoreData.score;
		var description;
		if(score <= 1000) {
			 scoreDiv.attr('class', 'goodMatch');
			 description = 'Great!';
		} else if(score <= 2000) {
			 scoreDiv.attr('class', 'badMatch');
			 description = 'Getting closer';
		} else {
			scoreDiv.attr('class', 'terribleMatch');
			description = 'Terrible!';
		}
		scoreDiv.html(description + ' - ' + parseInt(score));
	}
	
	function isComplement(complementData) {
		var score = complementData.score;
		var description;
		
		if(score == 1) {
			 complementDiv.attr('class', 'goodMatch');
			 description = 'Complements';
		} else if(score == 0) {
			 complementDiv.attr('class', 'badMatch');
			 description = 'Not Complements';
		} else {
			complementDiv.attr('class', 'terribleMatch');
			description = 'Error!';
		}
		complementDiv.html(description + ' - ' + parseInt(score));
	}
	

	function compare(item, color) {
		item.val(color);
		item.css('backgroundColor', color);
		
		var data = {
			method: 'compare',
			type: 'rgb',
			value1: normalize(colorA.val()),
			value2: normalize(colorB.val())
		};
		
		$.get('/ColorMine/ColorMine', data, updateScore);
		
		var data2 = {
			method: 'complement',
			type: 'rgb',
			value1: normalize(colorA.val()),
			value2: normalize(colorB.val())
		};
		
		$.get('/ColorMine/ColorMine', data2, isComplement);

	}

	$('#colorPickerA').farbtastic(function(color) { compare(colorA, color); });
	$('#colorPickerB').farbtastic(function(color) { compare(colorB, color); });
});
