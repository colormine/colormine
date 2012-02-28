$(document).ready(function() {
	$('input:file').fileupload({
		datatype: 'json',
		url: './ColorProfile',
		done: function(e,data) {
			var out = "";
	        $.each(data.result, function (color, count) {
				out += "<div class='swatch' style='background-color: #" + color + ";'>" + count + "</div>";
	        });
	        $('#colors').hide().html(out).fadeIn();
		}
	})
});